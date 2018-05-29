package com.springboot.tongyuyan.selfhelp.winter.requstDto.order;

import com.springboot.tongyuyan.selfhelp.tool.requesttool.BaseRequest;

public class OrderInfoRequest extends BaseRequest {
    private String userPhone;

    private String shopName;

    private String orderId;

    private String shopId;

    public OrderInfoRequest(){

    }
    public OrderInfoRequest(String orderId){
        this.orderId=orderId;
    }


    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
