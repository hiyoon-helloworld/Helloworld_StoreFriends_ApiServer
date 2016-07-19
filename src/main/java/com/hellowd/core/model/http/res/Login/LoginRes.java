package com.hellowd.core.model.http.res.login;

import com.hellowd.core.model.http.common.ApiResult;
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

    /**
     * 사장님 PK Seq
     */
    private long seq;

    /**
     * 인증 토큰
     */
    private String apiToken;

    /**
     * 로그인 성공시 반환객체 셋팅
     * @param apiResult 결과정보
     * @param seq 사 PK Seq
     * @param apiToken 인증 토큰
     */
    public LoginRes(final ApiResult apiResult, final long seq, final String apiToken) {
        // 결과값 셋팅
        super.setSuccess(apiResult.isSuccess());
        super.setStatus(apiResult.getStatus());
        super.setMessage(apiResult.getMessage());

        // 사장님 PK Seq, 인증토큰 셋팅
        this.setSeq(seq);
        this.setApiToken(apiToken);
    }
}
