package com.springboot.tongyuyan.selfhelp.service.user;

import com.springboot.tongyuyan.selfhelp.tool.responestool.ResultDto;
import com.springboot.tongyuyan.selfhelp.winter.model.user.MicroLetterUser;

public interface MicroLetterUserService {


    /**
     * 添加用户
     * @param microLetterUser
     * @return
     */
  public ResultDto<Object> insert(MicroLetterUser microLetterUser);

    /**
     * 根据oppenID查询
     */
    public MicroLetterUser queryUser(String openid);

  /**
   * 根据phone查询
   */
  public MicroLetterUser queryUserByPhone(String phone);

    /**
     *  意见反馈
     */
    public ResultDto<Object> update(MicroLetterUser microLetterUser);
}
