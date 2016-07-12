/**
 * @Author yboklee (lyb1495@helloworlds.co.kr)
 */
package com.hellowd.core.exception;


import com.hellowd.service.common.MessageSourceService;

public class InternalServerException extends ServiceRuntimeException {

    public static final String MESSAGE_KEY = "error.internal.server";
    public static final String MESSAGE_DETAIL = "error.internal.server.detail";

    public InternalServerException(Object... param) {
        super(MESSAGE_KEY, MESSAGE_DETAIL, param);
    }

    @Override
    public String getMessage() {
        return MessageSourceService.getInstance().getMessage(getDetailKey(), getParams());
    }

    @Override
    public String toString() {
        return MessageSourceService.getInstance().getMessage(getMessageKey());
    }

}
