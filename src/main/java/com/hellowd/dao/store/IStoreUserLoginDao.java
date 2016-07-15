package com.hellowd.dao.store;

import com.hellowd.core.model.entity.relation.StoreUserLoginRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-14
 * Time : 오후 6:11
 * 해당 클래스에 대한 기능 설명
 */
@Repository
public interface IStoreUserLoginDao extends JpaRepository<StoreUserLoginRelation, BigInteger> {
}
