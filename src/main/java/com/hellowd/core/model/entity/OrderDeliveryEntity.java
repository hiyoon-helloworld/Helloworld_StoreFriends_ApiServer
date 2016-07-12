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
//@Table(name = "order_delivery")
public class OrderDeliveryEntity {
    private long orderSeq;
    private String collectYn;
    private Long collectEmployeeSeq;
    private String deliveryYn;
    private Long deliveryEmployeeSeq;
    private String deliveryEmployeeName;
    private String deliveryEmployeePhone;
    private Timestamp regdate;

    @Id
    @Column(name = "order_seq")
    public long getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(long orderSeq) {
        this.orderSeq = orderSeq;
    }

    @Basic
    @Column(name = "collect_yn", columnDefinition = "CHAR(1)")
    public String getCollectYn() {
        return collectYn;
    }

    public void setCollectYn(String collectYn) {
        this.collectYn = collectYn;
    }

    @Basic
    @Column(name = "collect_employee_seq")
    public Long getCollectEmployeeSeq() {
        return collectEmployeeSeq;
    }

    public void setCollectEmployeeSeq(Long collectEmployeeSeq) {
        this.collectEmployeeSeq = collectEmployeeSeq;
    }

    @Basic
    @Column(name = "delivery_yn", columnDefinition = "CHAR(1)")
    public String getDeliveryYn() {
        return deliveryYn;
    }

    public void setDeliveryYn(String deliveryYn) {
        this.deliveryYn = deliveryYn;
    }

    @Basic
    @Column(name = "delivery_employee_seq")
    public Long getDeliveryEmployeeSeq() {
        return deliveryEmployeeSeq;
    }

    public void setDeliveryEmployeeSeq(Long deliveryEmployeeSeq) {
        this.deliveryEmployeeSeq = deliveryEmployeeSeq;
    }

    @Basic
    @Column(name = "delivery_employee_name")
    public String getDeliveryEmployeeName() {
        return deliveryEmployeeName;
    }

    public void setDeliveryEmployeeName(String deliveryEmployeeName) {
        this.deliveryEmployeeName = deliveryEmployeeName;
    }

    @Basic
    @Column(name = "delivery_employee_phone")
    public String getDeliveryEmployeePhone() {
        return deliveryEmployeePhone;
    }

    public void setDeliveryEmployeePhone(String deliveryEmployeePhone) {
        this.deliveryEmployeePhone = deliveryEmployeePhone;
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

        OrderDeliveryEntity that = (OrderDeliveryEntity) o;

        if (orderSeq != that.orderSeq) return false;
        if (collectYn != null ? !collectYn.equals(that.collectYn) : that.collectYn != null) return false;
        if (collectEmployeeSeq != null ? !collectEmployeeSeq.equals(that.collectEmployeeSeq) : that.collectEmployeeSeq != null)
            return false;
        if (deliveryYn != null ? !deliveryYn.equals(that.deliveryYn) : that.deliveryYn != null) return false;
        if (deliveryEmployeeSeq != null ? !deliveryEmployeeSeq.equals(that.deliveryEmployeeSeq) : that.deliveryEmployeeSeq != null)
            return false;
        if (deliveryEmployeeName != null ? !deliveryEmployeeName.equals(that.deliveryEmployeeName) : that.deliveryEmployeeName != null)
            return false;
        if (deliveryEmployeePhone != null ? !deliveryEmployeePhone.equals(that.deliveryEmployeePhone) : that.deliveryEmployeePhone != null)
            return false;
        if (regdate != null ? !regdate.equals(that.regdate) : that.regdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderSeq ^ (orderSeq >>> 32));
        result = 31 * result + (collectYn != null ? collectYn.hashCode() : 0);
        result = 31 * result + (collectEmployeeSeq != null ? collectEmployeeSeq.hashCode() : 0);
        result = 31 * result + (deliveryYn != null ? deliveryYn.hashCode() : 0);
        result = 31 * result + (deliveryEmployeeSeq != null ? deliveryEmployeeSeq.hashCode() : 0);
        result = 31 * result + (deliveryEmployeeName != null ? deliveryEmployeeName.hashCode() : 0);
        result = 31 * result + (deliveryEmployeePhone != null ? deliveryEmployeePhone.hashCode() : 0);
        result = 31 * result + (regdate != null ? regdate.hashCode() : 0);
        return result;
    }
}
