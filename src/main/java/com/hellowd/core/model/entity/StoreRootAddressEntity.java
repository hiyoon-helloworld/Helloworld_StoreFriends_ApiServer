package com.hellowd.core.model.entity;

import javax.persistence.*;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-19
 * Time : 오후 12:21
 * 해당 클래스에 대한 기능 설명
 */
@MappedSuperclass
//@Entity
//@javax.persistence.Table(name = "store_root_address", schema = "sf_testbed", catalog = "")
public class StoreRootAddressEntity {
    private long seq;

    @Id
    @javax.persistence.Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    private long rootSeq;

    @Basic
    @javax.persistence.Column(name = "root_seq")
    public long getRootSeq() {
        return rootSeq;
    }

    public void setRootSeq(long rootSeq) {
        this.rootSeq = rootSeq;
    }

    private String type;

    @Basic
    @javax.persistence.Column(name = "type", columnDefinition = "CHAR(1)")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String postcode;

    @Basic
    @javax.persistence.Column(name = "postcode")
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    private String zonecode;

    @Basic
    @javax.persistence.Column(name = "zonecode")
    public String getZonecode() {
        return zonecode;
    }

    public void setZonecode(String zonecode) {
        this.zonecode = zonecode;
    }

    private String bcode;

    @Basic
    @javax.persistence.Column(name = "bcode")
    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    private String bname;

    @Basic
    @javax.persistence.Column(name = "bname")
    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    private String bldgCode;

    @Basic
    @javax.persistence.Column(name = "bldg_code")
    public String getBldgCode() {
        return bldgCode;
    }

    public void setBldgCode(String bldgCode) {
        this.bldgCode = bldgCode;
    }

    private String bldgName;

    @Basic
    @javax.persistence.Column(name = "bldg_name")
    public String getBldgName() {
        return bldgName;
    }

    public void setBldgName(String bldgName) {
        this.bldgName = bldgName;
    }

    private String postAddress;

    @Basic
    @javax.persistence.Column(name = "post_address")
    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    private String legacyPostAddress;

    @Basic
    @javax.persistence.Column(name = "legacy_post_address")
    public String getLegacyPostAddress() {
        return legacyPostAddress;
    }

    public void setLegacyPostAddress(String legacyPostAddress) {
        this.legacyPostAddress = legacyPostAddress;
    }

    private String detailPostAddress;

    @Basic
    @javax.persistence.Column(name = "detail_post_address")
    public String getDetailPostAddress() {
        return detailPostAddress;
    }

    public void setDetailPostAddress(String detailPostAddress) {
        this.detailPostAddress = detailPostAddress;
    }

    private String gpsLat;

    @Basic
    @javax.persistence.Column(name = "gps_lat")
    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    private String gpsLng;

    @Basic
    @javax.persistence.Column(name = "gps_lng")
    public String getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoreRootAddressEntity that = (StoreRootAddressEntity) o;

        if (seq != that.seq) return false;
        if (rootSeq != that.rootSeq) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
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

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seq ^ (seq >>> 32));
        result = 31 * result + (int) (rootSeq ^ (rootSeq >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
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
        return result;
    }
}
