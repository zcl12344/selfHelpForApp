package com.springboot.tongyuyan.selfhelp.winter.model.order;

import java.math.BigDecimal;

public class OrderGood {
    private Integer id;

    private String goodName;

    private String goodSn;

    private Short goodNumber;

    private BigDecimal goodWeight;

    private BigDecimal goodPrice;

    private Integer goodId;

    private Integer orderId;

    private String goodImg;

    private BigDecimal profit;

    private BigDecimal goodAmount;

    private Integer integral;

    private Boolean isReturned;

    private Boolean isReturnable;

    private String ReturnGoodsNumber;

    public String getReturnGoodsNumber() {
        return ReturnGoodsNumber;
    }

    public void setReturnGoodsNumber(String returnGoodsNumber) {
        ReturnGoodsNumber = returnGoodsNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
    }

    public String getGoodSn() {
        return goodSn;
    }

    public void setGoodSn(String goodSn) {
        this.goodSn = goodSn == null ? null : goodSn.trim();
    }

    public Short getGoodNumber() {
        return goodNumber;
    }

    public void setGoodNumber(Short goodNumber) {
        this.goodNumber = goodNumber;
    }

    public BigDecimal getGoodWeight() {
        return goodWeight;
    }

    public void setGoodWeight(BigDecimal goodWeight) {
        this.goodWeight = goodWeight;
    }

    public BigDecimal getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(BigDecimal goodPrice) {
        this.goodPrice = goodPrice;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getGoodImg() {
        return goodImg;
    }

    public void setGoodImg(String goodImg) {
        this.goodImg = goodImg == null ? null : goodImg.trim();
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getGoodAmount() {
        return goodAmount;
    }

    public void setGoodAmount(BigDecimal goodAmount) {
        this.goodAmount = goodAmount;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Boolean getIsReturned() {
        return isReturned;
    }

    public void setIsReturned(Boolean isReturned) {
        this.isReturned = isReturned;
    }

    public Boolean getIsReturnable() {
        return isReturnable;
    }

    public void setIsReturnable(Boolean isReturnable) {
        this.isReturnable = isReturnable;
    }
}