package com.springboot.tongyuyan.selfhelp.service.goods;

import com.springboot.tongyuyan.selfhelp.winter.model.goods.Goods;
import java.util.List;
public interface GoodsService {
    /**
     * 获取商品单条信息
     */
   public  Goods  queryGoods(Goods goodSn);

    /**
     * 模糊查询订单
     */
    public List<Goods> queryList(String goodSn);
}
