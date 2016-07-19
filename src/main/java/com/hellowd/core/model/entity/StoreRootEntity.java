package com.hellowd.core.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-19
 * Time : 오후 12:21
 * 해당 클래스에 대한 기능 설명
 */
@MappedSuperclass
//@Entity
//@javax.persistence.Table(name = "store_root", schema = "sf_testbed", catalog = "")
public class StoreRootEntity {
    private long seq;

    @Id
    @javax.persistence.Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    private long sellerSeq;

    @Basic
    @javax.persistence.Column(name = "seller_seq")
    public long getSellerSeq() {
        return sellerSeq;
    }

    public void setSellerSeq(long sellerSeq) {
        this.sellerSeq = sellerSeq;
    }

    private long managerSeq;

    @Basic
    @javax.persistence.Column(name = "manager_seq")
    public long getManagerSeq() {
        return managerSeq;
    }

    public void setManagerSeq(long managerSeq) {
        this.managerSeq = managerSeq;
    }

    private String name;

    @Basic
    @javax.persistence.Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String sfVer;

    @Basic
    @javax.persistence.Column(name = "sf_ver")
    public String getSfVer() {
        return sfVer;
    }

    public void setSfVer(String sfVer) {
        this.sfVer = sfVer;
    }

    private String status;

    @Basic
    @javax.persistence.Column(name = "status", columnDefinition = "CHAR(1)")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String bizappUseYn;

    @Basic
    @javax.persistence.Column(name = "bizapp_use_yn", columnDefinition = "CHAR(1)")
    public String getBizappUseYn() {
        return bizappUseYn;
    }

    public void setBizappUseYn(String bizappUseYn) {
        this.bizappUseYn = bizappUseYn;
    }

    private String delYn;

    @Basic
    @javax.persistence.Column(name = "del_yn", columnDefinition = "CHAR(1)")
    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    private Timestamp regdate;

    @Basic
    @javax.persistence.Column(name = "regdate")
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

        StoreRootEntity that = (StoreRootEntity) o;

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
