package com.hellowd.core.model.http.req.store;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-14
 * Time : 오후 4:33
 * 해당 클래스에 대한 기능 설명
 */
@Data
public class StoreOperationReq {

    /**
     * 가맹점주 SEQ
     */
    @NotNull
    private Long rootSeq;

    /**
     * 준비금
     */
    @NotNull
    private Integer reserveFund;

    /**
     * 사용자 SEQ
     */
    @NotNull
    private Long userSeq;

    /**
     * 사용자 Type (0: Manager, 1: Employee)
     */
    @NotEmpty
    private String userType;
}
