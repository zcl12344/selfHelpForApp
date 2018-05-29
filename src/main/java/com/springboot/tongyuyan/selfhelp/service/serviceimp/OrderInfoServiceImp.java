package com.springboot.tongyuyan.selfhelp.service.serviceimp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mysql.jdbc.StringUtils;
import com.springboot.tongyuyan.selfhelp.service.order.OrderInfoService;
import com.springboot.tongyuyan.selfhelp.tool.responestool.BasePageEx;
import com.springboot.tongyuyan.selfhelp.tool.responestool.ResultDto;
import com.springboot.tongyuyan.selfhelp.tool.responestool.ReturnDate;
import com.springboot.tongyuyan.selfhelp.winter.mapper.goods.GoodsMapper;
import com.springboot.tongyuyan.selfhelp.winter.mapper.oder.OrderGoodMapper;
import com.springboot.tongyuyan.selfhelp.winter.mapper.oder.OrderInfoMapper;
import com.springboot.tongyuyan.selfhelp.winter.mapper.shop.ShopInfoMapper;
import com.springboot.tongyuyan.selfhelp.winter.model.goods.Goods;
import com.springboot.tongyuyan.selfhelp.winter.model.order.OrderGood;
import com.springboot.tongyuyan.selfhelp.winter.model.order.OrderInfo;
import com.springboot.tongyuyan.selfhelp.winter.requstDto.order.OrderInfoRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Service
public class OrderInfoServiceImp implements OrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private OrderGoodMapper orderGoodMapper;
    @Autowired
    private ShopInfoMapper shopInfoMapper;




    @Override
    public ResultDto<Object> insert(OrderInfo orderInfo,List<OrderGood> orderGoodDateList) {

     if(orderInfo!=null&&orderGoodDateList.size()!=0){
            //orderInfo.setId(GetRandom.getId());
            orderInfo.setOrderStatus((short)0);
            orderInfo.setIsMerchant(true);
            orderInfo.setIsOnline(false);
            orderInfo.setShippingStatus((short) 0);
            orderInfo.setShopId(orderInfo.getShopId());
            int insertNo= orderInfoMapper.insert(orderInfo);
            Integer allWeight=0;
            for (OrderGood orderGood:orderGoodDateList){
                if(!StringUtils.isNullOrEmpty(orderGood.getGoodSn())&&!StringUtils.isNullOrEmpty(orderGood.getReturnGoodsNumber().toString())){
                orderGood.setOrderId(orderInfo.getId());
               Goods goods= goodsMapper.queryByGoodsn(orderGood.getGoodSn());
               orderGood.setGoodName(goods.getGoodName());
               if(goods.getIsScattered()){
                   orderGood.setGoodWeight(new BigDecimal(orderGood.getReturnGoodsNumber()));
                 BigDecimal a=  new BigDecimal(orderGood.getReturnGoodsNumber());
                  BigDecimal b=a.multiply(new BigDecimal(1000));
                 String c= b.toString();
                 String e=c.substring(0,c.length()-4);
                       Integer d=  Integer.parseInt(e);
                   orderGood.setIntegral(d);
                  allWeight+=d;
               }else {
                   orderGood.setGoodNumber(Short.valueOf(orderGood.getReturnGoodsNumber()));
                   Integer weight=goods.getGiveIntegral()*Integer.parseInt(orderGood.getReturnGoodsNumber());
                   orderGood.setIntegral(weight);
                   allWeight+=weight;

               }
               orderGood.setGoodImg(goods.getGoodImg());
               orderGood.setGoodPrice(goods.getShopPrice());
               orderGood.setGoodAmount(goods.getShopPrice().multiply((new BigDecimal(orderGood.getReturnGoodsNumber()))));
               orderGood.setGoodId(goods.getId());

               orderGood.setProfit((goods.getShopPrice().subtract(goods.getPurchasePrice())).multiply((new BigDecimal(orderGood.getReturnGoodsNumber()))));
               orderGood.setIsReturnable(goods.getIsReturnable());
               orderGood.setIsReturned(false);
               /*int a=goods.getGiveIntegral();
               int b=Integer.parseInt(orderGood.getReturnGoodsNumber());
               int c=a*b;*/
                }
            }
           int insertGoodNum= orderGoodMapper.insertByList(orderGoodDateList);
         orderInfo.setIntegrals(allWeight);
            orderInfoMapper.updateByPrimaryKeySelective(orderInfo);
            if(insertNo!=0&&insertGoodNum!=0){
                return ReturnDate.successResult("添加成功!",orderInfo.getId());
            }

        }

        return ReturnDate.fileResult("添加失败!",null);
    }

    @Override
    public BasePageEx<OrderInfo> queryPageOrder(OrderInfoRequest orderInfoRequest) {
        PageHelper.startPage(orderInfoRequest.getPageNum(),orderInfoRequest.getPageSize());
        Page<OrderInfo> orderInfoPage=   orderInfoMapper.queryOrderInfoPageList(orderInfoRequest);
        return new BasePageEx<OrderInfo>(orderInfoPage);
    }

    @Override
    public ResultDto<Object> update(String orderId,String orderStatus,String orderGoodList) {
        int updateNo= orderInfoMapper.updateById(orderId,orderStatus);
        if(updateNo!=0&&"1".equals(orderStatus)){
            List<OrderGood> goodList=new LinkedList<>();
            try {
                JSONArray myJsonArray = new JSONArray(orderGoodList);
                for(int i=0 ; i < myJsonArray.length() ;i++)
                {
                    OrderGood orderGood=new OrderGood();
                    //获取每一个JsonObject对象
                    JSONObject myjObject = myJsonArray.getJSONObject(i);
                    //获取每一个对象中的值
                    orderGood.setGoodSn(myjObject.getString("goodSn"));
                    //orderGood.setGoodNumber(Short.valueOf(myjObject.getString("commodityNum")));
                    orderGood.setReturnGoodsNumber(myjObject.getString("commodityNum"));

                    goodList.add(orderGood);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Goods newGoods=new Goods();
            for(OrderGood orderGood:goodList){
                Goods goods= goodsMapper.queryByGoodsn(orderGood.getGoodSn());
                if(goods.getIsScattered()){
                    newGoods.setGoodWeight(goods.getGoodWeight().subtract(new BigDecimal(orderGood.getReturnGoodsNumber())));
                }else {
                    newGoods.setGoodNumber((short) (goods.getGoodNumber()-Short.valueOf(orderGood.getReturnGoodsNumber())));
                }
                newGoods.setId(goods.getId());
                
                goodsMapper.updateByPrimaryKeySelective(newGoods);
            }

            return ReturnDate.successResult("支付成功","");

        }

        return ReturnDate.fileResult("支付失败","");
    }

    @Override
    public OrderInfo queryOrder(OrderInfoRequest orderInfoRequest) {
      return   orderInfoMapper.selectByOrderRequest(orderInfoRequest);
    }
}
