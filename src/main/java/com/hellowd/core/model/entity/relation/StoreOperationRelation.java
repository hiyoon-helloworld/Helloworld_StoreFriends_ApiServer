package com.hellowd.core.model.entity.relation;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hellowd.core.model.entity.StoreOperationEntity;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-14
 * Time : 오후 4:10
 * 해당 클래스에 대한 기능 설명
 */
@Data
@Entity
@Table(name = "store_operation")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class StoreOperationRelation extends StoreOperationEntity {

    @OneToMany(mappedBy = "storeOperation", fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @Access(AccessType.FIELD)
    private List<StoreUserLoginRelation> storeUserLoginList;

}
