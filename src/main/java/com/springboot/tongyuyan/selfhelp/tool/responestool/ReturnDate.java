package com.springboot.tongyuyan.selfhelp.tool.responestool;

import com.springboot.tongyuyan.selfhelp.tool.config.GlobalEnum;

public class ReturnDate {



    public static ResultDto<Object> fileResult(String msg,Object date){
        ResultDto<Object> faile =  new ResultDto<Object>(GlobalEnum.GlobalFailedEnum.FAILED.getCode(),"添加失败","fail",date);

        faile.setMgs(msg);
        return faile;

    }

    public static ResultDto<Object> successResult(String msg,Object date){
        ResultDto<Object> success =  new ResultDto<Object>(GlobalEnum.GlobalSucceedEnum.SUCCEED.getCode(),"添加成功","success" ,date);

        success.setMgs(msg);
        return success;

    }


}
