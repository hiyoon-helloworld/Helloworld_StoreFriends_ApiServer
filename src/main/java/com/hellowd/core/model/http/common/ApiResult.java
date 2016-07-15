package com.hellowd.core.model.http.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-11
 * Time : 오후 12:31
 * 해당 클래스에 대한 기능 설명
 */
@Data
@NoArgsConstructor
public class ApiResult {

    /**
     * 성공여부
     */
    private boolean isSuccess;

    /**
     * Http Status Code
     */
    private int status;

    /**
     * 결과 메시지
     */
    private String message;

    /**
     * Http Api Result 를 셋팅합니다.
     * @param isSuccess 성공여부
     * @param status Status Code
     */
    public ApiResult(final boolean isSuccess, final int status) {
        ApiResult(isSuccess, status, null);
    }

    /**
     * Http Api Result 를 셋팅합니다.
     * @param isSuccess 성공여부
     * @param status Status Code
     */
    public ApiResult(final boolean isSuccess, final HttpStatus status) {
        ApiResult(isSuccess, status.value(), null);
    }

    /**
     * Http Api Result 를 셋팅합니다.
     * @param isSuccess 성공여부
     * @param status Status Code
     */
    public ApiResult(final boolean isSuccess, final int status, final String message) {
        ApiResult(isSuccess, status, message);
    }

    /**
     * Http Api Result 를 셋팅합니다.
     * @param isSuccess 성공여부
     * @param status Status Code
     */
    public ApiResult(final boolean isSuccess, final HttpStatus status, final String message) {
        ApiResult(isSuccess, status.value(), message);
    }

    /**
     * Http Api Result 를 셋팅합니다.
     * @param isSuccess 성공여부
     * @param status Status Code
     * @param message 결과 메시지
     */
    private void ApiResult(final boolean isSuccess, final int status, final String message) {
        this.isSuccess = isSuccess;
        this.status = status;
        this.message = message;
    }
}
