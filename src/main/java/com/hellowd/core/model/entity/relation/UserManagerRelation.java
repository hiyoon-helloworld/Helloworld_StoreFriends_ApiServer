package com.hellowd.core.model.entity.relation;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hellowd.core.model.entity.UserManagerEntity;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-11
 * Time : 오전 10:48
 * 해당 클래스에 대한 기능 설명
 */
@Data
@Entity
@Table(name = "user_manager")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class UserManagerRelation extends UserManagerEntity {

    @OneToMany(mappedBy = "userManager", fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @Access(AccessType.FIELD)
    private List<UserPosRelation> userPosList;

    @OneToMany(mappedBy = "userManager", fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @Access(AccessType.FIELD)
    private List<UserEmployeeRelation> userEmployeeList;
}
