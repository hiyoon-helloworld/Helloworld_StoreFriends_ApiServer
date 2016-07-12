/**
 * @Author yboklee (lyb1495@helloworlds.co.kr)
 */
package com.hellowd.core.model.req.security;

import com.hellowd.core.model.type.Device;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class AuthenticationRequest {

	@Getter
	@ApiModelProperty(value = "사용자 식별자(이메일 or 식별코드, FB코드)", required = true, dataType = "java.lang.String")
	private Object principal;

	@Getter
	@ApiModelProperty(value = "사용자 비밀번호(joinType이 EMAIL이라면 필수)")
	private String credentials;

	@Getter
	@ApiModelProperty(value = "디바이스정보")
	private Device device;

	protected AuthenticationRequest() {
	}

}
