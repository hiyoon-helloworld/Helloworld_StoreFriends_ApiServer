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
//@Table(name = "mapping_menu_option", schema = "sf_testbed", catalog = "")
public class MappingMenuOptionEntity {
    private long seq;
    private String type;
    private long menuSeq;
    private long optionSeq;

    @Id
    @Column(name = "seq")
    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MappingMenuOptionEntity that = (MappingMenuOptionEntity) o;

        if (seq != that.seq) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seq ^ (seq >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "menu_seq")
    public long getMenuSeq() {
        return menuSeq;
    }

    public void setMenuSeq(long menuSeq) {
        this.menuSeq = menuSeq;
    }

    @Basic
    @Column(name = "option_seq")
    public long getOptionSeq() {
        return optionSeq;
    }

    public void setOptionSeq(long optionSeq) {
        this.optionSeq = optionSeq;
    }
}
