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
//@Table(name = "store_mobile_web")
public class StoreMobileWebEntity {
    private long storeSeq;
    private long ownerSeq;
    private String name;
    private String run24Yn;
    private String openYearRoundYn;
    private String openTime;
    private String closeTime;
    private String offWeek;
    private String offDay;
    private Timestamp tmpOffStartdate;
    private Timestamp tmpOffEnddate;
    private Timestamp startDate;
    private Timestamp endDate;
    private String useYn;
    private Timestamp regdate;

    @Id
    @Column(name = "store_seq")
    public long getStoreSeq() {
        return storeSeq;
    }

    public void setStoreSeq(long storeSeq) {
        this.storeSeq = storeSeq;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "run24_yn", columnDefinition = "CHAR(1)")
    public String getRun24Yn() {
        return run24Yn;
    }

    public void setRun24Yn(String run24Yn) {
        this.run24Yn = run24Yn;
    }

    @Basic
    @Column(name = "open_year_round_yn", columnDefinition = "CHAR(1)")
    public String getOpenYearRoundYn() {
        return openYearRoundYn;
    }

    public void setOpenYearRoundYn(String openYearRoundYn) {
        this.openYearRoundYn = openYearRoundYn;
    }

    @Basic
    @Column(name = "open_time", columnDefinition = "CHAR(4)")
    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    @Basic
    @Column(name = "close_time", columnDefinition = "CHAR(4)")
    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    @Basic
    @Column(name = "off_week", columnDefinition = "CHAR(1)")
    public String getOffWeek() {
        return offWeek;
    }

    public void setOffWeek(String offWeek) {
        this.offWeek = offWeek;
    }

    @Basic
    @Column(name = "off_day", columnDefinition = "CHAR(1)")
    public String getOffDay() {
        return offDay;
    }

    public void setOffDay(String offDay) {
        this.offDay = offDay;
    }

    @Basic
    @Column(name = "tmp_off_startdate")
    public Timestamp getTmpOffStartdate() {
        return tmpOffStartdate;
    }

    public void setTmpOffStartdate(Timestamp tmpOffStartdate) {
        this.tmpOffStartdate = tmpOffStartdate;
    }

    @Basic
    @Column(name = "tmp_off_enddate")
    public Timestamp getTmpOffEnddate() {
        return tmpOffEnddate;
    }

    public void setTmpOffEnddate(Timestamp tmpOffEnddate) {
        this.tmpOffEnddate = tmpOffEnddate;
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
    @Column(name = "use_yn", columnDefinition = "CHAR(1)")
    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
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

        StoreMobileWebEntity that = (StoreMobileWebEntity) o;

        if (storeSeq != that.storeSeq) return false;
        if (ownerSeq != that.ownerSeq) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (run24Yn != null ? !run24Yn.equals(that.run24Yn) : that.run24Yn != null) return false;
        if (openYearRoundYn != null ? !openYearRoundYn.equals(that.openYearRoundYn) : that.openYearRoundYn != null)
            return false;
        if (openTime != null ? !openTime.equals(that.openTime) : that.openTime != null) return false;
        if (closeTime != null ? !closeTime.equals(that.closeTime) : that.closeTime != null) return false;
        if (offWeek != null ? !offWeek.equals(that.offWeek) : that.offWeek != null) return false;
        if (offDay != null ? !offDay.equals(that.offDay) : that.offDay != null) return false;
        if (tmpOffStartdate != null ? !tmpOffStartdate.equals(that.tmpOffStartdate) : that.tmpOffStartdate != null)
            return false;
        if (tmpOffEnddate != null ? !tmpOffEnddate.equals(that.tmpOffEnddate) : that.tmpOffEnddate != null)
            return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (useYn != null ? !useYn.equals(that.useYn) : that.useYn != null) return false;
        if (regdate != null ? !regdate.equals(that.regdate) : that.regdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (storeSeq ^ (storeSeq >>> 32));
        result = 31 * result + (int) (ownerSeq ^ (ownerSeq >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (run24Yn != null ? run24Yn.hashCode() : 0);
        result = 31 * result + (openYearRoundYn != null ? openYearRoundYn.hashCode() : 0);
        result = 31 * result + (openTime != null ? openTime.hashCode() : 0);
        result = 31 * result + (closeTime != null ? closeTime.hashCode() : 0);
        result = 31 * result + (offWeek != null ? offWeek.hashCode() : 0);
        result = 31 * result + (offDay != null ? offDay.hashCode() : 0);
        result = 31 * result + (tmpOffStartdate != null ? tmpOffStartdate.hashCode() : 0);
        result = 31 * result + (tmpOffEnddate != null ? tmpOffEnddate.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (useYn != null ? useYn.hashCode() : 0);
        result = 31 * result + (regdate != null ? regdate.hashCode() : 0);
        return result;
    }
}
