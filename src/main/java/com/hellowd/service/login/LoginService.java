package com.hellowd.service.login;

import com.hellowd.core.exception.NotFoundException;
import com.hellowd.core.model.entity.UserManagerEntity;
import com.hellowd.core.model.http.req.security.AuthenticationRequest;
import com.hellowd.dao.user.IUserMangerDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.hellowd.core.utils.ValidatorUtils.*;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-11
 * Time : 오후 4:00
 * 해당 클래스에 대한 기능 설명
 */
@Service
public class LoginService {

    @Autowired
    private IUserMangerDao userMangerDao;

    @Transactional
    public UserManagerEntity login(AuthenticationRequest authReqeuest) {
        String principal = String.valueOf(authReqeuest.getPrincipal());
        String credentials = authReqeuest.getCredentials();

        throwIfEmptyOrNull("credentials", credentials, p -> StringUtils.isNotEmpty(credentials));

        UserManagerEntity managerEntity = userMangerDao.getOneByIdAndDelYnNot(principal, "N");
        if (managerEntity == null) {
            throw new NotFoundException(UserManagerEntity.class.getSimpleName(), principal);
        }
//        managerEntity.afterLoginSuccess(authReqeuest.getDevice());
//        appUserLoginLogRepository.save(new AppUserLoginLog(appUser));
        return managerEntity;
    }



}
