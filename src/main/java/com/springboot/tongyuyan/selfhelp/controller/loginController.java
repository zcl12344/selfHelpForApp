package com.springboot.tongyuyan.selfhelp.controller;



import com.springboot.tongyuyan.selfhelp.exception.BusinessException;
import com.springboot.tongyuyan.selfhelp.tool.HttpUtils;
import com.springboot.tongyuyan.selfhelp.winter.model.GetDate1;


import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value = "/wx")
public class loginController {

    @ResponseBody
    @RequestMapping(value = "/login")
    public Object addUser(Object cold) {

//        return userService.addUser(user);
        return cold;
    }


    @ResponseBody
    @RequestMapping(value = "/getOppenId",produces = {"application/json;charset=UTF-8"})
    public String getOppendId(@Param(value = "jsCold") String jsCold, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String result = null;
        if (jsCold != null) {
            GetDate1 date = new GetDate1();
            date.setAppId("wx4e43bde9782480fb");
            date.setSecret("5467b270f381a2d8885603e6a5dc160a");
            date.setJsCold(jsCold);
            Map<String, String> parm = new HashMap<>();
            parm.put("js_code", date.getJsCold());
            parm.put("appid", date.getAppId());
            parm.put("secret", date.getSecret());
            parm.put("grant_type", "authorization_code");
            String url = "https://api.weixin.qq.com/sns/jscode2session";
            result = HttpUtils.sendGet(url, parm);
        } else {
            new BusinessException("-1", "参数错误");
        }
        JSONObject jsStr = JSONObject.fromObject(result);
        try {

            String sessionKey = jsStr.getString("session_key");
            System.out.println(sessionKey);
            session.setAttribute("SessionKey", sessionKey);
            System.out.println("这是session:"+session.getAttribute("SessionKey"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println(result.toString());

        return result;
    }

//授权登陆

    @ResponseBody
    @RequestMapping(value = "/login", produces = {"application/json;charset=UTF-8"})
    public Object LoginAuthorization(GetDate1 date) {
        String result = null;
        if (date != null && date.getJsCold() != null && date.getJsCold() != null && date.getSecret() != null) {


            Map<String, String> parm = new HashMap<>();
            parm.put("appid", date.getAppId());
            parm.put("redirect_uri", date.getRedirectUri());
            parm.put("response_type", date.getJsCold());
            parm.put("scope", "snsapi_userinfo");
            parm.put("state", "STATE#wechat_redirect");
            String url = "https://open.weixin.qq.com/connect/oauth2/authorize";
            result = HttpUtils.sendGet(url, parm);
        } else {
            new BusinessException("-1", "参数错误");
        }


        return result;
    }
}


