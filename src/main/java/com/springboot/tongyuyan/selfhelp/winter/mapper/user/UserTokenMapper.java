package com.springboot.tongyuyan.selfhelp.winter.mapper.user;


import com.springboot.tongyuyan.selfhelp.winter.model.user.UserToken;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTokenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserToken record);

    int insertSelective(UserToken record);

    UserToken selectByPrimaryKey(Integer id);

    UserToken selectByToken(String token);

    UserToken selectByPhone(String phone);

    UserToken selectByUser(@Param(value = "dto") UserToken userToken);

    int updateByPrimaryKeySelective(UserToken record);

    int updateByPrimaryKey(UserToken record);
}