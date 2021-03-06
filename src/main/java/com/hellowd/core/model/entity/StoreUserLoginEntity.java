package com.hellowd.core.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-14
 * Time : 오후 4:04
 * 해당 클래스에 대한 기능 설명
 */
@MappedSuperclass
//@Entity
//@Table(name = "store_user_login", schema = "sf_testbed", catalog = "")
public class StoreUserLoginEntity {
    private long seq;
    //private long operationSeq;
    private Date loginDate;
    private Date logoutDate;
    private long userSeq;
    private String userType;
    private Date regdate;

    public void setLoginDate(Timestamp loginDate) {
        this.loginDate = loginDate;
    }

    public void setLogoutDate(Timestamp logoutDate) {
        this.logoutDate = logoutDate;
    }

    public void setRegdate(Timestamp regdate) {
        this.regdate = regdate;
    }

    @Id
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getSeq() {
        return seq;
    }

//    @Basic
//    @Column(name = "operation_seq")
//    public long getOperationSeq() {
//        return operationSeq;
//    }
//
//    public void setOperationSeq(long operationSeq) {
//        this.operationSeq = operationSeq;
//    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    @Basic
    @Column(name = "login_date")
    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    @Basic
    @Column(name = "logout_date")
    public Date getLogoutDate() {
        return logoutDate;
    }

    public void setLogoutDate(Date logoutDate) {
        this.logoutDate = logoutDate;
    }

    @Basic
    @Column(name = "user_seq")
    public long getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(long userSeq) {
        this.userSeq = userSeq;
    }

    @Basic
    @Column(name = "user_type", columnDefinition = "CHAR(1)")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "regdate")
    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoreUserLoginEntity that = (StoreUserLoginEntity) o;

        if (seq != that.seq) return false;
//        if (operationSeq != that.operationSeq) return false;
        if (userSeq != that.userSeq) return false;
        if (loginDate != null ? !loginDate.equals(that.loginDate) : that.loginDate != null) return false;
        if (logoutDate != null ? !logoutDate.equals(that.logoutDate) : that.logoutDate != null) return false;
        if (userType != null ? !userType.equals(that.userType) : that.userType != null) return false;
        if (regdate != null ? !regdate.equals(that.regdate) : that.regdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seq ^ (seq >>> 32));
//        result = 31 * result + (int) (operationSeq ^ (operationSeq >>> 32));
        result = 31 * result + (loginDate != null ? loginDate.hashCode() : 0);
        result = 31 * result + (logoutDate != null ? logoutDate.hashCode() : 0);
        result = 31 * result + (int) (userSeq ^ (userSeq >>> 32));
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (regdate != null ? regdate.hashCode() : 0);
        return result;
    }
}
