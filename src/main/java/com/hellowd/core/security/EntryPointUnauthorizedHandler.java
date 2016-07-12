/**
 * @Author yboklee (lyb1495@helloworlds.co.kr)
 */
package com.hellowd.core.security;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.hellowd.core.model.http.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {

    private static ApiResult apiResult = new ApiResult(false, HttpStatus.UNAUTHORIZED, "Access denied", null);

    @Autowired private MappingJackson2HttpMessageConverter converter;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        ObjectMapper om = converter.getObjectMapper();
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setHeader("content-type", "application/json");
        response.getWriter().write(om.writeValueAsString(apiResult));
        response.getWriter().flush();
        response.getWriter().close();
    }

}