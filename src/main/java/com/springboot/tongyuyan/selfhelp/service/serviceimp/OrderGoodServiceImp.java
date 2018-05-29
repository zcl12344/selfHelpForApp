package com.springboot.tongyuyan.selfhelp.service.serviceimp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.tongyuyan.selfhelp.service.order.OrderGoodsService;
import com.springboot.tongyuyan.selfhelp.tool.responestool.BasePageEx;
import com.springboot.tongyuyan.selfhelp.tool.responestool.ResultDto;
import com.springboot.tongyuyan.selfhelp.tool.responestool.ReturnDate;
import com.springboot.tongyuyan.selfhelp.winter.mapper.oder.OrderGoodMapper;
import com.springboot.tongyuyan.selfhelp.winter.model.order.OrderGood;
import com.springboot.tongyuyan.selfhelp.winter.model.order.OrderInfo;
import com.springboot.tongyuyan.selfhelp.winter.requstDto.order.OrderGoodsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderGoodServiceImp implements OrderGoodsService {
  @Autowired
  private OrderGoodMapper orderGoodMapper;




    @Override
    public ResultDto<Object> insert(OrderGood orderGood) {
        if(orderGood!=null){
           int insertNo= orderGoodMapper.insert(orderGood);
           if(insertNo!=0){
               return ReturnDate.successResult("添加成功",insertNo);
           }
        }
        return ReturnDate.fileResult("添加失败!",null);
    }

    @Override
    public ResultDto<Object> insertListOrderGood(List<OrderGood> orderGoodList) {
        if(orderGoodList.size()!=0){
            int insertOrderGood= orderGoodMapper.insertByList(orderGoodList);
            if(insertOrderGood!=0){
                return ReturnDate.successResult("添加成功！",insertOrderGood);
            }

        }
        return ReturnDate.fileResult("添加失败！",null);
    }

    @Override
    public BasePageEx<OrderGood> queryList(OrderGoodsRequest orderGoodsRequest) {
        PageHelper.startPage(orderGoodsRequest.getPageNum(),orderGoodsRequest.getPageSize());
        Page<OrderGood> orderGoodPage=   orderGoodMapper.queryList(orderGoodsRequest);

        return new BasePageEx<OrderGood>(orderGoodPage);
    }
}
