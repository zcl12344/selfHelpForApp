package com.springboot.tongyuyan.selfhelp.winter.mapper.oder;

import com.github.pagehelper.Page;
import com.springboot.tongyuyan.selfhelp.winter.model.order.OrderInfo;
import com.springboot.tongyuyan.selfhelp.winter.requstDto.order.OrderInfoRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByOrderRequest(@Param(value = "dto") OrderInfoRequest orderInfoRequest);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    Page<OrderInfo> queryOrderInfoPageList(@Param(value = "dto") OrderInfoRequest orderInfoRequest);

    int updateById(@Param(value = "id")String orderInfoId,@Param(value = "orderStatus")String orderStatus);

    List<String> queryShopIdByPhone(@Param(value = "userPhone")String userPhone);
}