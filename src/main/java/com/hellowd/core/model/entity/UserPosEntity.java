package com.hellowd.core.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-11
 * Time : 오전 10:07
 * 해당 클래스에 대한 기능 설명
 */
@MappedSuperclass

//@Entity
//@Table(name = "user_pos")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class UserPosEntity {
    private long seq;
    private long managerSeq;
    private String type;
    private String macAddress;
    private String delYn;
    private Timestamp regdate;

    @Id
    @Column(name = "seq")
    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    @Basic
    @Column(name = "manager_seq")
    public long getManagerSeq() {
        return managerSeq;
    }

    public void setManagerSeq(long managerSeq) {
        this.managerSeq = managerSeq;
    }

    @Basic
    @Column(name = "type", columnDefinition = "CHAR(1)")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "mac_address")
    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    @Basic
    @Column(name = "del_yn", columnDefinition = "CHAR(1)")
    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    @Basic
    @Column(name = "regdate")
    public Timestamp getRegdate() {
        return regdate;
    }

    public void setRegdate(Timestamp regdate) {
        this.regdate = regdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPosEntity that = (UserPosEntity) o;

        if (seq != that.seq) return false;
        if (managerSeq != that.managerSeq) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (macAddress != null ? !macAddress.equals(that.macAddress) : that.macAddress != null) return false;
        if (delYn != null ? !delYn.equals(that.delYn) : that.delYn != null) return false;
        if (regdate != null ? !regdate.equals(that.regdate) : that.regdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seq ^ (seq >>> 32));
        result = 31 * result + (int) (managerSeq ^ (managerSeq >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (macAddress != null ? macAddress.hashCode() : 0);
        result = 31 * result + (delYn != null ? delYn.hashCode() : 0);
        result = 31 * result + (regdate != null ? regdate.hashCode() : 0);
        return result;
    }
}
