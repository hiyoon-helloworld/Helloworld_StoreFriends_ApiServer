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
//@Table(name = "user_manager_business")
public class UserManagerBusinessEntity {
    private long seq;
    private long managerSeq;
    private String taxId;
    private String bankCode;
    private String bankName;
    private String bankOwnerName;
    private String bankAccountNo;
    private String cardNo;
    private String cardName;
    private String cardValidYear;
    private String cardValidMonth;
    private String billingPublishYn;
    private String billingIssueDate;
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
    @Column(name = "manager_seq")
    public long getManagerSeq() {
        return managerSeq;
    }

    public void setManagerSeq(long managerSeq) {
        this.managerSeq = managerSeq;
    }

    @Basic
    @Column(name = "tax_id")
    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
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
    @Column(name = "bank_name")
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
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
    @Column(name = "card_no")
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @Basic
    @Column(name = "card_name")
    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    @Basic
    @Column(name = "card_valid_year")
    public String getCardValidYear() {
        return cardValidYear;
    }

    public void setCardValidYear(String cardValidYear) {
        this.cardValidYear = cardValidYear;
    }

    @Basic
    @Column(name = "card_valid_month")
    public String getCardValidMonth() {
        return cardValidMonth;
    }

    public void setCardValidMonth(String cardValidMonth) {
        this.cardValidMonth = cardValidMonth;
    }

    @Basic
    @Column(name = "billing_publish_yn", columnDefinition = "CHAR(1)")
    public String getBillingPublishYn() {
        return billingPublishYn;
    }

    public void setBillingPublishYn(String billingPublishYn) {
        this.billingPublishYn = billingPublishYn;
    }

    @Basic
    @Column(name = "billing_issue_date")
    public String getBillingIssueDate() {
        return billingIssueDate;
    }

    public void setBillingIssueDate(String billingIssueDate) {
        this.billingIssueDate = billingIssueDate;
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

        UserManagerBusinessEntity that = (UserManagerBusinessEntity) o;

        if (seq != that.seq) return false;
        if (managerSeq != that.managerSeq) return false;
        if (taxId != null ? !taxId.equals(that.taxId) : that.taxId != null) return false;
        if (bankCode != null ? !bankCode.equals(that.bankCode) : that.bankCode != null) return false;
        if (bankName != null ? !bankName.equals(that.bankName) : that.bankName != null) return false;
        if (bankOwnerName != null ? !bankOwnerName.equals(that.bankOwnerName) : that.bankOwnerName != null)
            return false;
        if (bankAccountNo != null ? !bankAccountNo.equals(that.bankAccountNo) : that.bankAccountNo != null)
            return false;
        if (cardNo != null ? !cardNo.equals(that.cardNo) : that.cardNo != null) return false;
        if (cardName != null ? !cardName.equals(that.cardName) : that.cardName != null) return false;
        if (cardValidYear != null ? !cardValidYear.equals(that.cardValidYear) : that.cardValidYear != null)
            return false;
        if (cardValidMonth != null ? !cardValidMonth.equals(that.cardValidMonth) : that.cardValidMonth != null)
            return false;
        if (billingPublishYn != null ? !billingPublishYn.equals(that.billingPublishYn) : that.billingPublishYn != null)
            return false;
        if (billingIssueDate != null ? !billingIssueDate.equals(that.billingIssueDate) : that.billingIssueDate != null)
            return false;
        if (delYn != null ? !delYn.equals(that.delYn) : that.delYn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seq ^ (seq >>> 32));
        result = 31 * result + (int) (managerSeq ^ (managerSeq >>> 32));
        result = 31 * result + (taxId != null ? taxId.hashCode() : 0);
        result = 31 * result + (bankCode != null ? bankCode.hashCode() : 0);
        result = 31 * result + (bankName != null ? bankName.hashCode() : 0);
        result = 31 * result + (bankOwnerName != null ? bankOwnerName.hashCode() : 0);
        result = 31 * result + (bankAccountNo != null ? bankAccountNo.hashCode() : 0);
        result = 31 * result + (cardNo != null ? cardNo.hashCode() : 0);
        result = 31 * result + (cardName != null ? cardName.hashCode() : 0);
        result = 31 * result + (cardValidYear != null ? cardValidYear.hashCode() : 0);
        result = 31 * result + (cardValidMonth != null ? cardValidMonth.hashCode() : 0);
        result = 31 * result + (billingPublishYn != null ? billingPublishYn.hashCode() : 0);
        result = 31 * result + (billingIssueDate != null ? billingIssueDate.hashCode() : 0);
        result = 31 * result + (delYn != null ? delYn.hashCode() : 0);
        return result;
    }
}
