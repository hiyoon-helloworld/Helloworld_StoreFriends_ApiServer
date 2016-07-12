package com.hellowd.core.model.entity.relation;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hellowd.core.model.entity.UserPosEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-11
 * Time : 오전 10:52
 * 해당 클래스에 대한 기능 설명
 */
@Data
@Entity
@Table(name = "user_pos")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class UserPosRelation extends UserPosEntity {

    @Access(AccessType.FIELD)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_seq", insertable = false, updatable = false)
    private UserManagerRelation userManager;
}
