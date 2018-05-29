package com.springboot.tongyuyan.selfhelp.winter.model.user;

import org.springframework.stereotype.Repository;

@Repository
public class MicroLetterUser {
    private Integer userId;

    private String encryptedData;

    private String iv;

    private String userPhone;

    private String userOppenid;

    private String userNickName;

    private String userPortrait;

    private String sessionKey;

    private String feedBack;

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }


    @Override
    public String toString() {
        return "MicroLetterUser{" +
                "userId=" + userId +
                ", encryptedData='" + encryptedData + '\'' +
                ", iv='" + iv + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userOppenid='" + userOppenid + '\'' +
                ", userNickName='" + userNickName + '\'' +
                ", userPortrait='" + userPortrait + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                '}';
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public Integer getUserId() {
        return userId;
    }


    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserPortrait() {
        return userPortrait;
    }

    public void setUserPortrait(String userPortrait) {
        this.userPortrait = userPortrait;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserOppenid() {
        return userOppenid;
    }

    public void setUserOppenid(String userOppenid) {
        this.userOppenid = userOppenid == null ? null : userOppenid.trim();
    }
}