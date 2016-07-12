package com.hellowd.core.model.res.Login;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-11
 * Time : 오후 5:59
 * 해당 클래스에 대한 기능 설명
 */
@Data
@AllArgsConstructor
public class LoginRes {
    private long seq;
    private String apiToken;
}
