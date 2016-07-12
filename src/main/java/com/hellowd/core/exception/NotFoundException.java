/**
 * @Author yboklee (lyb1495@helloworlds.co.kr)
 */
package com.hellowd.core.exception;

import com.hellowd.service.common.MessageSourceService;
import org.apache.commons.lang3.StringUtils;

public class NotFoundException extends ServiceRuntimeException {

    public static final String MESSAGE_KEY = "error.not.found";
    public static final String MESSAGE_DETAIL = "error.not.found.detail";

    public NotFoundException(String targetName, Object... values) {
        super(MESSAGE_KEY, MESSAGE_DETAIL,
                new String[]{targetName, (values != null && values.length > 0) ? StringUtils.join(values, ",") : "N/A"});
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
