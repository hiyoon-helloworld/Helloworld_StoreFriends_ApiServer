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
//@Table(name = "option_detail")
public class OptionDetailEntity {
    private long seq;
    private long optionSeq;
    private String name;
    private int price;
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
    @Column(name = "option_seq")
    public long getOptionSeq() {
        return optionSeq;
    }

    public void setOptionSeq(long optionSeq) {
        this.optionSeq = optionSeq;
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
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

        OptionDetailEntity that = (OptionDetailEntity) o;

        if (seq != that.seq) return false;
        if (optionSeq != that.optionSeq) return false;
        if (price != that.price) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (delYn != null ? !delYn.equals(that.delYn) : that.delYn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seq ^ (seq >>> 32));
        result = 31 * result + (int) (optionSeq ^ (optionSeq >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (delYn != null ? delYn.hashCode() : 0);
        return result;
    }
}
