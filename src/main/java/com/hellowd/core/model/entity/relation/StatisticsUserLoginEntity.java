package com.hellowd.core.model.entity.relation;//package com.hellowd.model.entity;
//
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//import java.sql.Timestamp;
//
///**
// * Created by Helloworld
// * User : hiyoon
// * Date : 2016-07-11
// * Time : 오전 10:07
// * 해당 클래스에 대한 기능 설명
// */
//@Entity
//@Table(name = "statistics_user_login", schema = "sf_testbed", catalog = "")
//public class StatisticsUserLoginEntity {
//    private long seq;
//    private String userType;
//    private String resultType;
//    private Timestamp regdate;
//
//    @Basic
//    @Column(name = "seq")
//    public long getSeq() {
//        return seq;
//    }
//
//    public void setSeq(long seq) {
//        this.seq = seq;
//    }
//
//    @Basic
//    @Column(name = "user_type")
//    public String getUserType() {
//        return userType;
//    }
//
//    public void setUserType(String userType) {
//        this.userType = userType;
//    }
//
//    @Basic
//    @Column(name = "result_type")
//    public String getResultType() {
//        return resultType;
//    }
//
//    public void setResultType(String resultType) {
//        this.resultType = resultType;
//    }
//
//    @Basic
//    @Column(name = "regdate")
//    public Timestamp getRegdate() {
//        return regdate;
//    }
//
//    public void setRegdate(Timestamp regdate) {
//        this.regdate = regdate;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        StatisticsUserLoginEntity that = (StatisticsUserLoginEntity) o;
//
//        if (seq != that.seq) return false;
//        if (userType != null ? !userType.equals(that.userType) : that.userType != null) return false;
//        if (resultType != null ? !resultType.equals(that.resultType) : that.resultType != null) return false;
//        if (regdate != null ? !regdate.equals(that.regdate) : that.regdate != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = (int) (seq ^ (seq >>> 32));
//        result = 31 * result + (userType != null ? userType.hashCode() : 0);
//        result = 31 * result + (resultType != null ? resultType.hashCode() : 0);
//        result = 31 * result + (regdate != null ? regdate.hashCode() : 0);
//        return result;
//    }
//}
