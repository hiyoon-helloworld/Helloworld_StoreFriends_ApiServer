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
//@Table(name = "store_table")
public class StoreTableEntity {
    private long seq;
    private long floorSeq;
    private long storeSeq;
    private String name;
    private Integer displayOrder;
    private String useYn;
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
    @Column(name = "floor_seq")
    public long getFloorSeq() {
        return floorSeq;
    }

    public void setFloorSeq(long floorSeq) {
        this.floorSeq = floorSeq;
    }

    @Basic
    @Column(name = "store_seq")
    public long getStoreSeq() {
        return storeSeq;
    }

    public void setStoreSeq(long storeSeq) {
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
    @Column(name = "display_order")
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoreTableEntity that = (StoreTableEntity) o;

        if (seq != that.seq) return false;
        if (floorSeq != that.floorSeq) return false;
        if (storeSeq != that.storeSeq) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (displayOrder != null ? !displayOrder.equals(that.displayOrder) : that.displayOrder != null) return false;
        if (useYn != null ? !useYn.equals(that.useYn) : that.useYn != null) return false;
        if (delYn != null ? !delYn.equals(that.delYn) : that.delYn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seq ^ (seq >>> 32));
        result = 31 * result + (int) (floorSeq ^ (floorSeq >>> 32));
        result = 31 * result + (int) (storeSeq ^ (storeSeq >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (displayOrder != null ? displayOrder.hashCode() : 0);
        result = 31 * result + (useYn != null ? useYn.hashCode() : 0);
        result = 31 * result + (delYn != null ? delYn.hashCode() : 0);
        return result;
    }
}
