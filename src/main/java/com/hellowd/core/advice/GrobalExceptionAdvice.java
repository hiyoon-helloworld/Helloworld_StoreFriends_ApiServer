package com.hellowd.core.advice;

import com.hellowd.core.exception.InternalServerException;
import com.hellowd.core.exception.InvalidParameterException;
import com.hellowd.core.model.http.common.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-11
 * Time : 오후 12:08
 * 해당 클래스에 대한 기능 설명
 */
@Slf4j
@ControllerAdvice
public class GrobalExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandler(HttpServletRequest req, Exception e) {
        log.error("URL: {}, Exception Message: {}", req.getRequestURL(), e.getMessage());
        return new ResponseEntity<>(new ApiResult(false, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity serverRuntimeExceptionHandler(HttpServletRequest req, InternalServerException e) {
        log.error("URL: {}, ServerRuntimeException Message: {}", req.getRequestURL(), e.getMessage());
        return new ResponseEntity<>(new ApiResult(false, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity parameterExceptionHandler(HttpServletRequest req, InvalidParameterException e) {
        log.error("URL: {}, ParameterException Message: {}", req.getRequestURL(), e.getMessage());
        return new ResponseEntity<>(new ApiResult(false, HttpStatus.BAD_REQUEST, e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
