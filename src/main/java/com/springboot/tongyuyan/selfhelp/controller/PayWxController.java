package com.springboot.tongyuyan.selfhelp.controller;



import com.google.gson.Gson;
import com.springboot.tongyuyan.selfhelp.tool.HttpUtil;
import com.springboot.tongyuyan.selfhelp.tool.PayCommonUtil;
import com.springboot.tongyuyan.selfhelp.tool.XMLUtil;
import com.springboot.tongyuyan.selfhelp.tool.randomtool.GetRandom;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jdom.JDOMException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

@RestController
@RequestMapping(value = "/pay")
public class PayWxController {

    @Value("${pay.API_KEY}")
    private String API_KEY;
    @Value("${pay.MCH_ID}")
    private String MCH_ID;
    @Value("${pay.APP_ID}")
    private  String APP_ID;

    //微信下单支付
    @ResponseBody
    @RequestMapping("/doOrder")
    public void doOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, JDOMException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //得到openid
        String openid = request.getParameter("openid");
        int fee = 0;
        //得到小程序传过来的价格，注意这里的价格必须为整数，1代表1分，所以传过来的值必须*100；

      /*  request.getParameter("price");
        BigDecimal a1 = new BigDecimal(Double.toString(d));
        BigDecimal b1 = new BigDecimal(Double.toString(100));
        BigDecimal result = a1.multiply(b1);// 相乘结果*/

        if (null != request.getParameter("price")) fee = Integer.parseInt(String.valueOf(Math.round(Double.valueOf(request.getParameter("price").toString())*10*10 * 100) / 100));
        System.out.println(request.getParameter("price"));
        System.out.println(fee);
        //订单编号
        //String did = request.getParameter("did");
        String did= String.valueOf(new Date().getTime())+ GetRandom.getRandomString(4);
        System.out.println(did);
        //订单标题
        String title = request.getParameter("title");
        //时间戳
        String times = System.currentTimeMillis() + "";
        SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
        packageParams.put("appid", APP_ID);
        packageParams.put("mch_id", MCH_ID);
        packageParams.put("nonce_str", times);//时间戳
        packageParams.put("body", title);//支付主体
        packageParams.put("out_trade_no", did);//编号
        packageParams.put("total_fee", fee);//价格
        // packageParams.put("spbill_create_ip", /*GetIpAddr.getIpAddr(request)*/"116.62.119.53");//这里之前加了ip，但是总是获取sign失败，原因不明，之后就注释掉了
        packageParams.put("notify_url","2xq0304864.imwork.net:26249:8181/pay/notify");//支付返回地址，不用纠结这个东西，我就是随便写了一个接口，内容什么都没有
        packageParams.put("trade_type", "JSAPI");//这个api有，固定的
        packageParams.put("openid", openid);//openid
        //获取sign
        String sign = PayCommonUtil.createSign("UTF-8", packageParams, API_KEY);//最后这个是自己设置的32位密钥
        packageParams.put("sign", sign);
        //转成XML
        String requestXML = PayCommonUtil.getRequestXml(packageParams);

        System.out.println(requestXML);
        //得到含有prepay_id的XML
        String resXml = HttpUtil.postData("https://api.mch.weixin.qq.com/pay/unifiedorder", requestXML);
        System.out.println(resXml);
        //解析XML存入Map
        Map map = XMLUtil.doXMLParse(resXml);
        System.out.println(map);
        // String return_code = (String) map.get("return_code");
        //得到prepay_id
        String prepay_id = (String) map.get("prepay_id");
        SortedMap<Object, Object> packageP = new TreeMap<Object, Object>();
        packageP.put("appId", APP_ID);//！！！注意，这里是appId,上面是appid，真怀疑写这个东西的人。。。
        packageP.put("nonceStr", times);//时间戳
        packageP.put("package", "prepay_id=" + prepay_id);//必须把package写成 "prepay_id="+prepay_id这种形式
        packageP.put("signType", "MD5");//paySign加密
        packageP.put("timeStamp", (System.currentTimeMillis() / 1000) + "");
        //得到paySign
        String paySign = PayCommonUtil.createSign("UTF-8", packageP, API_KEY);
        packageP.put("paySign", paySign);
        //将packageP数据返回给小程序
        Gson gson = new Gson();
        String json = gson.toJson(packageP);
        PrintWriter pw = response.getWriter();
        System.out.println(json);
        pw.write(json);
        pw.close();

    }




    //关单接口
    @RequestMapping(value = "/closePay")
    public void closePayMoney(HttpServletRequest request, HttpServletResponse response)throws IOException, JDOMException{
            request.setCharacterEncoding("UTF-8");
           response.setCharacterEncoding("UTF-8");
        //订单编号
        String did = request.getParameter("did");
        //时间戳
        String times = System.currentTimeMillis() + "";
        SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
        packageParams.put("appid", APP_ID);
        packageParams.put("mch_id", MCH_ID);
        packageParams.put("out_trade_no", did);//编号
        packageParams.put("nonce_str", times);//时间戳
        //获取sign
        String sign = PayCommonUtil.createSign("UTF-8", packageParams, API_KEY);//最后这个是自己设置的32位密钥
        packageParams.put("sign", sign);
        //转成XML
        String requestXML = PayCommonUtil.getRequestXml(packageParams);
        //得到含有prepay_id的XML
        String resXml = HttpUtil.postData("https://api.mch.weixin.qq.com/pay/closeorder", requestXML);
        System.out.println("aaaa"+resXml);
        //将packageParams数据返回给小程序
        Gson gson = new Gson();
        String json = gson.toJson(packageParams);
        PrintWriter pw = response.getWriter();
        System.out.println(json);
        pw.write(json);
        pw.close();
    }

    @RequestMapping(value = "/notify")
    public  Map<String, String> parseXml(HttpServletRequest request)
            throws Exception {
        // 解析结果存储在HashMap
        Map<String, String> map = new HashMap<String, String>();
        InputStream inputStream = request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();

        // 遍历所有子节点
        for (Element e : elementList)
            map.put(e.getName(), e.getText());

        // 释放资源
        inputStream.close();
        inputStream = null;
        System.out.println("asdfsadfsadf"+map);
        return map;
    }


}

