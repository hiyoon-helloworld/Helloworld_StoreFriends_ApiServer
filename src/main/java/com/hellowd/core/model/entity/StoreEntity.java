package com.hellowd.core.model.entity;

import javax.persistence.Basic;
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
//@javax.persistence.Table(name = "store")
public class StoreEntity {
    private long seq;

    @Id
    @javax.persistence.Column(name = "seq")
    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    private long ownerSeq;

    @Basic
    @javax.persistence.Column(name = "owner_seq")
    public long getOwnerSeq() {
        return ownerSeq;
    }

    public void setOwnerSeq(long ownerSeq) {
        this.ownerSeq = ownerSeq;
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

    private String name;

    @Basic
    @javax.persistence.Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String phone;

    @Basic
    @javax.persistence.Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String cellPhone;

    @Basic
    @javax.persistence.Column(name = "cell_phone")
    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    private String virtualPhone;

    @Basic
    @javax.persistence.Column(name = "virtual_phone")
    public String getVirtualPhone() {
        return virtualPhone;
    }

    public void setVirtualPhone(String virtualPhone) {
        this.virtualPhone = virtualPhone;
    }

    private String storeType;

    @Basic
    @javax.persistence.Column(name = "store_type", columnDefinition = "CHAR(1)")
    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    private String ttsUseYn;

    @Basic
    @javax.persistence.Column(name = "tts_use_yn", columnDefinition = "CHAR(1)")
    public String getTtsUseYn() {
        return ttsUseYn;
    }

    public void setTtsUseYn(String ttsUseYn) {
        this.ttsUseYn = ttsUseYn;
    }

    private String ttsNotifyUseYn;

    @Basic
    @javax.persistence.Column(name = "tts_notify_use_yn", columnDefinition = "CHAR(1)")
    public String getTtsNotifyUseYn() {
        return ttsNotifyUseYn;
    }

    public void setTtsNotifyUseYn(String ttsNotifyUseYn) {
        this.ttsNotifyUseYn = ttsNotifyUseYn;
    }

    private String ttsPhone;

    @Basic
    @javax.persistence.Column(name = "tts_phone")
    public String getTtsPhone() {
        return ttsPhone;
    }

    public void setTtsPhone(String ttsPhone) {
        this.ttsPhone = ttsPhone;
    }

    private String ttsPhoneEtc;

    @Basic
    @javax.persistence.Column(name = "tts_phone_etc")
    public String getTtsPhoneEtc() {
        return ttsPhoneEtc;
    }

    public void setTtsPhoneEtc(String ttsPhoneEtc) {
        this.ttsPhoneEtc = ttsPhoneEtc;
    }

    private String category;

    @Basic
    @javax.persistence.Column(name = "category", columnDefinition = "CHAR(2)")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private String pushServerUrl;

    @Basic
    @javax.persistence.Column(name = "push_server_url")
    public String getPushServerUrl() {
        return pushServerUrl;
    }

    public void setPushServerUrl(String pushServerUrl) {
        this.pushServerUrl = pushServerUrl;
    }

    private Integer delvMinPrice;

    @Basic
    @javax.persistence.Column(name = "delv_min_price")
    public Integer getDelvMinPrice() {
        return delvMinPrice;
    }

    public void setDelvMinPrice(Integer delvMinPrice) {
        this.delvMinPrice = delvMinPrice;
    }

    private String delvAbleRegionAvbbv;

    @Basic
    @javax.persistence.Column(name = "delv_able_region_avbbv")
    public String getDelvAbleRegionAvbbv() {
        return delvAbleRegionAvbbv;
    }

    public void setDelvAbleRegionAvbbv(String delvAbleRegionAvbbv) {
        this.delvAbleRegionAvbbv = delvAbleRegionAvbbv;
    }

    private String logoImgUrl;

    @Basic
    @javax.persistence.Column(name = "logo_img_url")
    public String getLogoImgUrl() {
        return logoImgUrl;
    }

    public void setLogoImgUrl(String logoImgUrl) {
        this.logoImgUrl = logoImgUrl;
    }

    private String paperImgUrl;

    @Basic
    @javax.persistence.Column(name = "paper_img_url")
    public String getPaperImgUrl() {
        return paperImgUrl;
    }

    public void setPaperImgUrl(String paperImgUrl) {
        this.paperImgUrl = paperImgUrl;
    }

    private String useYn;

    @Basic
    @javax.persistence.Column(name = "use_yn", columnDefinition = "CHAR(1)")
    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    private String delYn;

    @Basic
    @javax.persistence.Column(name = "del_yn", columnDefinition = "CHAR(1)")
    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
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

        StoreEntity that = (StoreEntity) o;

        if (seq != that.seq) return false;
        if (ownerSeq != that.ownerSeq) return false;
        if (sellerSeq != that.sellerSeq) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (cellPhone != null ? !cellPhone.equals(that.cellPhone) : that.cellPhone != null) return false;
        if (virtualPhone != null ? !virtualPhone.equals(that.virtualPhone) : that.virtualPhone != null) return false;
        if (storeType != null ? !storeType.equals(that.storeType) : that.storeType != null) return false;
        if (ttsUseYn != null ? !ttsUseYn.equals(that.ttsUseYn) : that.ttsUseYn != null) return false;
        if (ttsNotifyUseYn != null ? !ttsNotifyUseYn.equals(that.ttsNotifyUseYn) : that.ttsNotifyUseYn != null)
            return false;
        if (ttsPhone != null ? !ttsPhone.equals(that.ttsPhone) : that.ttsPhone != null) return false;
        if (ttsPhoneEtc != null ? !ttsPhoneEtc.equals(that.ttsPhoneEtc) : that.ttsPhoneEtc != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (pushServerUrl != null ? !pushServerUrl.equals(that.pushServerUrl) : that.pushServerUrl != null)
            return false;
        if (delvMinPrice != null ? !delvMinPrice.equals(that.delvMinPrice) : that.delvMinPrice != null) return false;
        if (delvAbleRegionAvbbv != null ? !delvAbleRegionAvbbv.equals(that.delvAbleRegionAvbbv) : that.delvAbleRegionAvbbv != null)
            return false;
        if (logoImgUrl != null ? !logoImgUrl.equals(that.logoImgUrl) : that.logoImgUrl != null) return false;
        if (paperImgUrl != null ? !paperImgUrl.equals(that.paperImgUrl) : that.paperImgUrl != null) return false;
        if (useYn != null ? !useYn.equals(that.useYn) : that.useYn != null) return false;
        if (delYn != null ? !delYn.equals(that.delYn) : that.delYn != null) return false;
        if (regdate != null ? !regdate.equals(that.regdate) : that.regdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seq ^ (seq >>> 32));
        result = 31 * result + (int) (ownerSeq ^ (ownerSeq >>> 32));
        result = 31 * result + (int) (sellerSeq ^ (sellerSeq >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (cellPhone != null ? cellPhone.hashCode() : 0);
        result = 31 * result + (virtualPhone != null ? virtualPhone.hashCode() : 0);
        result = 31 * result + (storeType != null ? storeType.hashCode() : 0);
        result = 31 * result + (ttsUseYn != null ? ttsUseYn.hashCode() : 0);
        result = 31 * result + (ttsNotifyUseYn != null ? ttsNotifyUseYn.hashCode() : 0);
        result = 31 * result + (ttsPhone != null ? ttsPhone.hashCode() : 0);
        result = 31 * result + (ttsPhoneEtc != null ? ttsPhoneEtc.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (pushServerUrl != null ? pushServerUrl.hashCode() : 0);
        result = 31 * result + (delvMinPrice != null ? delvMinPrice.hashCode() : 0);
        result = 31 * result + (delvAbleRegionAvbbv != null ? delvAbleRegionAvbbv.hashCode() : 0);
        result = 31 * result + (logoImgUrl != null ? logoImgUrl.hashCode() : 0);
        result = 31 * result + (paperImgUrl != null ? paperImgUrl.hashCode() : 0);
        result = 31 * result + (useYn != null ? useYn.hashCode() : 0);
        result = 31 * result + (delYn != null ? delYn.hashCode() : 0);
        result = 31 * result + (regdate != null ? regdate.hashCode() : 0);
        return result;
    }
}
