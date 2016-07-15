package com.hellowd.controller.store;

import com.hellowd.core.exception.InvalidParameterException;
import com.hellowd.core.model.entity.relation.UserManagerRelation;
import com.hellowd.core.model.http.common.ApiResult;
import com.hellowd.core.model.http.req.storeOperation.StoreOperationReq;
import com.hellowd.core.model.http.res.userManager.UserManagerRes;
import com.hellowd.core.model.type.HttpStatusType;
import com.hellowd.core.utils.ErrorUtils;
import com.hellowd.service.store.StoreOperationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-14
 * Time : 오후 4:16
 * 해당 클래스에 대한 기능 설명
 */
@RestController
@RequestMapping("storeoperation")
public class StoreOperationController {

    @Autowired
    private StoreOperationService storeOperationService;

    @ApiOperation(value = "담당자로그인 및 준비금 설정", notes = "담당자로그인 및 준비금을 설정합니다.", code = 200)
    @RequestMapping(path = "reservefund", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult setReservefund(@RequestBody @Valid final StoreOperationReq storeOperationReq,
                                    final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidParameterException(ErrorUtils.bindingErrorConverter(bindingResult));
        }
        HttpStatusType.OPERATION_STATUS_TYPE operationStatusType = storeOperationService.setReserveFund(storeOperationReq);
        return operationStatusType.getApiResult();
    }

}
