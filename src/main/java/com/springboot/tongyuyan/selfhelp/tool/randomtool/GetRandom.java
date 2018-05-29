package com.springboot.tongyuyan.selfhelp.tool.randomtool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GetRandom {
    public static String getId(){
        String id="";
        //获取当前时间戳
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        String temp = sf.format(new Date());
        //获取6位随机数
        int random=(int) ((Math.random()+1)*100000);
        id=temp+random;
        return id;
    }

    public static String getRandomNum(){
        String id="";
        String temp = String.valueOf(System.currentTimeMillis()).substring(9,13);
        //获取6位随机数
        int random=(int) ((Math.random()+1)*100000);
        id=temp+random;
        return id;
    }

    // 随机字符串生成
    public static String getRandomString(int length) { // length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(GetRandom.getRandomNum());
        System.out.println(GetRandom.getRandomNum());
    }

}
