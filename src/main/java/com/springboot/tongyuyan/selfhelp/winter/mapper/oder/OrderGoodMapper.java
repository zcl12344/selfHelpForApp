package com.springboot.tongyuyan.selfhelp.winter.mapper.oder;

import com.github.pagehelper.Page;
import com.springboot.tongyuyan.selfhelp.winter.model.order.OrderGood;
import com.springboot.tongyuyan.selfhelp.winter.requstDto.order.OrderGoodsRequest;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderGoodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderGood record);

    int insertSelective(OrderGood record);

    OrderGood selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderGood record);

    int updateByPrimaryKey(OrderGood record);

    /**
     * 批量插入
     */
    int insertByList(List<OrderGood> orderGoodList);

    /**
     * 批量查询
     */
    Page<OrderGood> queryList(OrderGoodsRequest orderGoodsRequest );

    /**
     * 修改订单状态
     */



}