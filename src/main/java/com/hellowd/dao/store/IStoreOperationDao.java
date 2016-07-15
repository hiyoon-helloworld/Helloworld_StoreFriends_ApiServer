package com.hellowd.dao.store;

import com.hellowd.core.model.entity.relation.StoreOperationRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-14
 * Time : 오후 4:51
 * 해당 클래스에 대한 기능 설명
 */
@Repository
public interface IStoreOperationDao extends JpaRepository<StoreOperationRelation, BigInteger> {

    /**
     * 가맹점 영업중 상태인지 여부를 판단하기 위한 목록 조회
     * @param ownerSeq
     * @param operDate
     * @return
     */
    @Query("select u from StoreOperationRelation u where u.ownerSeq = :ownerSeq and (u.endDate is null or u.operDate = :operDate)")
    List<StoreOperationRelation> getListForStoreOpen(@Param("ownerSeq") long ownerSeq,
                                                              @Param("operDate") String operDate);

    /**
     * 가맹점 영업마감 상태인지 여부를 판단하기 위한 목록 조회
     * @param ownerSeq
     * @param operDate
     * @return
     */
    @Query("select u from StoreOperationRelation u where u.ownerSeq = :ownerSeq and (u.endDate is not null or u.operDate = :operDate)")
    List<StoreOperationRelation> getListForStoreClose(@Param("ownerSeq") long ownerSeq,
                                                              @Param("operDate") String operDate);

    /**
     * 영업중인지 여부를 판단하기 위한 조회
     * @param ownerSeq
     * @return
     */
    @Query
    List<StoreOperationRelation> findByOwnerSeqAndEndDateIsNotNull(@Param("ownerSeq") long ownerSeq);

    /**
     * 영업마감 처리
     * @param ownerSeq
     * @param endDate
     */
    @Modifying
    @Query("update StoreOperationRelation u set u.endDate = :endDate where u.ownerSeq = :ownerSeq and u.endDate is null")
    void updateEndDateByOwnerSeq(@Param("ownerSeq") long ownerSeq, @Param("endDate") Date endDate);

    /**
     * 영업마감 취소처리
     * @param ownerSeq
     */
    @Modifying
    @Query(nativeQuery = true,
            value = "update\n" +
                    "\tstore_operation\n" +
                    "set \n" +
                    "end_date = null\n" +
                    "where seq in (select t.seq from (select max(seq) as seq from store_operation where owner_seq = :ownerSeq) as t)")
    void updateEndDateNullByOwnerSeq(@Param("ownerSeq") long ownerSeq);
}
