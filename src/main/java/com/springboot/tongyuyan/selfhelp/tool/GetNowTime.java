package com.springboot.tongyuyan.selfhelp.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetNowTime {

    /**
     * 获取当前系统时间 yyyy-MM-dd hh:mm:ss
     */
    public  static String nowTime(){
        Date now=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
       return sdf.format(now);
    }
}
