package com.hellowd.service.store;

import com.hellowd.core.exception.InternalServerException;
import com.hellowd.core.model.entity.relation.StoreOperationRelation;
import com.hellowd.core.model.entity.relation.StoreUserLoginRelation;
import com.hellowd.core.model.http.req.store.StoreOperationReq;
import com.hellowd.core.model.type.HttpStatusType;
import com.hellowd.core.utils.DatetimeUtils;
import com.hellowd.dao.store.IStoreOperationDao;
import com.hellowd.dao.store.IStoreUserLoginDao;
import com.sun.javafx.binding.StringFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * 영업 시작 합니다.
     * @param storeOperationReq 가맹점 정보
     * @return 영업 시작 결과
     */
    @Transactional
    public HttpStatusType.OPERATION_STATUS_TYPE openStore(final StoreOperationReq storeOperationReq) {

        // 지역변수
        String searchDate = DatetimeUtils.getStrToday();
        HttpStatusType.OPERATION_STATUS_TYPE operationStatusType = HttpStatusType.OPERATION_STATUS_TYPE.OK;

        try {
            // 운영시간 시작 가능 여부를 판단합니다.
            operationStatusType = isStoreOpenable(storeOperationReq, searchDate);

            // 운영시간 정보 및 사용자정보를 등록합니다.
            if (operationStatusType == HttpStatusType.OPERATION_STATUS_TYPE.OK) {
                // 운영시간 정보 셋팅
                StoreOperationRelation storeOperation = new StoreOperationRelation();
                storeOperation.setRootSeq(storeOperationReq.getRootSeq());
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
        } catch (Exception ex) {
            throw new InternalServerException(StringFormatter.format("parameter: {}, stacktrace: {}",
                    storeOperationReq.toString(), ex.getMessage()));
        }

        // 결과값을 반환합니다.
        return operationStatusType;
    }

    /**
     * 영업 종료합니다.
     * @param rootSeq 가맹점주 SEQ
     * @return 영업 종료 결과
     */
    @Transactional
    public HttpStatusType.OPERATION_STATUS_TYPE closeStore(final long rootSeq) {

        // 지역변수
        String searchDate = DatetimeUtils.getStrToday();
        Date logoutDate = new Date();
        HttpStatusType.OPERATION_STATUS_TYPE operationStatusType = HttpStatusType.OPERATION_STATUS_TYPE.OK;

        try {
            // 운영시간 종료 가능 여부를 판단합니다.
            operationStatusType = isStoreClosable(rootSeq, searchDate);

            // 운영시간 정보 및 사용자정보를 등록합니다.
            if (operationStatusType == HttpStatusType.OPERATION_STATUS_TYPE.OK) {
                storeOperationDao.updateEndDateByRootSeq(rootSeq, logoutDate);
                storeUserLoginDao.updateLogoutDateByRootSeq(rootSeq, logoutDate);
            }
        } catch (Exception ex) {
            throw new InternalServerException(String.format("rootSeq: %s, stacktrace: %s",
                    rootSeq, ex.getMessage()));
        }

        // 결과값을 반환합니다.
        return operationStatusType;
    }

    /**
     * 영업 종료를 취소합니다.
     * @param rootSeq 가맹점주 SEQ
     * @return 영업 종료 취소 결과
     */
    @Transactional
    public HttpStatusType.OPERATION_STATUS_TYPE cancelCloseStore(final long rootSeq, final long userSeq) {

        // 지역변수
        String searchDate = DatetimeUtils.getStrToday();
        Date logoutDate = new Date();
        HttpStatusType.OPERATION_STATUS_TYPE operationStatusType = HttpStatusType.OPERATION_STATUS_TYPE.OK;

        try {
            if (!this.isOpenStore(rootSeq)) { // 현재 영업 종료중이라면 취소 가능하므로 처리한다.
                storeOperationDao.updateEndDateNullByRootSeq(rootSeq);
                storeUserLoginDao.updateLogoutDateNullByRootSeqAndUserSeq(rootSeq, userSeq);

            } else { // 현재 영업 중이라면 영업취소를 할 수는 없다.
                operationStatusType = HttpStatusType.OPERATION_STATUS_TYPE.IS_OPEN_NOW;
            }
        } catch (Exception ex) {
            throw new InternalServerException(String.format("rootSeq: %s, stacktrace: %s",
                    rootSeq, ex.getMessage()));
        }

        // 결과값을 반환합니다.
        return operationStatusType;
    }

    /**
     * 운영 시작 가능 여부를 판단합니다.
     * @param storeOperationReq 가맹점 정보
     * @param searchDate 운영시작할 날짜
     * @return 운영시작 가능여부
     */
    private HttpStatusType.OPERATION_STATUS_TYPE isStoreOpenable(final StoreOperationReq storeOperationReq,
                                                                 final String searchDate) {
        // 지역변수
        HttpStatusType.OPERATION_STATUS_TYPE operationStatusType = HttpStatusType.OPERATION_STATUS_TYPE.OK;

        // 현재 가맹점의 운영시간 정보를 가져옵니다.
        List<StoreOperationRelation> storeOperationRelationList =
                storeOperationDao.findAllForStoreOpen(storeOperationReq.getRootSeq(),
                        searchDate);

        // 운영시간 시작 가능 여부를 판단합니다.
        int operCntDuringToday = 0;
        for (StoreOperationRelation storeOperation : storeOperationRelationList) {
            if (storeOperation.getEndDate() == null) {
                operationStatusType = HttpStatusType.OPERATION_STATUS_TYPE.IS_OPEN_NOW;
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

    /**
     * 운영 종료 가능 여부를 판단합니다.
     * @param rootSeq 가맹점주 SEQ
     * @param searchDate 운영종료할 날짜
     * @return
     */
    private HttpStatusType.OPERATION_STATUS_TYPE isStoreClosable(final long rootSeq, final String searchDate) {
        // 지역변수
        HttpStatusType.OPERATION_STATUS_TYPE operationStatusType = HttpStatusType.OPERATION_STATUS_TYPE.OK;

        // 현재 가맹점의 운영시간 정보를 가져옵니다.
        List<StoreOperationRelation> storeOperationRelationList =
                storeOperationDao.findAllForStoreClose(rootSeq,
                        searchDate);

        // 운영시간 종료 가능 여부를 판단합니다.
        int openCnt = 0;
        int closeCntDuringToday = 0;
        for (StoreOperationRelation storeOperation : storeOperationRelationList) {
            if (storeOperation.getEndDate() == null) {
                openCnt++;
            }
            if (storeOperation.getStartDate() != null &&
                    storeOperation.getEndDate() != null &&
                    storeOperation.getOperDate().equals(searchDate)) {
                closeCntDuringToday++;
            }
        }

        // 현재 종료중인지를 판단한다.
        if (openCnt < 1) {
            operationStatusType = HttpStatusType.OPERATION_STATUS_TYPE.IS_CLOSE_NOW;
        } else if (closeCntDuringToday > 0) {
            operationStatusType = HttpStatusType.OPERATION_STATUS_TYPE.CAN_CLOSE_ONCE_PER_DAY;
        }
        return operationStatusType;
    }

    /**
     * 운영 상태(시작, 종료)를 조회합니다..
     * @param rootSeq 가맹점주 SEQ
     * @return
     */
    private boolean isOpenStore(final long rootSeq) {

        // 지역변수
        boolean isOpenStore = false;

        // 현재 가맹점의 운영시간 정보를 가져옵니다.
        List<StoreOperationRelation> storeOperationRelationList = storeOperationDao.findByRootSeqAndEndDateIsNotNull(rootSeq);

        // End Date가 NotNull이 한 건이라도 있으면 운영중이다.
        if (storeOperationRelationList != null && storeOperationRelationList.size() > 1) {
            isOpenStore = false;
        }
        return isOpenStore;
    }

}
