package com.hellowd.core.model.entity.relation;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hellowd.core.model.entity.StoreEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-19
 * Time : 오후 1:35
 * 해당 클래스에 대한 기능 설명
 */
@Data
@Entity
@Table(name = "store")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class StoreRelation extends StoreEntity {
}
