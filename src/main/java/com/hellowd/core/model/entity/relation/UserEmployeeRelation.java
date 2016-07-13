package com.hellowd.core.model.entity.relation;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hellowd.core.model.entity.UserEmployeeEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-13
 * Time : 오후 3:29
 * 해당 클래스에 대한 기능 설명
 */
@Data
@Entity
@Table(name = "user_employee")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class UserEmployeeRelation extends UserEmployeeEntity {

    @Access(AccessType.FIELD)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_seq", insertable = false, updatable = false)
    private UserManagerRelation userManager;

}
