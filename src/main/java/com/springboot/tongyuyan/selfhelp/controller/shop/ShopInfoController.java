package com.springboot.tongyuyan.selfhelp.controller.shop;

import com.springboot.tongyuyan.selfhelp.service.shop.ShopService;
import com.springboot.tongyuyan.selfhelp.tool.responestool.BasePageEx;
import com.springboot.tongyuyan.selfhelp.tool.responestool.ResultDto;
import com.springboot.tongyuyan.selfhelp.tool.responestool.ReturnDate;
import com.springboot.tongyuyan.selfhelp.winter.model.shop.ShopInfo;
import com.springboot.tongyuyan.selfhelp.winter.requstDto.shop.ShopInfoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/shop")
public class ShopInfoController {

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/list")
    public BasePageEx<ShopInfo> list( ShopInfoRequest shopInfoRequest,HttpServletRequest request) {
        return  shopService.queryList(shopInfoRequest);

    }

    @RequestMapping(value = "/dateOne")
    public ResultDto<Object> queryOne(ShopInfo shopInfo, HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
//        String idCard = (String) session.getAttribute("shopCard");
        ShopInfo shopInfoDate = shopService.queryShopInfo(shopInfo);
        if (shopInfoDate == null) {
            return ReturnDate.fileResult("该商店不存在！",null);
        }else {
            session.setAttribute("shopId", shopInfoDate.getId());
        }

        return ReturnDate.successResult("获取商店信息成功！",shopInfoDate);

    }

    @RequestMapping(value = "/query")
    public List<ShopInfo> queryList(String userPhone){
        return     shopService.queryListByPhone(userPhone);
    }

}
