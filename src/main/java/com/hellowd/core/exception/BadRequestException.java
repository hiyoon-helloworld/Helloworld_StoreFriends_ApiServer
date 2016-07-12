/**
 * @Author yboklee (lyb1495@helloworlds.co.kr)
 */
package com.hellowd.core.exception;

public abstract class BadRequestException extends ServiceRuntimeException {

    public BadRequestException(String messageKey, String detailKey, Object[] params) {
        super(messageKey, detailKey, params);
    }

    public abstract String getMessage();

}