package com.springboot.tongyuyan.selfhelp.winter.model.goods;

import java.math.BigDecimal;
import java.util.Date;


public class Goods {

    /**
     * 商品ID
     */
    private Integer id;

    /**
     * 商品编号
     */
    private String goodSn;

    /**
     * 商品数量
     */
    private Short goodNumber;

    /**
     * 是否是散称商品
     */
    private Boolean isScattered;

    /**
     * 商品的重量，以千斤为单位
     */
    private BigDecimal goodWeight;

    /**
     * 本店售价
     */
    private BigDecimal shopPrice;

    /**
     * 是否开放销售
     */
    private Boolean isOnSale;

    /**
     * 是否促销
     */
    private Boolean isPromote;

    /**
     * 促销价格
     */
    private BigDecimal promotePrice;

    /**
     * 促销开始日期
     */
    private Date promoteStartDate;

    /**
     * 促销结束日期
     */
    private Date promoteEndDate;

    /**
     * 商品报警数量
     */
    private Short warnNumber;

    /**
     * 商品简要描述
     */
    private String goodBrief;

    /**
     * 商品图片
     */
    private String goodImg;

    /**
     * 商品是否已经删除
     */
    private Boolean isDelete;

    /**
     * 商品在页面中显示的先后顺序
     */
    private Short sortOrder;

    /**
     * 商品得添加时间
     */
    private Date addTime;

    /**
     * 最近一次更新商品配置的时间
     */
    private Date lastUpdate;

    /**
     * 购买该商品时每笔成功交易赠送的积分数量
     */
    private Integer giveIntegral;

    /**
     *
     */
    private Integer categoryId;

    /**
     *
     */
    private Integer shopId;

    /**
     *
     */
    private Integer supplierId;

    /**
     * 商品的名称
     */
    private String goodName;

    /**
     *
     */
    private BigDecimal purchasePrice;

    /**
     *
     */
    private Boolean isReturnable;

    /**
     *
     */
    private Boolean isOnline;

    /**
     *
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getIsScattered() {
        return isScattered;
    }

    public void setIsScattered(Boolean isScattered) {
        this.isScattered = isScattered;
    }

    public BigDecimal getGoodWeight() {
        return goodWeight;
    }

    public void setGoodWeight(BigDecimal goodWeight) {
        this.goodWeight = goodWeight;
    }

    public BigDecimal getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(BigDecimal shopPrice) {
        this.shopPrice = shopPrice;
    }

    public Boolean getIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(Boolean isOnSale) {
        this.isOnSale = isOnSale;
    }

    public Boolean getIsPromote() {
        return isPromote;
    }

    public void setIsPromote(Boolean isPromote) {
        this.isPromote = isPromote;
    }

    public BigDecimal getPromotePrice() {
        return promotePrice;
    }

    public void setPromotePrice(BigDecimal promotePrice) {
        this.promotePrice = promotePrice;
    }

    public Date getPromoteStartDate() {
        return promoteStartDate;
    }

    public void setPromoteStartDate(Date promoteStartDate) {
        this.promoteStartDate = promoteStartDate;
    }

    public Date getPromoteEndDate() {
        return promoteEndDate;
    }

    public void setPromoteEndDate(Date promoteEndDate) {
        this.promoteEndDate = promoteEndDate;
    }

    public Short getWarnNumber() {
        return warnNumber;
    }

    public void setWarnNumber(Short warnNumber) {
        this.warnNumber = warnNumber;
    }

    public String getGoodBrief() {
        return goodBrief;
    }

    public void setGoodBrief(String goodBrief) {
        this.goodBrief = goodBrief == null ? null : goodBrief.trim();
    }

    public String getGoodImg() {
        return goodImg;
    }

    public void setGoodImg(String goodImg) {
        this.goodImg = goodImg == null ? null : goodImg.trim();
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Short getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Short sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getGiveIntegral() {
        return giveIntegral;
    }

    public void setGiveIntegral(Integer giveIntegral) {
        this.giveIntegral = giveIntegral;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Boolean getIsReturnable() {
        return isReturnable;
    }

    public void setIsReturnable(Boolean isReturnable) {
        this.isReturnable = isReturnable;
    }

    public Boolean getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Boolean isOnline) {
        this.isOnline = isOnline;
    }
}