package com.hellowd.controller.userManager;

import com.hellowd.core.model.entity.relation.UserManagerRelation;
import com.hellowd.core.model.http.common.ApiResult;
import com.hellowd.core.model.http.res.userManager.UserManagerRes;
import com.hellowd.service.login.UserManagerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-05
 * Time : 오후 6:41
 * 해당 클래스에 대한 기능 설명
 */
@RestController
@RequestMapping("/usermanager")
public class UserManagerController {

    @Autowired
    private UserManagerService userManagerService;

    @ApiOperation(value = "가맹점 정보조회", notes = "가맹점 정보를 조회합니다.", code = 200)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult getUserManager() {
        UserManagerRelation userManagerRelation = userManagerService.getUserManager();
        return new UserManagerRes(new ApiResult(true, HttpStatus.OK), userManagerRelation);
    }
}
