package com.springboot.tongyuyan.selfhelp.service.serviceimp;

import com.springboot.tongyuyan.selfhelp.service.user.UserTokenService;
import com.springboot.tongyuyan.selfhelp.tool.responestool.ResultDto;
import com.springboot.tongyuyan.selfhelp.tool.responestool.ReturnDate;
import com.springboot.tongyuyan.selfhelp.winter.mapper.user.UserTokenMapper;
import com.springboot.tongyuyan.selfhelp.winter.model.user.UserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTokenServiceImp implements UserTokenService {
    @Autowired
    private UserTokenMapper userTokenMapper;



    @Override
    public ResultDto<Object> add(UserToken userToken) {
        int insertNo= userTokenMapper.insertSelective(userToken);
        if(insertNo!=0){
            ReturnDate.successResult("200","用户添加成功");
        }
        return ReturnDate.fileResult("500","添加失败");
    }

    @Override
    public UserToken queryByToken(String token) {
        return userTokenMapper.selectByToken(token);
    }

    @Override
    public UserToken queryByPhone(String phone) {
        return userTokenMapper.selectByPhone(phone);
    }

    @Override
    public ResultDto<Object> update(UserToken userToken) {
        int upNo=userTokenMapper.updateByPrimaryKeySelective(userToken);
        if(upNo!=0){
            return ReturnDate.successResult("200","修改成功");
        }
        return ReturnDate.fileResult("500","修改失敗");
    }


}
