package com.hellowd.core.model.entity.relation;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hellowd.core.model.entity.StoreUserLoginEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-14
 * Time : 오후 4:11
 * 해당 클래스에 대한 기능 설명
 */
@Data
@Entity
@Table(name = "store_user_login")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class StoreUserLoginRelation extends StoreUserLoginEntity {

    @Access(AccessType.FIELD)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operation_seq")
    private StoreOperationRelation storeOperation;
}
