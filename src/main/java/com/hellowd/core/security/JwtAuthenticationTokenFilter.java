/**
 * @Author yboklee (lyb1495@helloworlds.co.kr)
 */
package com.hellowd.core.security;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.GenericFilterBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtAuthenticationTokenFilter extends GenericFilterBean {

    private static final Pattern BEARER = Pattern.compile("^Bearer$", Pattern.CASE_INSENSITIVE);

    @Value("${jwt.token.header}") private String tokenHeader;

    @Autowired private JWT jwt;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            String authorizationToken = extractAuthorizationToken(request);
            if (authorizationToken != null) {
                try {
                    Map<String, Object> claims = verify(authorizationToken);
                    if (log.isDebugEnabled())
                        log.debug("Jwt parse result: {}", claims);

                    Long name = MapUtils.getLong(claims, "name");
                    List<GrantedAuthority> authorities = getAuthorities(claims);

                    if (name != null && authorities.size() > 0) {
                        UserManagerAuthenticationToken authentication = new UserManagerAuthenticationToken(name, null, authorities);
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                } catch (Exception e) {
                    log.warn("Jwt processing failed: {}", e.getMessage());
                }
            }
        }
        else {
            if (log.isDebugEnabled()) {
                log.debug("SecurityContextHolder not populated with jwt token, as it already contained: '{}'",
                        SecurityContextHolder.getContext().getAuthentication());
            }
        }

        chain.doFilter(request, response);
    }

    @SuppressWarnings("unchecked")
    private List<GrantedAuthority> getAuthorities(Map<String, Object> claims) {
        Collection<Map<String, String>> authMaps = (Collection<Map<String, String>>) claims.get("roles");
        return authMaps.stream()
                .map(authMap -> new SimpleGrantedAuthority(MapUtils.getString(authMap, "authority", "ROLE_ANONYMOUS")))
                .collect(Collectors.toList());
    }

    protected String extractAuthorizationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        if (token != null) {
            if (log.isDebugEnabled())
                log.debug("Jwt authorization request detected: {}", token);
            String[] parts = token.split(" ");
            if (parts.length == 2) {
                String scheme = parts[0];
                String credentials = parts[1];
                return BEARER.matcher(scheme).matches() ? credentials : null;
            }
        }

        return null;
    }

    protected Map<String, Object> verify(String token) throws Exception {
        return jwt.verify(token);
    }

}