package com.hellowd.controller.store;

import com.hellowd.core.exception.InvalidParameterException;
import com.hellowd.core.model.entity.relation.StoreRelation;
import com.hellowd.core.model.http.common.ApiResult;
import com.hellowd.core.model.http.req.store.StoreOperationReq;
import com.hellowd.core.model.http.res.store.StoreRes;
import com.hellowd.core.model.type.HttpStatusType;
import com.hellowd.core.utils.ErrorUtils;
import com.hellowd.service.store.StoreService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-19
 * Time : 오전 11:44
 * 해당 클래스에 대한 기능 설명
 */
@RestController
@RequestMapping("store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @ApiOperation(value = "매장정보 조회", notes = "매장정보를 조회합니다.", code = 200)
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public StoreRes openStore(@RequestParam("rootSeq") final long rootSeq) {

        StoreRelation storeRelation = storeService.getStoreInfo(rootSeq);
        return new StoreRes(new ApiResult(true, HttpStatus.OK), storeRelation);
    }

}
