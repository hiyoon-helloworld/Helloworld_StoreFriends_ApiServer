package com.hellowd.core.model.entity;

import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;
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
//@javax.persistence.Table(name = "order")
public class OrderEntity {
    private long seq;

    @Id
    @javax.persistence.Column(name = "seq")
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

    private long storeSeq;

    @Basic
    @javax.persistence.Column(name = "store_seq")
    public long getStoreSeq() {
        return storeSeq;
    }

    public void setStoreSeq(long storeSeq) {
        this.storeSeq = storeSeq;
    }

    private long cidSeq;

    @Basic
    @javax.persistence.Column(name = "cid_seq")
    public long getCidSeq() {
        return cidSeq;
    }

    public void setCidSeq(long cidSeq) {
        this.cidSeq = cidSeq;
    }

    private Long floorSeq;

    @Basic
    @javax.persistence.Column(name = "floor_seq")
    public Long getFloorSeq() {
        return floorSeq;
    }

    public void setFloorSeq(Long floorSeq) {
        this.floorSeq = floorSeq;
    }

    private Long tableSeq;

    @Basic
    @javax.persistence.Column(name = "table_seq")
    public Long getTableSeq() {
        return tableSeq;
    }

    public void setTableSeq(Long tableSeq) {
        this.tableSeq = tableSeq;
    }

    private long orderNo;

    @Basic
    @javax.persistence.Column(name = "order_no")
    public long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(long orderNo) {
        this.orderNo = orderNo;
    }

    private String paymentType;

    @Basic
    @javax.persistence.Column(name = "payment_type", columnDefinition = "CHAR(1)")
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    private String statusOrder;

    @Basic
    @javax.persistence.Column(name = "status_order", columnDefinition = "CHAR(1)")
    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    private String statusRefund;

    @Basic
    @javax.persistence.Column(name = "status_refund", columnDefinition = "CHAR(1)")
    public String getStatusRefund() {
        return statusRefund;
    }

    public void setStatusRefund(String statusRefund) {
        this.statusRefund = statusRefund;
    }

    private String paynowOrderYn;

    @Basic
    @javax.persistence.Column(name = "paynow_order_yn", columnDefinition = "CHAR(1)")
    public String getPaynowOrderYn() {
        return paynowOrderYn;
    }

    public void setPaynowOrderYn(String paynowOrderYn) {
        this.paynowOrderYn = paynowOrderYn;
    }

    private String paynowMemo;

    @Basic
    @javax.persistence.Column(name = "paynow_memo")
    public String getPaynowMemo() {
        return paynowMemo;
    }

    public void setPaynowMemo(String paynowMemo) {
        this.paynowMemo = paynowMemo;
    }

    private String paynowAdvance;

    @Basic
    @javax.persistence.Column(name = "paynow_advance", columnDefinition = "CHAR(1)")
    public String getPaynowAdvance() {
        return paynowAdvance;
    }

    public void setPaynowAdvance(String paynowAdvance) {
        this.paynowAdvance = paynowAdvance;
    }

    private String orderPath;

    @Basic
    @javax.persistence.Column(name = "order_path", columnDefinition = "CHAR(1)")
    public String getOrderPath() {
        return orderPath;
    }

    public void setOrderPath(String orderPath) {
        this.orderPath = orderPath;
    }

    private String orderRejectMessage;

    @Basic
    @javax.persistence.Column(name = "order_reject_message")
    public String getOrderRejectMessage() {
        return orderRejectMessage;
    }

    public void setOrderRejectMessage(String orderRejectMessage) {
        this.orderRejectMessage = orderRejectMessage;
    }

    private Integer totalPrice;

    @Basic
    @javax.persistence.Column(name = "total_price")
    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    private String discountType;

    @Basic
    @javax.persistence.Column(name = "discount_type", columnDefinition = "CHAR(1)")
    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    private Integer discountPrice;

    @Basic
    @javax.persistence.Column(name = "discount_price")
    public Integer getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Integer discountPrice) {
        this.discountPrice = discountPrice;
    }

    private BigDecimal discountRate;

    @Basic
    @javax.persistence.Column(name = "discount_rate")
    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    private Integer usePoint;

    @Basic
    @javax.persistence.Column(name = "use_point")
    public Integer getUsePoint() {
        return usePoint;
    }

    public void setUsePoint(Integer usePoint) {
        this.usePoint = usePoint;
    }

    private Integer paymentPrice;

    @Basic
    @javax.persistence.Column(name = "payment_price")
    public Integer getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(Integer paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

    private Integer savePoint;

    @Basic
    @javax.persistence.Column(name = "save_point")
    public Integer getSavePoint() {
        return savePoint;
    }

    public void setSavePoint(Integer savePoint) {
        this.savePoint = savePoint;
    }

    private String nopayYn;

    @Basic
    @javax.persistence.Column(name = "nopay_yn", columnDefinition = "CHAR(1)")
    public String getNopayYn() {
        return nopayYn;
    }

    public void setNopayYn(String nopayYn) {
        this.nopayYn = nopayYn;
    }

    private Timestamp moddate;

    @Basic
    @javax.persistence.Column(name = "moddate")
    public Timestamp getModdate() {
        return moddate;
    }

    public void setModdate(Timestamp moddate) {
        this.moddate = moddate;
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

        OrderEntity that = (OrderEntity) o;

        if (seq != that.seq) return false;
        if (sellerSeq != that.sellerSeq) return false;
        if (storeSeq != that.storeSeq) return false;
        if (cidSeq != that.cidSeq) return false;
        if (orderNo != that.orderNo) return false;
        if (floorSeq != null ? !floorSeq.equals(that.floorSeq) : that.floorSeq != null) return false;
        if (tableSeq != null ? !tableSeq.equals(that.tableSeq) : that.tableSeq != null) return false;
        if (paymentType != null ? !paymentType.equals(that.paymentType) : that.paymentType != null) return false;
        if (statusOrder != null ? !statusOrder.equals(that.statusOrder) : that.statusOrder != null) return false;
        if (statusRefund != null ? !statusRefund.equals(that.statusRefund) : that.statusRefund != null) return false;
        if (paynowOrderYn != null ? !paynowOrderYn.equals(that.paynowOrderYn) : that.paynowOrderYn != null)
            return false;
        if (paynowMemo != null ? !paynowMemo.equals(that.paynowMemo) : that.paynowMemo != null) return false;
        if (paynowAdvance != null ? !paynowAdvance.equals(that.paynowAdvance) : that.paynowAdvance != null)
            return false;
        if (orderPath != null ? !orderPath.equals(that.orderPath) : that.orderPath != null) return false;
        if (orderRejectMessage != null ? !orderRejectMessage.equals(that.orderRejectMessage) : that.orderRejectMessage != null)
            return false;
        if (totalPrice != null ? !totalPrice.equals(that.totalPrice) : that.totalPrice != null) return false;
        if (discountType != null ? !discountType.equals(that.discountType) : that.discountType != null) return false;
        if (discountPrice != null ? !discountPrice.equals(that.discountPrice) : that.discountPrice != null)
            return false;
        if (discountRate != null ? !discountRate.equals(that.discountRate) : that.discountRate != null) return false;
        if (usePoint != null ? !usePoint.equals(that.usePoint) : that.usePoint != null) return false;
        if (paymentPrice != null ? !paymentPrice.equals(that.paymentPrice) : that.paymentPrice != null) return false;
        if (savePoint != null ? !savePoint.equals(that.savePoint) : that.savePoint != null) return false;
        if (nopayYn != null ? !nopayYn.equals(that.nopayYn) : that.nopayYn != null) return false;
        if (moddate != null ? !moddate.equals(that.moddate) : that.moddate != null) return false;
        if (regdate != null ? !regdate.equals(that.regdate) : that.regdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seq ^ (seq >>> 32));
        result = 31 * result + (int) (sellerSeq ^ (sellerSeq >>> 32));
        result = 31 * result + (int) (storeSeq ^ (storeSeq >>> 32));
        result = 31 * result + (int) (cidSeq ^ (cidSeq >>> 32));
        result = 31 * result + (floorSeq != null ? floorSeq.hashCode() : 0);
        result = 31 * result + (tableSeq != null ? tableSeq.hashCode() : 0);
        result = 31 * result + (int) (orderNo ^ (orderNo >>> 32));
        result = 31 * result + (paymentType != null ? paymentType.hashCode() : 0);
        result = 31 * result + (statusOrder != null ? statusOrder.hashCode() : 0);
        result = 31 * result + (statusRefund != null ? statusRefund.hashCode() : 0);
        result = 31 * result + (paynowOrderYn != null ? paynowOrderYn.hashCode() : 0);
        result = 31 * result + (paynowMemo != null ? paynowMemo.hashCode() : 0);
        result = 31 * result + (paynowAdvance != null ? paynowAdvance.hashCode() : 0);
        result = 31 * result + (orderPath != null ? orderPath.hashCode() : 0);
        result = 31 * result + (orderRejectMessage != null ? orderRejectMessage.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (discountType != null ? discountType.hashCode() : 0);
        result = 31 * result + (discountPrice != null ? discountPrice.hashCode() : 0);
        result = 31 * result + (discountRate != null ? discountRate.hashCode() : 0);
        result = 31 * result + (usePoint != null ? usePoint.hashCode() : 0);
        result = 31 * result + (paymentPrice != null ? paymentPrice.hashCode() : 0);
        result = 31 * result + (savePoint != null ? savePoint.hashCode() : 0);
        result = 31 * result + (nopayYn != null ? nopayYn.hashCode() : 0);
        result = 31 * result + (moddate != null ? moddate.hashCode() : 0);
        result = 31 * result + (regdate != null ? regdate.hashCode() : 0);
        return result;
    }
}
