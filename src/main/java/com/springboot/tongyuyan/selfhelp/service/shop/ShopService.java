package com.springboot.tongyuyan.selfhelp.service.shop;

import com.springboot.tongyuyan.selfhelp.tool.responestool.BasePageEx;
import com.springboot.tongyuyan.selfhelp.winter.model.shop.ShopInfo;
import com.springboot.tongyuyan.selfhelp.winter.requstDto.shop.ShopInfoRequest;

import java.util.List;

public interface ShopService  {

    public BasePageEx<ShopInfo> queryList(ShopInfoRequest shopInfoRequest);

    public ShopInfo queryShopInfo(ShopInfo shopInfo);

    public List<ShopInfo> queryListByPhone(String userPhone);
}
