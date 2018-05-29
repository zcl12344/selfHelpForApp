package com.springboot.tongyuyan.selfhelp.HttpRespons;

public class ReturnLoginDate {
    private String oppenid;
    private String sessionKey;
    private String expiresIn;

    public String getOppenid() {
        return oppenid;
    }

    public void setOppenid(String oppenid) {
        this.oppenid = oppenid;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }
}
