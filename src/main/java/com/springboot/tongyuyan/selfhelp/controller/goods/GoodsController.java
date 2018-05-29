package com.springboot.tongyuyan.selfhelp.controller.goods;

import com.springboot.tongyuyan.selfhelp.service.goods.GoodsService;
import com.springboot.tongyuyan.selfhelp.tool.responestool.ResultDto;
import com.springboot.tongyuyan.selfhelp.tool.responestool.ReturnDate;
import com.springboot.tongyuyan.selfhelp.winter.model.goods.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {


    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/getDate")
    public ResultDto<Object> list(Goods goods, HttpServletRequest request) {
      int shopId= (int) request.getSession().getAttribute("shopId");
        Goods qusertGood = goodsService.queryGoods(goods);
        if(qusertGood.getShopId()==(shopId)){
            return ReturnDate.successResult("扫描成功！",qusertGood);
        }
        return ReturnDate.fileResult("该商品不属于本超市",null);

    }

    @RequestMapping(value = "/queryList")
    public List<Goods> queryList(String goods) {
        List<Goods> goodsList = goodsService.queryList(goods);

        return goodsList;

    }


}
