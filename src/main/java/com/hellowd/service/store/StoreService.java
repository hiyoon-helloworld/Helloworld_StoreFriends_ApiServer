package com.hellowd.service.store;

import com.hellowd.core.exception.InternalServerException;
import com.hellowd.core.model.entity.relation.StoreRelation;
import com.hellowd.dao.store.IStoreDao;
import com.sun.javafx.binding.StringFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-19
 * Time : 오후 2:36
 * 해당 클래스에 대한 기능 설명
 */
@Service
public class StoreService {

    @Autowired
    private IStoreDao storeDao;

    @Transactional
    public StoreRelation getStoreInfo(final long rootSeq) {

        StoreRelation result = null;
        try {
            List<StoreRelation> storeList = storeDao.findAllByRootSeq(rootSeq);
            if (storeList != null && storeList.size() > 0) {
                result = storeList.get(0);
            }
        } catch (Exception ex) {
            throw new InternalServerException(StringFormatter.format("rootSeq: {}, stacktrace: {}",
                    rootSeq, ex.getMessage()));
        }

        // 결과값을 반환합니다.
        return result;
    }

}
