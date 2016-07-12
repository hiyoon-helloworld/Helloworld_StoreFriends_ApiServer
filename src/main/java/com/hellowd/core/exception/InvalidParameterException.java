/**
 * @Author yboklee (lyb1495@helloworlds.co.kr)
 */
package com.hellowd.core.exception;


import com.hellowd.service.common.MessageSourceService;

public class InvalidParameterException extends BadRequestException {

    public static final String MESSAGE_KEY = "error.invalid.parameter";
    public static final String MESSAGE_DETAIL = "error.invalid.parameter.detail";

    public InvalidParameterException(String param) {
        super(MESSAGE_KEY, MESSAGE_DETAIL, new Object[]{param, "N/A"});
    }

    public InvalidParameterException(String param, String cause) {
        super(MESSAGE_KEY, MESSAGE_DETAIL, new Object[]{param, cause});
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