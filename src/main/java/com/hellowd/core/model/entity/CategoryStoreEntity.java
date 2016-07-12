package com.hellowd.core.model.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-11
 * Time : 오전 10:07
 * 해당 클래스에 대한 기능 설명
 */
@MappedSuperclass
//@Entity
//@Table(name = "category_store")
public class CategoryStoreEntity {
    private long seq;
    private long categorySeq;
    private Long ownerSeq;
    private Long storeSeq;
    private String name;
    private String delYn;

    @Id
    @Column(name = "seq")
    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    @Basic
    @Column(name = "category_seq")
    public long getCategorySeq() {
        return categorySeq;
    }

    public void setCategorySeq(long categorySeq) {
        this.categorySeq = categorySeq;
    }

    @Basic
    @Column(name = "owner_seq")
    public Long getOwnerSeq() {
        return ownerSeq;
    }

    public void setOwnerSeq(Long ownerSeq) {
        this.ownerSeq = ownerSeq;
    }

    @Basic
    @Column(name = "store_seq")
    public Long getStoreSeq() {
        return storeSeq;
    }

    public void setStoreSeq(Long storeSeq) {
        this.storeSeq = storeSeq;
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
    @Column(name = "del_yn", columnDefinition = "CHAR(1)")
    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryStoreEntity that = (CategoryStoreEntity) o;

        if (seq != that.seq) return false;
        if (categorySeq != that.categorySeq) return false;
        if (ownerSeq != null ? !ownerSeq.equals(that.ownerSeq) : that.ownerSeq != null) return false;
        if (storeSeq != null ? !storeSeq.equals(that.storeSeq) : that.storeSeq != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (delYn != null ? !delYn.equals(that.delYn) : that.delYn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seq ^ (seq >>> 32));
        result = 31 * result + (int) (categorySeq ^ (categorySeq >>> 32));
        result = 31 * result + (ownerSeq != null ? ownerSeq.hashCode() : 0);
        result = 31 * result + (storeSeq != null ? storeSeq.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (delYn != null ? delYn.hashCode() : 0);
        return result;
    }
}
