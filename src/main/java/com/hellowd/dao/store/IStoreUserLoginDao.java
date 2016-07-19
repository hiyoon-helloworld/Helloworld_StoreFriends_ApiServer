package com.hellowd.dao.store;

import com.hellowd.core.model.entity.relation.StoreUserLoginRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-14
 * Time : 오후 6:11
 * 해당 클래스에 대한 기능 설명
 */
@Repository
public interface IStoreUserLoginDao extends JpaRepository<StoreUserLoginRelation, BigInteger> {

    /**
     * 영업마감 처리
     * @param ownerSeq
     * @param logoutDate
     */
    @Modifying
    @Query(nativeQuery = true,
            value = "update store_user_login set logout_date = :logoutDate " +
            "where operation_seq in (select seq from store_operation where root_seq = :rootSeq) and logout_date is null")
    void updateLogoutDateByRootSeq(@Param("rootSeq") long ownerSeq, @Param("logoutDate") Date logoutDate);


    /**
     * 영업마감 취소처리
     * @param rootSeq
     */
    @Modifying
    @Query(nativeQuery = true,
            value = "update store_user_login\n" +
                    "set \n" +
                    "logout_date = null \n" +
                    "where seq = (select t.seq from(select max(sul.seq) as seq " +
                    "from store_operation so inner join store_user_login sul on so.seq = sul.operation_seq " +
                    "where so.root_seq = :rootSeq and sul.user_seq = :userSeq) as t)")
    void updateLogoutDateNullByRootSeqAndUserSeq(@Param("rootSeq") long rootSeq, @Param("userSeq") long userSeq);
}
