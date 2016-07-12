/**
 * @Author yboklee (lyb1495@helloworlds.co.kr)
 */
package com.hellowd.core.security;

import java.util.Collection;

import com.hellowd.core.exception.NotFoundException;
import com.hellowd.core.model.entity.UserManagerEntity;
import com.hellowd.core.model.req.security.AuthenticationRequest;
import com.hellowd.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserManagerAuthenticationProvider implements AuthenticationProvider {

    @Value("${jwt.token.role}") private String role;

    @Autowired private LoginService loginService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        AuthenticationRequest authReqeuest = ((UserManagerAuthenticationToken) authentication).authenticationRequest();
        try {
            UserManagerEntity userManager = loginService.login(authReqeuest);
            //-- 인증 성공 처리
            userManager.setPasswd("[PROTECTED]");
            UserManagerAuthenticationToken authenticated = new UserManagerAuthenticationToken(userManager.getSeq(), null, generateAuthorities());
            authenticated.setDetails(userManager);
            return authenticated;
        } catch (NotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new BadCredentialsException(e.getMessage());
        } catch (DataAccessException e) {
            throw new AuthenticationServiceException(e.getMessage(), e);
        }
    }

    private Collection<GrantedAuthority> generateAuthorities() {
        return AuthorityUtils.createAuthorityList("ROLE_" + role);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UserManagerAuthenticationToken.class.isAssignableFrom(authentication);
    }

}