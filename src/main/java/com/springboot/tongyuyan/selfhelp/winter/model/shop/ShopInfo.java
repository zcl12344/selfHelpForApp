package com.springboot.tongyuyan.selfhelp.winter.model.shop;


import java.math.BigDecimal;

public class ShopInfo {
    private Integer id;

    private String realName;

    private String idCard;

    private String bankAccount;

    private String alipayAccount;

    private String weixinpayAccount;

    private String shopName;

    private String shopSignature;

    private BigDecimal shopLocationLat;

    private BigDecimal shopLocationLong;

    private String shopLocationDetail;

    private Boolean isCheck;

    private Integer shopOwnerId;

    private String businessLicenseImg;

    private String idCardImg;

    private BigDecimal balance;

    private String shopBrief;

    private String shopImg;

    public Boolean getCheck() {
        return isCheck;
    }

    public void setCheck(Boolean check) {
        isCheck = check;
    }

    public String getShopBrief() {
        return shopBrief;
    }

    public void setShopBrief(String shopBrief) {
        this.shopBrief = shopBrief;
    }

    public String getShopImg() {
        return shopImg;
    }

    public void setShopImg(String shopImg) {
        this.shopImg = shopImg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount == null ? null : alipayAccount.trim();
    }

    public String getWeixinpayAccount() {
        return weixinpayAccount;
    }

    public void setWeixinpayAccount(String weixinpayAccount) {
        this.weixinpayAccount = weixinpayAccount == null ? null : weixinpayAccount.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getShopSignature() {
        return shopSignature;
    }

    public void setShopSignature(String shopSignature) {
        this.shopSignature = shopSignature == null ? null : shopSignature.trim();
    }

    public BigDecimal getShopLocationLat() {
        return shopLocationLat;
    }

    public void setShopLocationLat(BigDecimal shopLocationLat) {
        this.shopLocationLat = shopLocationLat;
    }

    public BigDecimal getShopLocationLong() {
        return shopLocationLong;
    }

    public void setShopLocationLong(BigDecimal shopLocationLong) {
        this.shopLocationLong = shopLocationLong;
    }

    public String getShopLocationDetail() {
        return shopLocationDetail;
    }

    public void setShopLocationDetail(String shopLocationDetail) {
        this.shopLocationDetail = shopLocationDetail == null ? null : shopLocationDetail.trim();
    }

    public Boolean getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Boolean isCheck) {
        this.isCheck = isCheck;
    }

    public Integer getShopOwnerId() {
        return shopOwnerId;
    }

    public void setShopOwnerId(Integer shopOwnerId) {
        this.shopOwnerId = shopOwnerId;
    }

    public String getBusinessLicenseImg() {
        return businessLicenseImg;
    }

    public void setBusinessLicenseImg(String businessLicenseImg) {
        this.businessLicenseImg = businessLicenseImg == null ? null : businessLicenseImg.trim();
    }

    public String getIdCardImg() {
        return idCardImg;
    }

    public void setIdCardImg(String idCardImg) {
        this.idCardImg = idCardImg == null ? null : idCardImg.trim();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}