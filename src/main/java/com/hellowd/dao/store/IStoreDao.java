package com.hellowd.dao.store;

import com.hellowd.core.model.entity.StoreEntity;
import com.hellowd.core.model.entity.relation.StoreRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-19
 * Time : 오전 11:45
 * 해당 클래스에 대한 기능 설명
 */
@Repository
public interface IStoreDao extends JpaRepository<StoreEntity, BigInteger> {

    List<StoreRelation> findAllByRootSeq(@Param("rootSeq") long rootSeq);

}
