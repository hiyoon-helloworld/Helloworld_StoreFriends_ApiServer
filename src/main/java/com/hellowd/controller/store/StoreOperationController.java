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
import javax.validation.constraints.NotNull;

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

    @ApiOperation(value = "영업시작", notes = "영업시작(담당자로그인 및 준비금을 설정)합니다.", code = 200)
    @RequestMapping(path = "openStore", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult openStore(@RequestBody @Valid final StoreOperationReq storeOperationReq,
                                    final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidParameterException(ErrorUtils.bindingErrorConverter(bindingResult));
        }
        HttpStatusType.OPERATION_STATUS_TYPE operationStatusType = storeOperationService.openStore(storeOperationReq);
        return operationStatusType.getApiResult();
    }

    @ApiOperation(value = "영업종료", notes = "영업종료(담당자로그아웃)합니다.", code = 200)
    @RequestMapping(path = "closeStore", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult closeStore(@RequestParam("ownerSeq") final long ownerSeq) {
        HttpStatusType.OPERATION_STATUS_TYPE operationStatusType = storeOperationService.closeStore(ownerSeq);
        return operationStatusType.getApiResult();
    }

    @ApiOperation(value = "영업종료취소", notes = "영업종료를 취소합니다.", code = 200)
    @RequestMapping(path = "cancelCloseStore", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult cancelCloseStore(@RequestParam("ownerSeq") final long ownerSeq,
                                @RequestParam("userSeq") final long userSeq) {
        HttpStatusType.OPERATION_STATUS_TYPE operationStatusType = storeOperationService.cancelCloseStore(ownerSeq, userSeq);
        return operationStatusType.getApiResult();
    }

}
