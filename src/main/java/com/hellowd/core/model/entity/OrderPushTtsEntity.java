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
//@Table(name = "order_push_tts")
public class OrderPushTtsEntity {
    private long orderSeq;
    private long orderNo;
    private String pushDelayYn;
    private String pushNotifyYn;
    private String pushCompleteMessage;
    private String pushFailMessage;
    private String ttsUseYn;
    private String ttsMissedYn;
    private String ttsFailMessgae;
    private Timestamp regdate;

    @Id
    @Column(name = "order_seq")
    public long getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(long orderSeq) {
        this.orderSeq = orderSeq;
    }

    @Basic
    @Column(name = "order_no")
    public long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(long orderNo) {
        this.orderNo = orderNo;
    }

    @Basic
    @Column(name = "push_delay_yn", columnDefinition = "CHAR(1)")
    public String getPushDelayYn() {
        return pushDelayYn;
    }

    public void setPushDelayYn(String pushDelayYn) {
        this.pushDelayYn = pushDelayYn;
    }

    @Basic
    @Column(name = "push_notify_yn", columnDefinition = "CHAR(1)")
    public String getPushNotifyYn() {
        return pushNotifyYn;
    }

    public void setPushNotifyYn(String pushNotifyYn) {
        this.pushNotifyYn = pushNotifyYn;
    }

    @Basic
    @Column(name = "push_complete_message")
    public String getPushCompleteMessage() {
        return pushCompleteMessage;
    }

    public void setPushCompleteMessage(String pushCompleteMessage) {
        this.pushCompleteMessage = pushCompleteMessage;
    }

    @Basic
    @Column(name = "push_fail_message")
    public String getPushFailMessage() {
        return pushFailMessage;
    }

    public void setPushFailMessage(String pushFailMessage) {
        this.pushFailMessage = pushFailMessage;
    }

    @Basic
    @Column(name = "tts_use_yn", columnDefinition = "CHAR(1)")
    public String getTtsUseYn() {
        return ttsUseYn;
    }

    public void setTtsUseYn(String ttsUseYn) {
        this.ttsUseYn = ttsUseYn;
    }

    @Basic
    @Column(name = "tts_missed_yn", columnDefinition = "CHAR(1)")
    public String getTtsMissedYn() {
        return ttsMissedYn;
    }

    public void setTtsMissedYn(String ttsMissedYn) {
        this.ttsMissedYn = ttsMissedYn;
    }

    @Basic
    @Column(name = "tts_fail_messgae")
    public String getTtsFailMessgae() {
        return ttsFailMessgae;
    }

    public void setTtsFailMessgae(String ttsFailMessgae) {
        this.ttsFailMessgae = ttsFailMessgae;
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

        OrderPushTtsEntity that = (OrderPushTtsEntity) o;

        if (orderSeq != that.orderSeq) return false;
        if (orderNo != that.orderNo) return false;
        if (pushDelayYn != null ? !pushDelayYn.equals(that.pushDelayYn) : that.pushDelayYn != null) return false;
        if (pushNotifyYn != null ? !pushNotifyYn.equals(that.pushNotifyYn) : that.pushNotifyYn != null) return false;
        if (pushCompleteMessage != null ? !pushCompleteMessage.equals(that.pushCompleteMessage) : that.pushCompleteMessage != null)
            return false;
        if (pushFailMessage != null ? !pushFailMessage.equals(that.pushFailMessage) : that.pushFailMessage != null)
            return false;
        if (ttsUseYn != null ? !ttsUseYn.equals(that.ttsUseYn) : that.ttsUseYn != null) return false;
        if (ttsMissedYn != null ? !ttsMissedYn.equals(that.ttsMissedYn) : that.ttsMissedYn != null) return false;
        if (ttsFailMessgae != null ? !ttsFailMessgae.equals(that.ttsFailMessgae) : that.ttsFailMessgae != null)
            return false;
        if (regdate != null ? !regdate.equals(that.regdate) : that.regdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderSeq ^ (orderSeq >>> 32));
        result = 31 * result + (int) (orderNo ^ (orderNo >>> 32));
        result = 31 * result + (pushDelayYn != null ? pushDelayYn.hashCode() : 0);
        result = 31 * result + (pushNotifyYn != null ? pushNotifyYn.hashCode() : 0);
        result = 31 * result + (pushCompleteMessage != null ? pushCompleteMessage.hashCode() : 0);
        result = 31 * result + (pushFailMessage != null ? pushFailMessage.hashCode() : 0);
        result = 31 * result + (ttsUseYn != null ? ttsUseYn.hashCode() : 0);
        result = 31 * result + (ttsMissedYn != null ? ttsMissedYn.hashCode() : 0);
        result = 31 * result + (ttsFailMessgae != null ? ttsFailMessgae.hashCode() : 0);
        result = 31 * result + (regdate != null ? regdate.hashCode() : 0);
        return result;
    }
}
