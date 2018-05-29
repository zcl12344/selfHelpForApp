package com.springboot.tongyuyan.selfhelp.controller.order;

import com.springboot.tongyuyan.selfhelp.service.order.OrderGoodsService;
import com.springboot.tongyuyan.selfhelp.tool.responestool.BasePageEx;
import com.springboot.tongyuyan.selfhelp.winter.model.order.OrderGood;
import com.springboot.tongyuyan.selfhelp.winter.requstDto.order.OrderGoodsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orderGoods")
public class OrderGoodsController {
    @Autowired
    private OrderGoodsService orderGoodsService;

    @RequestMapping(value = "List")
    public BasePageEx<OrderGood> list(OrderGoodsRequest orderGoodsRequest){
       BasePageEx<OrderGood> pageEx= orderGoodsService.queryList(orderGoodsRequest);
       return pageEx;
    }

}
