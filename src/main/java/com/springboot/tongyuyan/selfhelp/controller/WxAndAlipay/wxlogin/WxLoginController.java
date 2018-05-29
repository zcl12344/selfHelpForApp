package com.springboot.tongyuyan.selfhelp.controller.WxAndAlipay.wxlogin;

import com.springboot.tongyuyan.selfhelp.config.util.TokenUtils;
import com.springboot.tongyuyan.selfhelp.service.user.UserTokenService;
import com.springboot.tongyuyan.selfhelp.tool.config.TimeTool;
import com.springboot.tongyuyan.selfhelp.tool.randomtool.GetRandom;
import com.springboot.tongyuyan.selfhelp.tool.responestool.ResultDto;
import com.springboot.tongyuyan.selfhelp.tool.responestool.ReturnDate;
import com.springboot.tongyuyan.selfhelp.winter.mapper.user.UserTokenMapper;
import com.springboot.tongyuyan.selfhelp.winter.model.user.UserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/wxlogin")
public class WxLoginController {

    @Autowired
    private UserTokenService userTokenService;
    @Autowired
    private UserTokenMapper userTokenMapper;
    @RequestMapping(value = "")
    public ResultDto<Object> wxlogin(UserToken userToken){
        if(userToken.getAppOpenId()!=null){
        UserToken queryUserToken= userTokenMapper.selectByUser(userToken);

        if(queryUserToken.getUserPhone()!=null){
            String token= TokenUtils.createJwtToken(queryUserToken.getUserPhone());
            queryUserToken.setTokenDisabledTime(TimeTool.getFiveDay());
            queryUserToken.setUserToken(token);
            userTokenService.update(queryUserToken);
             return ReturnDate.successResult("201",queryUserToken.getUserPhone());
        }
        }
        userToken.setUserAppSn(GetRandom.getRandomNum());
        ResultDto<Object> resultDto=userTokenService.add(userToken);
        return resultDto;

    }

/*
    @RequestMapping(value = "")
    public void wxlogin(MicroLetterUser microLetterUser){
        try {
            byte[] resultByte = AES.decrypt(Base64.decodeBase64(microLetterUser.getEncryptedData()), Base64.decodeBase64(microLetterUser.getSessionKey()),
                    Base64.decodeBase64(microLetterUser.getIv()));
            if (null != resultByte && resultByte.length > 0) {
                String userInfo = null;
                try {
                    userInfo = new String(resultByte, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                System.out.println(userInfo);
                JSONObject JsonDate = JSONObject.fromObject(userInfo);
                String userPhone = JsonDate.getString("phoneNumber");
                microLetterUser.setUserPhone(userPhone);
                System.out.println(userPhone);
            }
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }

    }*/
}
