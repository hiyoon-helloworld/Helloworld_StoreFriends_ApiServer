package com.hellowd.core.model.entity.relation;//package com.hellowd.model.entity;
//
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
///**
// * Created by Helloworld
// * User : hiyoon
// * Date : 2016-07-11
// * Time : 오전 10:07
// * 해당 클래스에 대한 기능 설명
// */
//@Entity
//@Table(name = "store_cid", schema = "sf_testbed", catalog = "")
//public class StoreCidEntity {
//    private long ownerSeq;
//    private long storeSeq;
//    private String cidNo;
//
//    @Basic
//    @Column(name = "owner_seq")
//    public long getOwnerSeq() {
//        return ownerSeq;
//    }
//
//    public void setOwnerSeq(long ownerSeq) {
//        this.ownerSeq = ownerSeq;
//    }
//
//    @Basic
//    @Column(name = "store_seq")
//    public long getStoreSeq() {
//        return storeSeq;
//    }
//
//    public void setStoreSeq(long storeSeq) {
//        this.storeSeq = storeSeq;
//    }
//
//    @Basic
//    @Column(name = "cid_no")
//    public String getCidNo() {
//        return cidNo;
//    }
//
//    public void setCidNo(String cidNo) {
//        this.cidNo = cidNo;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        StoreCidEntity that = (StoreCidEntity) o;
//
//        if (ownerSeq != that.ownerSeq) return false;
//        if (storeSeq != that.storeSeq) return false;
//        if (cidNo != null ? !cidNo.equals(that.cidNo) : that.cidNo != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = (int) (ownerSeq ^ (ownerSeq >>> 32));
//        result = 31 * result + (int) (storeSeq ^ (storeSeq >>> 32));
//        result = 31 * result + (cidNo != null ? cidNo.hashCode() : 0);
//        return result;
//    }
//}
