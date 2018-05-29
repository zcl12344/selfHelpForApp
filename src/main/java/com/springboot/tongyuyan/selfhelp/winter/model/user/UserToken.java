package com.springboot.tongyuyan.selfhelp.winter.model.user;

import javafx.scene.text.Text;

public class UserToken {
    private Integer id;

    private Object userToken;

    private String userPhone;

    private String tokenDisabledTime;

    private String userNick;

    private String userImg;

    private String appOpenId;

    private String userAppSn;

    public String getAppOpenId() {
        return appOpenId;
    }

    public void setAppOpenId(String appOpenId) {
        this.appOpenId = appOpenId;
    }

    public String getUserAppSn() {
        return userAppSn;
    }

    public void setUserAppSn(String userAppSn) {
        this.userAppSn = userAppSn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getUserToken() {
        return userToken;
    }

    public void setUserToken(Object userToken) {
        this.userToken = userToken;
    }

    public void setUserToken(Text userToken) {
        this.userToken = userToken;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getTokenDisabledTime() {
        return tokenDisabledTime;
    }

    public void setTokenDisabledTime(String tokenDisabledTime) {
        this.tokenDisabledTime = tokenDisabledTime == null ? null : tokenDisabledTime.trim();
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick == null ? null : userNick.trim();
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg == null ? null : userImg.trim();
    }
}