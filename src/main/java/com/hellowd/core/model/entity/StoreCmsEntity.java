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
//@Table(name = "store_cms")
public class StoreCmsEntity {
    private long seq;
    private long storeSeq;
    private long ownerSeq;
    private String type;
    private String bankCode;
    private String bankOwnerName;
    private String bankAccountNo;
    private String withdrawalInfo;
    private Long withdrawalCost;
    private Timestamp transferStartDate;
    private Timestamp withdrawalDate;
    private String useYn;
    private String delYn;
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
    @Column(name = "type", columnDefinition = "CHAR(1)")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "bank_code")
    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    @Basic
    @Column(name = "bank_owner_name")
    public String getBankOwnerName() {
        return bankOwnerName;
    }

    public void setBankOwnerName(String bankOwnerName) {
        this.bankOwnerName = bankOwnerName;
    }

    @Basic
    @Column(name = "bank_account_no")
    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    @Basic
    @Column(name = "withdrawal_info")
    public String getWithdrawalInfo() {
        return withdrawalInfo;
    }

    public void setWithdrawalInfo(String withdrawalInfo) {
        this.withdrawalInfo = withdrawalInfo;
    }

    @Basic
    @Column(name = "withdrawal_cost")
    public Long getWithdrawalCost() {
        return withdrawalCost;
    }

    public void setWithdrawalCost(Long withdrawalCost) {
        this.withdrawalCost = withdrawalCost;
    }

    @Basic
    @Column(name = "transfer_start_date")
    public Timestamp getTransferStartDate() {
        return transferStartDate;
    }

    public void setTransferStartDate(Timestamp transferStartDate) {
        this.transferStartDate = transferStartDate;
    }

    @Basic
    @Column(name = "withdrawal_date")
    public Timestamp getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(Timestamp withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
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
    @Column(name = "del_yn", columnDefinition = "CHAR(1)")
    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
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

        StoreCmsEntity that = (StoreCmsEntity) o;

        if (seq != that.seq) return false;
        if (storeSeq != that.storeSeq) return false;
        if (ownerSeq != that.ownerSeq) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (bankCode != null ? !bankCode.equals(that.bankCode) : that.bankCode != null) return false;
        if (bankOwnerName != null ? !bankOwnerName.equals(that.bankOwnerName) : that.bankOwnerName != null)
            return false;
        if (bankAccountNo != null ? !bankAccountNo.equals(that.bankAccountNo) : that.bankAccountNo != null)
            return false;
        if (withdrawalInfo != null ? !withdrawalInfo.equals(that.withdrawalInfo) : that.withdrawalInfo != null)
            return false;
        if (withdrawalCost != null ? !withdrawalCost.equals(that.withdrawalCost) : that.withdrawalCost != null)
            return false;
        if (transferStartDate != null ? !transferStartDate.equals(that.transferStartDate) : that.transferStartDate != null)
            return false;
        if (withdrawalDate != null ? !withdrawalDate.equals(that.withdrawalDate) : that.withdrawalDate != null)
            return false;
        if (useYn != null ? !useYn.equals(that.useYn) : that.useYn != null) return false;
        if (delYn != null ? !delYn.equals(that.delYn) : that.delYn != null) return false;
        if (regdate != null ? !regdate.equals(that.regdate) : that.regdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seq ^ (seq >>> 32));
        result = 31 * result + (int) (storeSeq ^ (storeSeq >>> 32));
        result = 31 * result + (int) (ownerSeq ^ (ownerSeq >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (bankCode != null ? bankCode.hashCode() : 0);
        result = 31 * result + (bankOwnerName != null ? bankOwnerName.hashCode() : 0);
        result = 31 * result + (bankAccountNo != null ? bankAccountNo.hashCode() : 0);
        result = 31 * result + (withdrawalInfo != null ? withdrawalInfo.hashCode() : 0);
        result = 31 * result + (withdrawalCost != null ? withdrawalCost.hashCode() : 0);
        result = 31 * result + (transferStartDate != null ? transferStartDate.hashCode() : 0);
        result = 31 * result + (withdrawalDate != null ? withdrawalDate.hashCode() : 0);
        result = 31 * result + (useYn != null ? useYn.hashCode() : 0);
        result = 31 * result + (delYn != null ? delYn.hashCode() : 0);
        result = 31 * result + (regdate != null ? regdate.hashCode() : 0);
        return result;
    }
}
