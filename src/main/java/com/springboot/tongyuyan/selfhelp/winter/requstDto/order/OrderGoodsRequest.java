package com.springboot.tongyuyan.selfhelp.winter.requstDto.order;

import com.springboot.tongyuyan.selfhelp.tool.requesttool.BaseRequest;

public class OrderGoodsRequest extends BaseRequest {

    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
