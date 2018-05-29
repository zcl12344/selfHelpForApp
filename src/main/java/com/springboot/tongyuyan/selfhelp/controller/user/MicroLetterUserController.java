package com.springboot.tongyuyan.selfhelp.controller.user;

import com.springboot.tongyuyan.selfhelp.service.user.MicroLetterUserService;
import com.springboot.tongyuyan.selfhelp.tool.AES;
import com.springboot.tongyuyan.selfhelp.tool.responestool.ResultDto;
import com.springboot.tongyuyan.selfhelp.tool.responestool.ReturnDate;
import com.springboot.tongyuyan.selfhelp.winter.model.user.MicroLetterUser;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;

@RestController
@RequestMapping(value = "/user")
public class MicroLetterUserController {


    @Autowired
    private MicroLetterUserService microLetterUserService;

    /**
     * 添加一个用户
     * @param microLetterUser
     * @param request
     * @return
     */
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public ResultDto<Object> insert(MicroLetterUser microLetterUser, HttpServletRequest request) {
        MicroLetterUser queryMicroLetterUser= microLetterUserService.queryUser(microLetterUser.getUserOppenid());
        if(queryMicroLetterUser!=null){
            return ReturnDate.fileResult("该用户已存在",null);
        }
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("SessionKey"));
        /*String SessionKeyValue=(String) session.getAttribute("SessionKey");*/
        try {
            byte[] resultByte = AES.decrypt(Base64.decodeBase64(microLetterUser.getEncryptedData()), Base64.decodeBase64(microLetterUser.getSessionKey()),
                    Base64.decodeBase64(microLetterUser.getIv()));
            if (null != resultByte && resultByte.length > 0) {
                String userInfo = new String(resultByte, "UTF-8");
                System.out.println(userInfo);
                JSONObject JsonDate = JSONObject.fromObject(userInfo);
                String userPhone = JsonDate.getString("phoneNumber");
                microLetterUser.setUserPhone(userPhone);
            }
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println(microLetterUser.toString());
        ResultDto<Object> resultDto = microLetterUserService.insert(microLetterUser);
        return resultDto;
    }

    /**
     * 查询用户
     * @param openID
     * @return
     */
    @RequestMapping(value = "/query", produces = {"application/json;charset=UTF-8"})
    public MicroLetterUser queryUser(@Param(value = "userOppenid") String openID) {
        return microLetterUserService.queryUser(openID);
    }

    /**
     * 意见反馈
     */
    @RequestMapping(value = "/freeBack")
    public  ResultDto<Object> freeBack(MicroLetterUser microLetterUser){
        ResultDto<Object> objectResultDto= microLetterUserService.update(microLetterUser);
    return  objectResultDto;
    }

}
