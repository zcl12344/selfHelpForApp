package com.springboot.tongyuyan.selfhelp.controller.WxAndAlipay.wxpay.wxpay01;

import com.springboot.tongyuyan.selfhelp.service.order.OrderInfoService;
import com.springboot.tongyuyan.selfhelp.tool.gitip.GetIpAddr;
import com.springboot.tongyuyan.selfhelp.winter.model.order.OrderInfo;
import com.springboot.tongyuyan.selfhelp.winter.requstDto.order.OrderInfoRequest;
import org.jdom.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping(value = "/wxpay")
public class WxPayController {
    @Autowired
    private OrderInfoService orderInfoService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 微信统一下单接口
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping("/wxPrePay.html")
    public Map<String,Object> wxPrePay(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String OrderId=request.getParameter("tradeId");
        OrderInfoRequest orderInfoRequest=new OrderInfoRequest(OrderId);
        OrderInfo goodsTrade = orderInfoService.queryOrder(orderInfoRequest);//获取订单，根据需要自己编写
//        String price = goodsTrade.getOrderAmount();
        int price100 = goodsTrade.getOrderAmount().multiply(new BigDecimal(100)).intValue();
        if(price100<=0){
            resultMap.put("msg","付款金额错误");
            resultMap.put("code","500");
            return resultMap;
        }
        //设置回调地址-获取当前的地址拼接回调地址
        String url = request.getRequestURL().toString();
        String domain = url.substring(0, url.length()-13);
        //生产环境
        String notify_url= domain+"wxNotify.html";
        //测试环境
        //String notify_url = "http://1f504p5895.51mypc.cn/cia/app/wxNotify.html";

        SortedMap<Object,Object> parameters = new TreeMap<Object,Object>();
        parameters.put("appid", ConfigUtil.APPID);
        parameters.put("mch_id", ConfigUtil.MCH_ID);
        parameters.put("nonce_str", PayCommonUtil.CreateNoncestr());
        parameters.put("body", "购买测试");
        parameters.put("out_trade_no", goodsTrade.getId()); //订单id
        parameters.put("fee_type", "CNY");
        parameters.put("total_fee", String.valueOf(price100));
        parameters.put("spbill_create_ip", GetIpAddr.getIpAddr(request));
        parameters.put("notify_url", notify_url);
        parameters.put("trade_type", "APP");
        //设置签名
        String sign = PayCommonUtil.createSign("UTF-8",parameters);
        parameters.put("sign", sign);
        //封装请求参数结束
        String requestXML = PayCommonUtil.getRequestXml(parameters);
        //调用统一下单接口
        String result = PayCommonUtil.httpsRequest(ConfigUtil.UNIFIED_ORDER_URL, "POST", requestXML);
        System.out.println("\n"+result);
        try {
            /**统一下单接口返回正常的prepay_id，再按签名规范重新生成签名后，将数据传输给APP。参与签名的字段名为appId，partnerId，prepayId，nonceStr，timeStamp，package。注意：package的值格式为Sign=WXPay**/
            Map<String, String> map = XMLUtil.doXMLParse(result);
            SortedMap<Object, Object> parameterMap2 = new TreeMap<Object, Object>();
            parameterMap2.put("appid", ConfigUtil.APPID);
            parameterMap2.put("partnerid", ConfigUtil.MCH_ID);
            parameterMap2.put("prepayid", map.get("prepay_id"));
            parameterMap2.put("package", "Sign=WXPay");
            parameterMap2.put("noncestr", PayCommonUtil.CreateNoncestr());
            //本来生成的时间戳是13位，但是ios必须是10位，所以截取了一下
            parameterMap2.put("timestamp", Long.parseLong(String.valueOf(System.currentTimeMillis()).substring(0,10)));
            String sign2 = PayCommonUtil.createSign("UTF-8",parameterMap2);
            parameterMap2.put("sign", sign2);
            resultMap.put("code","200");
            resultMap.put("msg",parameterMap2);
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    /**
     * 微信异步通知

     */
    @RequestMapping("/wxNotify.html")
    public void wxNotify(HttpServletRequest request,HttpServletResponse response) throws IOException, JDOMException{
        //读取参数
        InputStream inputStream ;
        StringBuffer sb = new StringBuffer();
        inputStream = request.getInputStream();
        String s ;
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        while ((s = in.readLine()) != null){
            sb.append(s);
        }
        in.close();
        inputStream.close();
        //解析xml成map
        Map<String, String> m = new HashMap<String, String>();
        m = XMLUtil.doXMLParse(sb.toString());
        for(Object keyValue : m.keySet()){
            System.out.println(keyValue+"="+m.get(keyValue));
        }
        //过滤空 设置 TreeMap
        SortedMap<Object,Object> packageParams = new TreeMap<Object,Object>();
        Iterator it = m.keySet().iterator();
        while (it.hasNext()) {
            String parameter = (String) it.next();
            String parameterValue = m.get(parameter);

            String v = "";
            if(null != parameterValue) {
                v = parameterValue.trim();
            }
            packageParams.put(parameter, v);
        }

        //判断签名是否正确
        String resXml = "";
        if(PayCommonUtil.isTenpaySign("UTF-8", packageParams)) {
            if("SUCCESS".equals((String)packageParams.get("result_code"))){
                // 这里是支付成功
                //////////执行自己的业务逻辑////////////////
                String mch_id = (String)packageParams.get("mch_id"); //商户号
                String openid = (String)packageParams.get("openid");  //用户标识
                String out_trade_no = (String)packageParams.get("out_trade_no"); //商户订单号
                String total_fee = (String)packageParams.get("total_fee");
                String transaction_id = (String)packageParams.get("transaction_id"); //微信支付订单号
                OrderInfo gt = new OrderInfo();
                gt.setId(Integer.parseInt(out_trade_no));
                //查询订单 根据订单号查询订单  GoodsTrade -订单实体类
                OrderInfoRequest orderInfoRequest=new OrderInfoRequest(out_trade_no);
                OrderInfo trade = orderInfoService.queryOrder(orderInfoRequest);

                if(!ConfigUtil.MCH_ID.equals(mch_id)||trade==null||new BigDecimal(total_fee).compareTo(trade.getOrderAmount().multiply(new BigDecimal(100))) != 0){
                    logger.info("支付失败,错误信息：" + "参数错误");
                    resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                            + "<return_msg><![CDATA[参数错误]]></return_msg>" + "</xml> ";
                }else{
                    if("0".equals(trade.getOrderStatus().toString()) /*&& "wait_buyer_pay".equals(trade.getStatus())*/){//支付的价格
                        //订单状态的修改。根据实际业务逻辑执行


                        resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                                + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";

                    }else{
                        resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                                + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
                        logger.info("订单已处理");
                    }
                }

            }else {
                logger.info("支付失败,错误信息：" + packageParams.get("err_code"));
                resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                        + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
            }


        } else{
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                    + "<return_msg><![CDATA[通知签名验证失败]]></return_msg>" + "</xml> ";
            logger.info("通知签名验证失败");
        }


        //------------------------------
        //处理业务完毕
        //------------------------------
        BufferedOutputStream out = new BufferedOutputStream(
                response.getOutputStream());
        out.write(resXml.getBytes());
        out.flush();
        out.close();

    }
}
