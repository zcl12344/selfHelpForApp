package com.springboot.tongyuyan.selfhelp.service.serviceimp;

import com.springboot.tongyuyan.selfhelp.exception.BusinessException;
import com.springboot.tongyuyan.selfhelp.service.goods.GoodsService;
import com.springboot.tongyuyan.selfhelp.winter.mapper.goods.GoodsMapper;
import com.springboot.tongyuyan.selfhelp.winter.model.goods.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImp implements GoodsService{

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Goods queryGoods(Goods goods) {
        if(goods.getGoodSn()==null){
            throw new BusinessException("500","传入编号不能为空");
        }
       Goods goodsDate= goodsMapper.queryByGoodsDate(goods);
        return goodsDate;
    }

    @Override
    public List<Goods> queryList(String goods) {
       List<Goods> goodsList= goodsMapper.queryGoodsList(goods);
        return goodsList;
    }


}
