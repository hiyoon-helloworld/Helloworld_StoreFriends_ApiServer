package com.hellowd.core.model.res.userManager;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hellowd.core.model.entity.UserManagerEntity;
import com.hellowd.core.model.entity.UserPosEntity;
import com.hellowd.core.model.entity.relation.UserManagerRelation;
import com.hellowd.core.model.entity.relation.UserPosRelation;
import com.hellowd.core.model.http.ApiResult;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-11
 * Time : 오후 2:50
 * 해당 클래스에 대한 기능 설명
 */
@Data
public class UserManagerRes extends ApiResult {

    private UserManagerRelation userManager;

    public UserManagerRes(final ApiResult apiResult, final UserManagerRelation userManagerRelation) {
        super.setSuccss(apiResult.isSuccss());
        super.setStatus(apiResult.getStatus());
        super.setMessage(apiResult.getMessage());

        userManager = new UserManagerRelation();
        userManager.setSeq(userManagerRelation.getSeq());
        userManager.setId(userManagerRelation.getId());

        List<UserPosRelation> userPorList = new ArrayList<>();
        List<UserPosRelation> userPorRelationList = userManagerRelation.getUserPosList();
        for (UserPosRelation userPosRelation : userPorRelationList) {
            UserPosRelation userPos = new UserPosRelation();
            userPos.setSeq(userPosRelation.getSeq());
            userPos.setManagerSeq(userPosRelation.getManagerSeq());
            userPos.setType(userPosRelation.getType());
            userPos.setMacAddress(userPosRelation.getMacAddress());
            userPorList.add(userPos);
        }
        userManager.setUserPosList(userPorList);
    }

}
