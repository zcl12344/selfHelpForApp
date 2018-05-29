package com.springboot.tongyuyan.selfhelp.winter.mapper.user;

import com.springboot.tongyuyan.selfhelp.winter.model.user.MicroLetterUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MicroLetterUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(MicroLetterUser record);

    int insertSelective(@Param(value = "dto") MicroLetterUser record);

    MicroLetterUser selectByPrimaryKey(String userOppenid);

    MicroLetterUser selectByPhone(String phone);


    int updateByPrimaryKeySelective(MicroLetterUser record);

    int updateByPrimaryKey(MicroLetterUser record);
}