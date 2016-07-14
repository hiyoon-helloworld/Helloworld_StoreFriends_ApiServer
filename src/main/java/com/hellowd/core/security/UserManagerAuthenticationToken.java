/**
 * @Author yboklee (lyb1495@helloworlds.co.kr)
 */
package com.hellowd.core.security;

import java.util.Collection;

import com.hellowd.core.model.http.req.security.AuthenticationRequest;
import com.hellowd.core.model.type.Device;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class UserManagerAuthenticationToken extends AbstractAuthenticationToken {

    private final Object principal;
    private String credentials;
    private Device device;

    public UserManagerAuthenticationToken(AuthenticationRequest authRequest) {
        this(authRequest.getPrincipal(), authRequest.getCredentials(), authRequest.getDevice());
    }

    public UserManagerAuthenticationToken(Object principal, String credentials, Device device) {
        super(null);
        super.setAuthenticated(false);

        this.principal = principal;
        this.credentials = credentials;
        this.device = device;
    }

    public UserManagerAuthenticationToken(Object principal, String credentials,
                                          Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        super.setAuthenticated(true);

        this.principal = principal;
        this.credentials = credentials;
    }

    AuthenticationRequest authenticationRequest() {
        return new AuthenticationRequest(principal, credentials, device);
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException(
                    "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }
        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        credentials = null;
    }

}