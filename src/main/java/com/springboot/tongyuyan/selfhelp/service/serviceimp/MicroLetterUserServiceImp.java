package com.springboot.tongyuyan.selfhelp.service.serviceimp;

import com.mysql.jdbc.StringUtils;
import com.springboot.tongyuyan.selfhelp.exception.BusinessException;
import com.springboot.tongyuyan.selfhelp.service.user.MicroLetterUserService;
import com.springboot.tongyuyan.selfhelp.tool.config.GlobalEnum;
import com.springboot.tongyuyan.selfhelp.tool.responestool.ResultDto;
import com.springboot.tongyuyan.selfhelp.tool.responestool.ReturnDate;
import com.springboot.tongyuyan.selfhelp.winter.mapper.user.MicroLetterUserMapper;
import com.springboot.tongyuyan.selfhelp.winter.model.user.MicroLetterUser;
import org.codehaus.groovy.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MicroLetterUserServiceImp implements MicroLetterUserService {
    @Autowired
    private MicroLetterUserMapper microLetterUserMapper;

    public ResultDto<Object> success = new ResultDto<Object>(GlobalEnum.GlobalSucceedEnum.SUCCEED.getCode(), "添加成功", "success");

    public ResultDto<Object> faile = new ResultDto<Object>(GlobalEnum.GlobalFailedEnum.FAILED.getCode(), "添加失败", "fail");

    @Override
    public ResultDto<Object> insert(MicroLetterUser microLetterUser) {
        if (microLetterUser != null) {
            int insertNo = microLetterUserMapper.insertSelective(microLetterUser);
            if (insertNo == 0) {
                faile.setMgs("获取用户信息失败！");
                faile.setCode(500);
                return faile;
            }
        }
        success.setMgs("登陆成功！");
        success.setCode(200);
        success.setMessage(microLetterUser.getUserPhone());
        return success;

    }

    @Override
    public MicroLetterUser queryUser(String openid) {
        if (StringUtils.isNullOrEmpty(openid)) {
            new BusinessException("-1", "openid为空！");
        }
        MicroLetterUser microLetterUser = microLetterUserMapper.selectByPrimaryKey(openid);
        if(microLetterUser==null){
            new BusinessException("-1", "用户不存在！");
        }
        return microLetterUser;

    }

    @Override
    public MicroLetterUser queryUserByPhone(String phone) {
        if (StringUtils.isNullOrEmpty(phone)) {
            new BusinessException("-1", "手机号为空！");
        }
        MicroLetterUser microLetterUser = microLetterUserMapper.selectByPrimaryKey(phone);

        return microLetterUser;
    }

    @Override
    public ResultDto<Object> update(MicroLetterUser microLetterUser) {
        MicroLetterUser user = microLetterUserMapper.selectByPrimaryKey(microLetterUser.getUserOppenid());
        if(user!=null){
            user.setFeedBack(microLetterUser.getFeedBack());
           int updateNo= microLetterUserMapper.updateByPrimaryKeySelective(user);
        if(updateNo!=0){
            return ReturnDate.successResult("提交成功","200");

        }
        }
        return ReturnDate.fileResult("提交失败","500");
    }
}
