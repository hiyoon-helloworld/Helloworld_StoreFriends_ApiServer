package com.hellowd.core.model.http.res.store;

import com.hellowd.core.model.entity.relation.StoreRelation;
import com.hellowd.core.model.http.common.ApiResult;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-19
 * Time : 오후 3:53
 * 해당 클래스에 대한 기능 설명
 */
public class StoreRes extends ApiResult {

    private StoreRelation store;

    public StoreRes(final ApiResult apiResult, final StoreRelation storeRelation) {

        // API Result 값을 셋팅합니다.
        super.setSuccess(apiResult.isSuccess());
        super.setStatus(apiResult.getStatus());
        super.setMessage(apiResult.getMessage());

        this.store = new StoreRelation();
        this.store.setSeq(storeRelation.getSeq());
        this.store.setName(storeRelation.getName());
        this.store.setCategory(storeRelation.getCategory());
    }
}
