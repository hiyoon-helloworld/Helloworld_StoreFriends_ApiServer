package com.hellowd.controller.Login;

import com.hellowd.core.exception.UnauthorizedException;
import com.hellowd.core.model.entity.UserManagerEntity;
import com.hellowd.core.model.http.ApiResult;
import com.hellowd.core.model.req.security.AuthenticationRequest;
import com.hellowd.core.model.res.Login.LoginRes;
import com.hellowd.core.security.JWT;
import com.hellowd.core.security.UserManagerAuthenticationToken;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-11
 * Time : 오후 5:46
 * 해당 클래스에 대한 기능 설명
 */
@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired private JWT jwt;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "사용자 로그인 (API토큰 필요없음)", notes = "필수값: principal, (EMAIL의 경우) credentials")
    public LoginRes authentication(@RequestBody AuthenticationRequest authReqeuest) throws UnauthorizedException {
        try {
            Authentication authentication = new UserManagerAuthenticationToken(authReqeuest);
            authentication = authenticationManager.authenticate(authentication);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserManagerEntity userManagerEntity = (UserManagerEntity) authentication.getDetails();
            String token = jwt.generateToken(claims(userManagerEntity, authentication.getAuthorities()));

            return new LoginRes(new ApiResult(true, HttpStatus.OK), userManagerEntity.getSeq(), token);
        } catch (AuthenticationException e) {
            throw new UnauthorizedException(e.getMessage());
        }
    }
    private Map<String, Object> claims(UserManagerEntity userManagerEntity, Collection<? extends GrantedAuthority> roles) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("name", userManagerEntity.getSeq());
        claims.put("roles", roles);
        return claims;
    }
}
