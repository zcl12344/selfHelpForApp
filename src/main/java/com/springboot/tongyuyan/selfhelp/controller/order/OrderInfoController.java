package com.springboot.tongyuyan.selfhelp.controller.order;

import com.springboot.tongyuyan.selfhelp.service.order.OrderInfoService;
import com.springboot.tongyuyan.selfhelp.tool.responestool.BasePageEx;
import com.springboot.tongyuyan.selfhelp.tool.responestool.ResultDto;
import com.springboot.tongyuyan.selfhelp.winter.mapper.goods.GoodsMapper;
import com.springboot.tongyuyan.selfhelp.winter.model.goods.Goods;
import com.springboot.tongyuyan.selfhelp.winter.model.order.OrderGood;
import com.springboot.tongyuyan.selfhelp.winter.model.order.OrderInfo;
import com.springboot.tongyuyan.selfhelp.winter.requstDto.order.OrderGoodsRequest;
import com.springboot.tongyuyan.selfhelp.winter.requstDto.order.OrderInfoRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderInfoController {

    @Autowired
    private OrderInfoService orderInfoService;


    @RequestMapping(value = "/add" ,produces = {"application/json;charset=UTF-8"})
    public ResultDto<Object> insertOrder(OrderInfo orderInfo, @RequestParam(value = "orderGoodList") String orderGoodList, HttpServletRequest request){
        System.out.println("商户编号:"+request.getSession().getAttribute("shopCard"));
        List<OrderGood> goodList=new LinkedList<>();
        try {
            JSONArray  myJsonArray = new JSONArray(orderGoodList);
            for(int i=0 ; i < myJsonArray.length() ;i++)
            {
                OrderGood orderGood=new OrderGood();
                //获取每一个JsonObject对象
                JSONObject myjObject = myJsonArray.getJSONObject(i);
                //获取每一个对象中的值
                orderGood.setGoodSn(myjObject.getString("goodSn"));
//                orderGood.setGoodNumber(Short.valueOf(myjObject.getString("commodityNum")));
               orderGood.setReturnGoodsNumber(myjObject.getString("commodityNum"));
                goodList.add(orderGood);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(goodList);
         ResultDto<Object> resultDto= orderInfoService.insert(orderInfo,goodList);
          return resultDto;
    }


    @RequestMapping(value = "/list")
    public BasePageEx<OrderInfo> list(OrderInfoRequest orderInfoRequest){
        BasePageEx<OrderInfo> orderInfoBasePageEx=orderInfoService.queryPageOrder(orderInfoRequest);
        /*if(orderInfoBasePageEx.isLastPage()){
            return null;
        }*/
        if(orderInfoBasePageEx.getPages()<orderInfoRequest.getPageNum()){
            return null;
        }
    return orderInfoBasePageEx;
    }



    @RequestMapping(value = "/update")
    public ResultDto<Object> updateStatus(String orderId,String orderStatus,@RequestParam(value = "orderGoodList") String orderGoodList){

       return orderInfoService.update(orderId,orderStatus,orderGoodList);
    }





}
