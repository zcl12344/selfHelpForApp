package com.springboot.tongyuyan.selfhelp.tool.config;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeTool {

    public static String gettime(){
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar c = Calendar.getInstance();
        String currentTime = sf.format(c.getTime());// 生成5分钟后时间，用户校验是否过期
       return currentTime;
    }

    public static String getFiveDay(){
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 5);
        String currentTime = sf.format(c.getTime());// 生成5天后时间，用户校验token是否过期
        return currentTime;
    }
}
