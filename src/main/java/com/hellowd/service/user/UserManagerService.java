package com.hellowd.service.user;

import com.hellowd.core.exception.InternalServerException;
import com.hellowd.core.exception.UnauthorizedException;
import com.hellowd.core.model.entity.relation.UserManagerRelation;
import com.hellowd.core.security.SecurityService;
import com.hellowd.dao.user.IUserMangerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-11
 * Time : 오전 9:59
 * 해당 클래스에 대한 기능 설명
 */
@Service
public class UserManagerService {

    @Autowired
    private SecurityService securityService;
    @Autowired
    private IUserMangerDao userManagerDao;

    @Transactional
    public UserManagerRelation getUserManager() {

        UserManagerRelation result = null;
        try {
            long seq = securityService.me();
            result = userManagerDao.getOneBySeqAndDelYnNot(seq, "N");
        } catch (DataAccessException ex) {
            throw new InternalServerException(ex.getLocalizedMessage());
        } catch (Exception ex) {
            throw new UnauthorizedException(ex.getLocalizedMessage());
        }
        return result;
    }


}
