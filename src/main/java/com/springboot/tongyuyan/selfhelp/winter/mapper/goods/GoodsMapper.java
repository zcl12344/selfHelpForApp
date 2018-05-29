package com.springboot.tongyuyan.selfhelp.winter.mapper.goods;

import com.springboot.tongyuyan.selfhelp.winter.model.goods.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> queryGoodsList(@Param(value = "goods") String goods);

   Goods queryByGoodsDate(@Param(value = "dto") Goods goodsDate);

    Goods queryByGoodsn(@Param(value = "dto") String goods);
}