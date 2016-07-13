package com.hellowd.core.model.res.Login;

import com.hellowd.core.model.entity.relation.UserManagerRelation;
import com.hellowd.core.model.http.ApiResult;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-11
 * Time : 오후 5:59
 * 해당 클래스에 대한 기능 설명
 */
@Data
@AllArgsConstructor
public class LoginRes extends ApiResult {
    private long seq;
    private String apiToken;

    public LoginRes(final ApiResult apiResult, final long seq, final String apiToken) {
        super.setSuccess(apiResult.isSuccess());
        super.setStatus(apiResult.getStatus());
        super.setMessage(apiResult.getMessage());

        this.setSeq(seq);
        this.setApiToken(apiToken);
    }
}
