package com.hellowd.controller.login;

import com.hellowd.core.exception.UnauthorizedException;
import com.hellowd.core.model.entity.UserManagerEntity;
import com.hellowd.core.model.http.common.ApiResult;
import com.hellowd.core.model.http.req.security.AuthenticationRequest;
import com.hellowd.core.model.http.res.Login.LoginRes;
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
    @ApiOperation(value = "사용자 로그인 (API토큰 필요없음)", notes = "필수값: principal, credentials")
    public LoginRes authentication(@RequestBody AuthenticationRequest authReqeuest) throws UnauthorizedException {
        try {
            // TODO: 2016-07-14 아래 로직은 전체적으로 수정예정
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

    /**
     * 토큰 생성을 위한 name과 role을 설정합니다.
     * @param userManagerEntity 사장님 정보
     * @param roles 권한
     * @return name 및 role 정보.
     */
    private Map<String, Object> claims(UserManagerEntity userManagerEntity, Collection<? extends GrantedAuthority> roles) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("name", userManagerEntity.getSeq());
        claims.put("roles", roles);
        return claims;
    }

    /**
     * 비밀번호 찾기
     * @return 결과값
     */
    @RequestMapping(path = "/findpassword", method = RequestMethod.POST)
    @ApiOperation(value = "비밀번호찾기", notes = "필수값: principal, credentials")
    public ApiResult findPassword() {
        // TODO: 2016-07-14 비밀번호 생성 후 문자 전송.

        // 결과값 전송
        return new ApiResult(true, HttpStatus.OK);
    }
}
