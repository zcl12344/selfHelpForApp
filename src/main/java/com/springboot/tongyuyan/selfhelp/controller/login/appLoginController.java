package com.springboot.tongyuyan.selfhelp.controller.login;

import com.springboot.tongyuyan.selfhelp.config.util.TokenUtils;
import com.springboot.tongyuyan.selfhelp.service.user.UserTokenService;
import com.springboot.tongyuyan.selfhelp.tool.PayCommonUtil;
import com.springboot.tongyuyan.selfhelp.tool.config.TimeTool;
import com.springboot.tongyuyan.selfhelp.tool.encryption.MD5Util;
import com.springboot.tongyuyan.selfhelp.tool.randomtool.GetRandom;
import com.springboot.tongyuyan.selfhelp.tool.responestool.ResultDto;
import com.springboot.tongyuyan.selfhelp.tool.responestool.ReturnDate;
import com.springboot.tongyuyan.selfhelp.winter.model.user.UserToken;
import com.springboot.tongyuyan.selfhelp.winter.requstDto.user.MsgTokenRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/appLogin")
public class appLoginController {


    @Autowired
    private UserTokenService userTokenService;


    @RequestMapping(value = "/login")
    @ResponseBody
    public String returnToken(HttpServletRequest request){
        return "login";
    }

    private static final String KEY = "abc123"; // KEY为自定义秘钥
    @RequestMapping(value = "/sendMsg", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> sendMsg(MsgTokenRequest msgTokenRequest) {
//        String phoneNumber = requestMap.get("phoneNumber").toString();
        String randomNum = String.valueOf(PayCommonUtil.buildRandom(6));// 生成随机数
        System.out.println(randomNum);
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MINUTE, 5);
        String currentTime = sf.format(c.getTime());// 生成5分钟后时间，用户校验是否过期
        System.out.println(currentTime);

        //sengMsg(); //此处执行发送短信验证码方法
        String hash = MD5Util.MD5(KEY + "@" + currentTime + "@" + randomNum);//生成MD5值
        System.out.println(hash);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("hash", hash);
        resultMap.put("tamp", currentTime);
        resultMap.put("randomNum",randomNum);
        return resultMap; //将hash值和tamp时间返回给前端
    }

    @RequestMapping(value = "/toLogin", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResultDto<Object> validateNum(MsgTokenRequest msgTokenRequest) {
        String phoneNumber = msgTokenRequest.getPhoneNumber();

        String requestHash = msgTokenRequest.getHash();
        String tamp = msgTokenRequest.getTamp();
        String msgNum = msgTokenRequest.getMsgNum();
        String hash = MD5Util.MD5(KEY + "@" + tamp + "@" + msgNum);
        System.out.println(hash);
        System.out.println(tamp);
        System.out.println(TimeTool.gettime());
        if (tamp.compareTo(TimeTool.gettime()) > 0) {
            if (hash.equalsIgnoreCase(requestHash)){
                UserToken userToken= userTokenService.queryByPhone(phoneNumber);
                SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
                Calendar c = Calendar.getInstance();
                c.add(Calendar.DATE, 5);
                String currentTime = sf.format(c.getTime());// 生成5天后时间，用户校验token是否过期
                String token=TokenUtils.createJwtToken(phoneNumber);
                //校验成功
                if(userToken!=null){
                    userToken.setUserToken(token);
                    userToken.setTokenDisabledTime(currentTime);
                    userTokenService.update(userToken);
                    return ReturnDate.successResult("token生成成功",token);
                }else {
                    UserToken addUserToken=new UserToken();
                    addUserToken.setUserPhone(phoneNumber);
                    System.out.println(token);
                    addUserToken.setUserToken(token);
                    addUserToken.setTokenDisabledTime(currentTime);
                    addUserToken.setUserAppSn(GetRandom.getRandomNum());
                    userTokenService.add(addUserToken);
                    return ReturnDate.successResult("新用戶注冊成功!",token);
                }
            }else {
                //验证码不正确，校验失败
                return ReturnDate.successResult("验证码不正确！",null);
            }
        } else {
            // 超时
            return ReturnDate.successResult("验证码超时！",null);
        }
    }
}
