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
//@Table(name = "user_admin")
public class UserAdminEntity {
    private long seq;
    private String id;
    private String passwd;
    private String roleId;
    private String name;
    private String phone;
    private String receiptEmailYn;
    private String errorEmailYn;
    private Integer loginCnt;
    private Timestamp lastLoginDate;
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
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "passwd")
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Basic
    @Column(name = "role_id")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "receipt_email_yn", columnDefinition = "CHAR(1)")
    public String getReceiptEmailYn() {
        return receiptEmailYn;
    }

    public void setReceiptEmailYn(String receiptEmailYn) {
        this.receiptEmailYn = receiptEmailYn;
    }

    @Basic
    @Column(name = "error_email_yn", columnDefinition = "CHAR(1)")
    public String getErrorEmailYn() {
        return errorEmailYn;
    }

    public void setErrorEmailYn(String errorEmailYn) {
        this.errorEmailYn = errorEmailYn;
    }

    @Basic
    @Column(name = "login_cnt")
    public Integer getLoginCnt() {
        return loginCnt;
    }

    public void setLoginCnt(Integer loginCnt) {
        this.loginCnt = loginCnt;
    }

    @Basic
    @Column(name = "last_login_date")
    public Timestamp getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Timestamp lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
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

        UserAdminEntity that = (UserAdminEntity) o;

        if (seq != that.seq) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (passwd != null ? !passwd.equals(that.passwd) : that.passwd != null) return false;
        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (receiptEmailYn != null ? !receiptEmailYn.equals(that.receiptEmailYn) : that.receiptEmailYn != null)
            return false;
        if (errorEmailYn != null ? !errorEmailYn.equals(that.errorEmailYn) : that.errorEmailYn != null) return false;
        if (loginCnt != null ? !loginCnt.equals(that.loginCnt) : that.loginCnt != null) return false;
        if (lastLoginDate != null ? !lastLoginDate.equals(that.lastLoginDate) : that.lastLoginDate != null)
            return false;
        if (useYn != null ? !useYn.equals(that.useYn) : that.useYn != null) return false;
        if (delYn != null ? !delYn.equals(that.delYn) : that.delYn != null) return false;
        if (regdate != null ? !regdate.equals(that.regdate) : that.regdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seq ^ (seq >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (passwd != null ? passwd.hashCode() : 0);
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (receiptEmailYn != null ? receiptEmailYn.hashCode() : 0);
        result = 31 * result + (errorEmailYn != null ? errorEmailYn.hashCode() : 0);
        result = 31 * result + (loginCnt != null ? loginCnt.hashCode() : 0);
        result = 31 * result + (lastLoginDate != null ? lastLoginDate.hashCode() : 0);
        result = 31 * result + (useYn != null ? useYn.hashCode() : 0);
        result = 31 * result + (delYn != null ? delYn.hashCode() : 0);
        result = 31 * result + (regdate != null ? regdate.hashCode() : 0);
        return result;
    }
}
