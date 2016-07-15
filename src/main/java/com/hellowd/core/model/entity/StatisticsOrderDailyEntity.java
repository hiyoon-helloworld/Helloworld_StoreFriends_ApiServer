package com.hellowd.core.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-15
 * Time : 오전 10:30
 * 해당 클래스에 대한 기능 설명
 */
@MappedSuperclass
//@Entity
//@Table(name = "statistics_order_daily", schema = "sf_testbed", catalog = "")
public class StatisticsOrderDailyEntity {
    private long seq;
    private long ownerSeq;
    private long storeSeq;
    private String operdate;
    private String sales;
    private Timestamp startDate;
    private Timestamp endDate;
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
    @Column(name = "owner_seq")
    public long getOwnerSeq() {
        return ownerSeq;
    }

    public void setOwnerSeq(long ownerSeq) {
        this.ownerSeq = ownerSeq;
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
    @Column(name = "operdate")
    public String getOperdate() {
        return operdate;
    }

    public void setOperdate(String operdate) {
        this.operdate = operdate;
    }

    @Basic
    @Column(name = "sales")
    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    @Basic
    @Column(name = "start_date")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
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

        StatisticsOrderDailyEntity that = (StatisticsOrderDailyEntity) o;

        if (seq != that.seq) return false;
        if (ownerSeq != that.ownerSeq) return false;
        if (storeSeq != that.storeSeq) return false;
        if (operdate != null ? !operdate.equals(that.operdate) : that.operdate != null) return false;
        if (sales != null ? !sales.equals(that.sales) : that.sales != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (regdate != null ? !regdate.equals(that.regdate) : that.regdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seq ^ (seq >>> 32));
        result = 31 * result + (int) (ownerSeq ^ (ownerSeq >>> 32));
        result = 31 * result + (int) (storeSeq ^ (storeSeq >>> 32));
        result = 31 * result + (operdate != null ? operdate.hashCode() : 0);
        result = 31 * result + (sales != null ? sales.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (regdate != null ? regdate.hashCode() : 0);
        return result;
    }
}
