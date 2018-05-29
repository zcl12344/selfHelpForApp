package com.springboot.tongyuyan.selfhelp.service.order;

import com.springboot.tongyuyan.selfhelp.tool.responestool.BasePageEx;
import com.springboot.tongyuyan.selfhelp.tool.responestool.ResultDto;
import com.springboot.tongyuyan.selfhelp.winter.model.order.OrderGood;
import com.springboot.tongyuyan.selfhelp.winter.model.order.OrderInfo;
import com.springboot.tongyuyan.selfhelp.winter.requstDto.order.OrderInfoRequest;

import java.util.List;

public interface OrderInfoService {
    /**
     * 添加订单
     * @param orderInfo
     * @return
     */
    public ResultDto<Object> insert(OrderInfo orderInfo,List<OrderGood> orderGoodDateList );

    /**
     * 订单查询
     * @param orderInfoRequest
     * @return
     */
    BasePageEx<OrderInfo> queryPageOrder(OrderInfoRequest orderInfoRequest);

    /**
     * 修改订单状态
     */
    public ResultDto<Object> update(String orderId,String orderStatus,String orderGoodList);


    /**
     * 查询一条订单
     */
    OrderInfo queryOrder(OrderInfoRequest orderInfoRequest);
}
