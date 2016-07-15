package com.hellowd.core.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import static java.util.stream.Collectors.joining;

/**
 * Created by Helloworld
 * User : wonwoo
 * Date : 2016-04-04
 * Time : 오후 12:19
 * desc :
 */
public class ErrorUtils {

    public static String bindingErrorConverter(final BindingResult bindingResult) {
        return bindingResult.getFieldErrors()
                .stream().map(ErrorUtils::converter)
                .collect(joining("\n"));
    }

    private static String converter(FieldError fieldError) {
        return new StringBuilder()
                .append("[")
                .append(fieldError.getField())
                .append("] ")
                .append(fieldError.getDefaultMessage())
                .toString();
    }
}
