package com.springboot.tongyuyan.selfhelp.service.order;

import com.springboot.tongyuyan.selfhelp.tool.responestool.BasePageEx;
import com.springboot.tongyuyan.selfhelp.tool.responestool.ResultDto;
import com.springboot.tongyuyan.selfhelp.winter.model.order.OrderGood;
import com.springboot.tongyuyan.selfhelp.winter.model.order.OrderInfo;
import com.springboot.tongyuyan.selfhelp.winter.requstDto.order.OrderGoodsRequest;

import java.util.List;

public interface OrderGoodsService {
    /**
     * 单条数据插入
     * @param orderGood
     * @return
     */
    public ResultDto<Object> insert(OrderGood orderGood);

    /**
     * 多数据插入
     */
    public ResultDto<Object> insertListOrderGood(List<OrderGood> orderGoodList);
    /**
     * 多条信息查询
     */
    public BasePageEx<OrderGood> queryList(OrderGoodsRequest orderGoodsRequest);

}
