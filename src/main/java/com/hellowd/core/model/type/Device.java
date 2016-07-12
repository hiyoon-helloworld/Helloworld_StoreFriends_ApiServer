/**
 * @Author yboklee (lyb1495@helloworlds.co.kr)
 */
package com.hellowd.core.model.type;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.sf.oval.constraint.Length;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
public class Device {

    @Column(name = "device")
    @Length(max = 100)
    @Getter
    @ApiModelProperty(value = "디바이스명")
    private String device;

    @Column(name = "os")
    @Length(max = 20)
    @Getter
    @ApiModelProperty(value = "운영체제")
    private String os;

    @Column(name = "ver")
    @Length(max = 11)
    @Getter
    @ApiModelProperty(value = "앱버전")
    private String ver;

    protected Device() {
        
    }
    
}
