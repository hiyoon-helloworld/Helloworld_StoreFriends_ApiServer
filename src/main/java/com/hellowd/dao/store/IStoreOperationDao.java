package com.hellowd.dao.store;

import com.hellowd.core.model.entity.relation.StoreOperationRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
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

    @Query("select u from StoreOperationRelation u where u.ownerSeq = :ownerSeq and (u.endDate is null or u.operDate = :operDate)")
    List<StoreOperationRelation> getListByOwnerSeqAndOperDate(@Param("ownerSeq") long ownerSeq,
                                                              @Param("operDate") String operDate);
}
