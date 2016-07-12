package com.hellowd.core.model.entity;

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
//@Table(name = "store_owner")
public class StoreOwnerEntity {
    private long seq;
    private long sellerSeq;
    private long managerSeq;
    private String name;
    private String sfVer;
    private String status;
    private String bizappUseYn;
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
    @Column(name = "seller_seq")
    public long getSellerSeq() {
        return sellerSeq;
    }

    public void setSellerSeq(long sellerSeq) {
        this.sellerSeq = sellerSeq;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sf_ver")
    public String getSfVer() {
        return sfVer;
    }

    public void setSfVer(String sfVer) {
        this.sfVer = sfVer;
    }

    @Basic
    @Column(name = "status", columnDefinition = "CHAR(1)")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "bizapp_use_yn", columnDefinition = "CHAR(1)")
    public String getBizappUseYn() {
        return bizappUseYn;
    }

    public void setBizappUseYn(String bizappUseYn) {
        this.bizappUseYn = bizappUseYn;
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

        StoreOwnerEntity that = (StoreOwnerEntity) o;

        if (seq != that.seq) return false;
        if (sellerSeq != that.sellerSeq) return false;
        if (managerSeq != that.managerSeq) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (sfVer != null ? !sfVer.equals(that.sfVer) : that.sfVer != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (bizappUseYn != null ? !bizappUseYn.equals(that.bizappUseYn) : that.bizappUseYn != null) return false;
        if (delYn != null ? !delYn.equals(that.delYn) : that.delYn != null) return false;
        if (regdate != null ? !regdate.equals(that.regdate) : that.regdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seq ^ (seq >>> 32));
        result = 31 * result + (int) (sellerSeq ^ (sellerSeq >>> 32));
        result = 31 * result + (int) (managerSeq ^ (managerSeq >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sfVer != null ? sfVer.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (bizappUseYn != null ? bizappUseYn.hashCode() : 0);
        result = 31 * result + (delYn != null ? delYn.hashCode() : 0);
        result = 31 * result + (regdate != null ? regdate.hashCode() : 0);
        return result;
    }
}
