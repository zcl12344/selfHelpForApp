package com.springboot.tongyuyan.selfhelp.service.serviceimp;



import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.tongyuyan.selfhelp.service.shop.ShopService;
import com.springboot.tongyuyan.selfhelp.tool.responestool.BasePageEx;
import com.springboot.tongyuyan.selfhelp.winter.mapper.oder.OrderInfoMapper;
import com.springboot.tongyuyan.selfhelp.winter.mapper.shop.ShopInfoMapper;
import com.springboot.tongyuyan.selfhelp.winter.model.shop.ShopInfo;
import com.springboot.tongyuyan.selfhelp.winter.requstDto.shop.ShopInfoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service
public class ShopServiceImp implements ShopService {
    @Autowired
    private ShopInfoMapper shopInfoMapper;
    @Autowired
    private OrderInfoMapper orderInfoMapper;


    @Override
    public BasePageEx<ShopInfo> queryList(ShopInfoRequest shopInfoRequest) {
        PageHelper.startPage(shopInfoRequest.getPageNum(),shopInfoRequest.getPageSize());
        Page<ShopInfo> shopInfoPage= shopInfoMapper.queryShopInfoList(shopInfoRequest);
        return new BasePageEx<ShopInfo>(shopInfoPage);
    }

    @Override
    public ShopInfo queryShopInfo(ShopInfo shopInfo) {
        ShopInfo queryShopInfo= shopInfoMapper.selectShopInfoDate(shopInfo);
        return queryShopInfo;
    }

    @Override
    public List<ShopInfo> queryListByPhone(String userPhone) {
        System.out.println(userPhone);
        List<String> shopId= orderInfoMapper.queryShopIdByPhone(userPhone);
        List<ShopInfo> shopInfoList=new LinkedList<>();
        for (String id:shopId
             ) {
            ShopInfo queryShop= shopInfoMapper.selectByPrimaryKey(Integer.parseInt(id));
        shopInfoList.add(queryShop);
        }

        return shopInfoList;
    }


}
