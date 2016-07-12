/**
 * @Author yboklee (lyb1495@helloworlds.co.kr)
 */
package com.hellowd.core.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    @SuppressWarnings("unchecked")
    public <T> T me() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof UserManagerAuthenticationToken)
            return (T) authentication.getPrincipal();
        return null;
    }

}
