package com.springboot.tongyuyan.selfhelp.service.user;

import com.springboot.tongyuyan.selfhelp.tool.responestool.ResultDto;
import com.springboot.tongyuyan.selfhelp.winter.model.user.UserToken;

public interface UserTokenService {
    public ResultDto<Object> add(UserToken userToken);

    public  UserToken queryByToken(String token);

    public  UserToken queryByPhone(String phone);

    public  ResultDto<Object> update(UserToken userToken);


}
