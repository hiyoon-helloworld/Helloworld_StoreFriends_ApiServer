package com.hellowd.core.model.http;

import lombok.AllArgsConstructor;
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
public class ApiResult<T> {

    private boolean isSuccess;
    private int status;
    private String message;
    private T result;

    public ApiResult(final boolean isSuccess, final HttpStatus status) {
        ApiResult(isSuccess, status, null, null);
    }

    public ApiResult(final boolean isSuccess, final HttpStatus status, final String message) {
        ApiResult(isSuccess, status, message, null);
    }

    public ApiResult(final boolean isSuccess, final HttpStatus status, final String message, final T result) {
        ApiResult(isSuccess, status, message, result);
    }

    private void ApiResult(final boolean isSuccess, final HttpStatus status, final String message, final T result) {
        this.isSuccess = isSuccess;
        this.status = status.value();
        this.message = message;
        this.result = result;
    }
}
