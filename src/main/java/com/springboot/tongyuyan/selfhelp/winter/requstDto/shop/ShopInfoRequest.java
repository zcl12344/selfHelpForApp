package com.springboot.tongyuyan.selfhelp.winter.requstDto.shop;

import com.springboot.tongyuyan.selfhelp.tool.requesttool.BaseRequest;

public class ShopInfoRequest extends BaseRequest{
    private String idCard;
    private String shopName;
    private  String shopId;
    private String userPhone;

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopCard() {
        return idCard;
    }

    public void setShopCard(String idCard) {
        this.idCard = idCard;
    }
}
