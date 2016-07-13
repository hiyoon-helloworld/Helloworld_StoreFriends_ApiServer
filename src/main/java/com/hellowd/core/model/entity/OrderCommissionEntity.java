package com.hellowd.core.model.entity;

import javax.persistence.*;
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
//@Table(name = "order_commission")
public class OrderCommissionEntity {
    private long orderSeq;
    private String type;
    private BigDecimal rate;
    private Integer price;
    private BigDecimal headRate;
    private int headPrice;
    private BigDecimal pgRate;
    private int pgPrice;
    private BigDecimal pgVatRate;
    private int pgVatPrice;
    private int smsPrice;
    private int sellerPrice;
    private int ownerPrice;
    private int transferPrice;
    private int chargePrice;
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
    @Column(name = "type", columnDefinition = "CHAR(1)")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "rate")
    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "head_rate")
    public BigDecimal getHeadRate() {
        return headRate;
    }

    public void setHeadRate(BigDecimal headRate) {
        this.headRate = headRate;
    }

    @Basic
    @Column(name = "head_price")
    public int getHeadPrice() {
        return headPrice;
    }

    public void setHeadPrice(int headPrice) {
        this.headPrice = headPrice;
    }

    @Basic
    @Column(name = "pg_rate")
    public BigDecimal getPgRate() {
        return pgRate;
    }

    public void setPgRate(BigDecimal pgRate) {
        this.pgRate = pgRate;
    }

    @Basic
    @Column(name = "pg_price")
    public int getPgPrice() {
        return pgPrice;
    }

    public void setPgPrice(int pgPrice) {
        this.pgPrice = pgPrice;
    }

    @Basic
    @Column(name = "pg_vat_rate")
    public BigDecimal getPgVatRate() {
        return pgVatRate;
    }

    public void setPgVatRate(BigDecimal pgVatRate) {
        this.pgVatRate = pgVatRate;
    }

    @Basic
    @Column(name = "pg_vat_price")
    public int getPgVatPrice() {
        return pgVatPrice;
    }

    public void setPgVatPrice(int pgVatPrice) {
        this.pgVatPrice = pgVatPrice;
    }

    @Basic
    @Column(name = "sms_price")
    public int getSmsPrice() {
        return smsPrice;
    }

    public void setSmsPrice(int smsPrice) {
        this.smsPrice = smsPrice;
    }

    @Basic
    @Column(name = "seller_price")
    public int getSellerPrice() {
        return sellerPrice;
    }

    public void setSellerPrice(int sellerPrice) {
        this.sellerPrice = sellerPrice;
    }

    @Basic
    @Column(name = "owner_price")
    public int getOwnerPrice() {
        return ownerPrice;
    }

    public void setOwnerPrice(int ownerPrice) {
        this.ownerPrice = ownerPrice;
    }

    @Basic
    @Column(name = "transfer_price")
    public int getTransferPrice() {
        return transferPrice;
    }

    public void setTransferPrice(int transferPrice) {
        this.transferPrice = transferPrice;
    }

    @Basic
    @Column(name = "charge_price")
    public int getChargePrice() {
        return chargePrice;
    }

    public void setChargePrice(int chargePrice) {
        this.chargePrice = chargePrice;
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

        OrderCommissionEntity that = (OrderCommissionEntity) o;

        if (orderSeq != that.orderSeq) return false;
        if (headPrice != that.headPrice) return false;
        if (pgPrice != that.pgPrice) return false;
        if (pgVatPrice != that.pgVatPrice) return false;
        if (smsPrice != that.smsPrice) return false;
        if (sellerPrice != that.sellerPrice) return false;
        if (ownerPrice != that.ownerPrice) return false;
        if (transferPrice != that.transferPrice) return false;
        if (chargePrice != that.chargePrice) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (rate != null ? !rate.equals(that.rate) : that.rate != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (headRate != null ? !headRate.equals(that.headRate) : that.headRate != null) return false;
        if (pgRate != null ? !pgRate.equals(that.pgRate) : that.pgRate != null) return false;
        if (pgVatRate != null ? !pgVatRate.equals(that.pgVatRate) : that.pgVatRate != null) return false;
        if (regdate != null ? !regdate.equals(that.regdate) : that.regdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderSeq ^ (orderSeq >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (headRate != null ? headRate.hashCode() : 0);
        result = 31 * result + headPrice;
        result = 31 * result + (pgRate != null ? pgRate.hashCode() : 0);
        result = 31 * result + pgPrice;
        result = 31 * result + (pgVatRate != null ? pgVatRate.hashCode() : 0);
        result = 31 * result + pgVatPrice;
        result = 31 * result + smsPrice;
        result = 31 * result + sellerPrice;
        result = 31 * result + ownerPrice;
        result = 31 * result + transferPrice;
        result = 31 * result + chargePrice;
        result = 31 * result + (regdate != null ? regdate.hashCode() : 0);
        return result;
    }
}
