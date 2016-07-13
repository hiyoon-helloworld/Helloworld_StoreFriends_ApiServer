package com.hellowd.core.model.entity;

import javax.persistence.*;
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
//@Table(name = "store_seller")
public class StoreSellerEntity {
    private long seq;
    private long adminSeq;
    private Long parentSeq;
    private String name;
    private String phone;
    private String useYn;
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
    @Column(name = "admin_seq")
    public long getAdminSeq() {
        return adminSeq;
    }

    public void setAdminSeq(long adminSeq) {
        this.adminSeq = adminSeq;
    }

    @Basic
    @Column(name = "parent_seq")
    public Long getParentSeq() {
        return parentSeq;
    }

    public void setParentSeq(Long parentSeq) {
        this.parentSeq = parentSeq;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "use_yn", columnDefinition = "CHAR(1)")
    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
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

        StoreSellerEntity that = (StoreSellerEntity) o;

        if (seq != that.seq) return false;
        if (adminSeq != that.adminSeq) return false;
        if (parentSeq != null ? !parentSeq.equals(that.parentSeq) : that.parentSeq != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (useYn != null ? !useYn.equals(that.useYn) : that.useYn != null) return false;
        if (delYn != null ? !delYn.equals(that.delYn) : that.delYn != null) return false;
        if (regdate != null ? !regdate.equals(that.regdate) : that.regdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seq ^ (seq >>> 32));
        result = 31 * result + (int) (adminSeq ^ (adminSeq >>> 32));
        result = 31 * result + (parentSeq != null ? parentSeq.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (useYn != null ? useYn.hashCode() : 0);
        result = 31 * result + (delYn != null ? delYn.hashCode() : 0);
        result = 31 * result + (regdate != null ? regdate.hashCode() : 0);
        return result;
    }
}
