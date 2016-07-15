package com.hellowd.core.model.entity;

import javax.persistence.*;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-15
 * Time : 오전 10:30
 * 해당 클래스에 대한 기능 설명
 */
@MappedSuperclass
//@Entity
//@Table(name = "store_cid", schema = "sf_testbed", catalog = "")
public class StoreCidEntity {
    private long seq;
    private String cidNo;

    @Id
    @Column(name = "seq")
    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    @Basic
    @Column(name = "cid_no")
    public String getCidNo() {
        return cidNo;
    }

    public void setCidNo(String cidNo) {
        this.cidNo = cidNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoreCidEntity that = (StoreCidEntity) o;

        if (seq != that.seq) return false;
        if (cidNo != null ? !cidNo.equals(that.cidNo) : that.cidNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seq ^ (seq >>> 32));
        result = 31 * result + (cidNo != null ? cidNo.hashCode() : 0);
        return result;
    }
}
