package com.springboot.tongyuyan.selfhelp.winter.requstDto.user;

public class MsgTokenRequest  {
   private String  phoneNumber;
   private  String hash;
   private String tamp;
   private  String msgNum;
   private String appOpenId;

    public String getAppOpenId() {
        return appOpenId;
    }

    public void setAppOpenId(String appOpenId) {
        this.appOpenId = appOpenId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getTamp() {
        return tamp;
    }

    public void setTamp(String tamp) {
        this.tamp = tamp;
    }

    public String getMsgNum() {
        return msgNum;
    }

    public void setMsgNum(String msgNum) {
        this.msgNum = msgNum;
    }
}
