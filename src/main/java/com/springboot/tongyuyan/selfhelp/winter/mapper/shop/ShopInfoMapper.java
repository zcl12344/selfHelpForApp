package com.springboot.tongyuyan.selfhelp.winter.mapper.shop;

import com.github.pagehelper.Page;
import com.springboot.tongyuyan.selfhelp.winter.model.shop.ShopInfo;
import com.springboot.tongyuyan.selfhelp.winter.requstDto.shop.ShopInfoRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopInfo record);

    int insertSelective(ShopInfo record);

    ShopInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopInfo record);

    int updateByPrimaryKey(ShopInfo record);

    Page<ShopInfo> queryShopInfoList(@Param(value = "dto")ShopInfoRequest shopInfoRequest);

    ShopInfo selectShopInfoDate(@Param(value = "dto")ShopInfo shopInfoRequest);
}