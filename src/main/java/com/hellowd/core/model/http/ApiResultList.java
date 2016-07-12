package com.hellowd.core.model.http;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-11
 * Time : 오후 12:31
 * 해당 클래스에 대한 기능 설명
 */
@Data
@NoArgsConstructor
public class ApiResultList<T> {

    private boolean isSuccss;
    private HttpStatus status;
    private String message;
    private List<T> result;

    public ApiResultList(final boolean isSuccess, final HttpStatus status, final String message) {
        ApiResultList(isSuccess, status, message, null);
    }

    public ApiResultList(final boolean isSuccess, final HttpStatus status, final String message, final List<T> result) {
        ApiResultList(isSuccess, status, message, result);
    }

    private void ApiResultList(final boolean isSuccess, final HttpStatus status, final String message, final List<T> result) {
        this.isSuccss = isSuccess;
        this.status = status;
        this.message = message;
        this.result = result;
    }
}
