package com.hellowd.core.model.entity;

import javax.persistence.*;
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
//@Table(name = "user_cid_address")
public class UserCidAddressEntity {
    private long seq;
    private long cidSeq;
    private String postcode;
    private String zonecode;
    private String bcode;
    private String bname;
    private String bldgCode;
    private String bldgName;
    private String postAddress;
    private String legacyPostAddress;
    private String detailPostAddress;
    private String gpsLat;
    private String gpsLng;
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
    @Column(name = "cid_seq")
    public long getCidSeq() {
        return cidSeq;
    }

    public void setCidSeq(long cidSeq) {
        this.cidSeq = cidSeq;
    }

    @Basic
    @Column(name = "postcode")
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Basic
    @Column(name = "zonecode")
    public String getZonecode() {
        return zonecode;
    }

    public void setZonecode(String zonecode) {
        this.zonecode = zonecode;
    }

    @Basic
    @Column(name = "bcode")
    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    @Basic
    @Column(name = "bname")
    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    @Basic
    @Column(name = "bldg_code")
    public String getBldgCode() {
        return bldgCode;
    }

    public void setBldgCode(String bldgCode) {
        this.bldgCode = bldgCode;
    }

    @Basic
    @Column(name = "bldg_name")
    public String getBldgName() {
        return bldgName;
    }

    public void setBldgName(String bldgName) {
        this.bldgName = bldgName;
    }

    @Basic
    @Column(name = "post_address")
    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    @Basic
    @Column(name = "legacy_post_address")
    public String getLegacyPostAddress() {
        return legacyPostAddress;
    }

    public void setLegacyPostAddress(String legacyPostAddress) {
        this.legacyPostAddress = legacyPostAddress;
    }

    @Basic
    @Column(name = "detail_post_address")
    public String getDetailPostAddress() {
        return detailPostAddress;
    }

    public void setDetailPostAddress(String detailPostAddress) {
        this.detailPostAddress = detailPostAddress;
    }

    @Basic
    @Column(name = "gps_lat")
    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    @Basic
    @Column(name = "gps_lng")
    public String getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
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

        UserCidAddressEntity that = (UserCidAddressEntity) o;

        if (seq != that.seq) return false;
        if (cidSeq != that.cidSeq) return false;
        if (postcode != null ? !postcode.equals(that.postcode) : that.postcode != null) return false;
        if (zonecode != null ? !zonecode.equals(that.zonecode) : that.zonecode != null) return false;
        if (bcode != null ? !bcode.equals(that.bcode) : that.bcode != null) return false;
        if (bname != null ? !bname.equals(that.bname) : that.bname != null) return false;
        if (bldgCode != null ? !bldgCode.equals(that.bldgCode) : that.bldgCode != null) return false;
        if (bldgName != null ? !bldgName.equals(that.bldgName) : that.bldgName != null) return false;
        if (postAddress != null ? !postAddress.equals(that.postAddress) : that.postAddress != null) return false;
        if (legacyPostAddress != null ? !legacyPostAddress.equals(that.legacyPostAddress) : that.legacyPostAddress != null)
            return false;
        if (detailPostAddress != null ? !detailPostAddress.equals(that.detailPostAddress) : that.detailPostAddress != null)
            return false;
        if (gpsLat != null ? !gpsLat.equals(that.gpsLat) : that.gpsLat != null) return false;
        if (gpsLng != null ? !gpsLng.equals(that.gpsLng) : that.gpsLng != null) return false;
        if (regdate != null ? !regdate.equals(that.regdate) : that.regdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seq ^ (seq >>> 32));
        result = 31 * result + (int) (cidSeq ^ (cidSeq >>> 32));
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (zonecode != null ? zonecode.hashCode() : 0);
        result = 31 * result + (bcode != null ? bcode.hashCode() : 0);
        result = 31 * result + (bname != null ? bname.hashCode() : 0);
        result = 31 * result + (bldgCode != null ? bldgCode.hashCode() : 0);
        result = 31 * result + (bldgName != null ? bldgName.hashCode() : 0);
        result = 31 * result + (postAddress != null ? postAddress.hashCode() : 0);
        result = 31 * result + (legacyPostAddress != null ? legacyPostAddress.hashCode() : 0);
        result = 31 * result + (detailPostAddress != null ? detailPostAddress.hashCode() : 0);
        result = 31 * result + (gpsLat != null ? gpsLat.hashCode() : 0);
        result = 31 * result + (gpsLng != null ? gpsLng.hashCode() : 0);
        result = 31 * result + (regdate != null ? regdate.hashCode() : 0);
        return result;
    }
}
