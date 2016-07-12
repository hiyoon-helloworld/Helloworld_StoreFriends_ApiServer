package com.hellowd.dao;

import com.hellowd.core.model.entity.UserManagerEntity;
import com.hellowd.core.model.entity.relation.UserManagerRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-11
 * Time : 오전 9:59
 * 해당 클래스에 대한 기능 설명
 */
@Repository
public interface IUserMangerDao extends JpaRepository<UserManagerRelation, BigInteger> {

    UserManagerRelation getOneBySeqAndDelYnNot(@Param("seq") long seq,
                                               @Param("delYn") String delYn);

    UserManagerEntity getOneByIdAndDelYnNot(@Param("id") String id,
                                            @Param("delYn") String delYn);

}
