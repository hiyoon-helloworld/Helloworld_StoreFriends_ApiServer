package com.hellowd.service.store;

import com.hellowd.core.model.entity.relation.StoreOperationRelation;
import com.hellowd.core.model.entity.relation.StoreUserLoginRelation;
import com.hellowd.core.model.entity.relation.UserManagerRelation;
import com.hellowd.core.model.http.common.ApiResult;
import com.hellowd.core.model.http.req.storeOperation.StoreOperationReq;
import com.hellowd.core.model.type.HttpStatusType;
import com.hellowd.core.utils.DatetimeUtils;
import com.hellowd.dao.store.IStoreOperationDao;
import com.hellowd.dao.store.IStoreUserLoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-14
 * Time : 오후 4:23
 * 해당 클래스에 대한 기능 설명
 */
@Service
public class StoreOperationService {

    /**
     * IStoreOperationDao
     */
    @Autowired
    private IStoreOperationDao storeOperationDao;
    /**
     * IStoreUserLoginDao
     */
    @Autowired
    private IStoreUserLoginDao storeUserLoginDao;

    /**
     * 운영 시작을 합니다.
     * @param storeOperationReq 가맹점 정보
     * @return 운영시작 결과
     */
    @Transactional
    public HttpStatusType.OPERATION_STATUS_TYPE setReserveFund(final StoreOperationReq storeOperationReq) {
        // 지역변수
        String searchDate = DatetimeUtils.getStrToday();

        // 운영시간 시작 가능 여부를 판단합니다.
        HttpStatusType.OPERATION_STATUS_TYPE operationStatusType = isOperStartable(storeOperationReq, searchDate);

        // 운영시간 정보 및 사용자정보를 등록합니다.
        if (operationStatusType == HttpStatusType.OPERATION_STATUS_TYPE.OK) {
            // 운영시간 정보 셋팅
            StoreOperationRelation storeOperation = new StoreOperationRelation();
            storeOperation.setOwnerSeq(storeOperationReq.getOwnerSeq());
            storeOperation.setOperDate(searchDate);
            storeOperation.setStartDate(new Date());
            storeOperation.setReserveFund(storeOperationReq.getReserveFund());

            // 등록
            storeOperationDao.save(storeOperation);

            // 사용자 정보 셋팅
            StoreUserLoginRelation storeUserLogin = new StoreUserLoginRelation();
            storeUserLogin.setLoginDate(new Date());
            storeUserLogin.setUserSeq(storeOperationReq.getUserSeq());
            storeUserLogin.setUserType(storeOperationReq.getUserType());
            storeUserLogin.setStoreOperation(storeOperation);

            // 등록
            storeUserLoginDao.save(storeUserLogin);
        }

        // 결과값을 반환합니다.
        return operationStatusType;
    }

    /**
     * 운영시작이 가능한지 여부를 판단합니다.
     * @param storeOperationReq 가맹점 정보
     * @param searchDate 운영시작할 날짜
     * @return 운영시작 가능여부
     */
    private HttpStatusType.OPERATION_STATUS_TYPE isOperStartable(final StoreOperationReq storeOperationReq, final String searchDate) {
        // 지역변수
        HttpStatusType.OPERATION_STATUS_TYPE operationStatusType = HttpStatusType.OPERATION_STATUS_TYPE.OK;

        // 현재 가맹점의 운영시간 정보를 가져옵니다.
        List<StoreOperationRelation> storeOperationRelationList =
                storeOperationDao.getListByOwnerSeqAndOperDate(storeOperationReq.getOwnerSeq(),
                        searchDate);


        // 운영시간 시작 가능 여부를 판단합니다.
        int operCntDuringToday = 0;
        for (StoreOperationRelation storeOperation : storeOperationRelationList) {
            if (storeOperation.getEndDate() == null) {
                operationStatusType = HttpStatusType.OPERATION_STATUS_TYPE.IS_BUSINESS_NOW;
                break;
            }
            if (storeOperation.getStartDate() != null &&
                    storeOperation.getEndDate() != null &&
                    storeOperation.getOperDate().equals(searchDate)) {
                operCntDuringToday++;
            }
        }

        // 하루에 2번까지 영업시작을 할 수 있다.
        if (operCntDuringToday > 1) {
            operationStatusType = HttpStatusType.OPERATION_STATUS_TYPE.CAN_OPEN_TWICE_PER_DAY;
        }
        return operationStatusType;
    }

}
