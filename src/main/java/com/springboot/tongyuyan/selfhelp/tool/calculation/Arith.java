package com.springboot.tongyuyan.selfhelp.tool.calculation;

import  java.math.BigDecimal;
/**
 *由于Java的简单类型不能够精确的对浮点数进行运算,这个工具类提供精
 *确的浮点数运算,包括加减乘除和四舍五入。
 */
public class  Arith {  //默认除法运算精度
    private static final int  DEF_DIV_SCALE =  10 ; //这个类不能实例化
    private Arith(){
    }
    /**
     *提供精确的加法运算。
     * @return两个参数的和
     */
    public static double  add(double  v1,double  v2){
        BigDecimal b1 =  new  BigDecimal(Double.toString(v1));
        BigDecimal b2 =  new  BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }
    /**
     *提供精确的减法运算。
     * @return两个参数的差
     */
    public static double  sub(double  v1,double  v2){
        BigDecimal b1 =  new  BigDecimal(Double.toString(v1));
        BigDecimal b2 =  new  BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }
    /**
     *提供精确的乘法运算。
     * @return两个参数的积
     */
    public static double  mul(double  v1,double  v2){
        BigDecimal b1 =  new  BigDecimal(Double.toString(v1));
        BigDecimal b2 =  new  BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }
    /**
     *提供(相对)精确的除法运算,当发生除不尽的情况时,精确到
     *小数点以后10位,以后的数字四舍五入。
     * @return两个参数的商
     */
    public static double  div(double  v1,double  v2){
        return div(v1,v2,DEF_DIV_SCALE);
    }
    /**
     *提供(相对)精确的除法运算。当发生除不尽的情况时,由scale参数指
     *定精度,以后的数字四舍五入。
     * @return两个参数的商
     */
    public static double  div(double  v1,double  v2,int  scale){
        if (scale < 0 ){
            throw new IllegalArgumentException(
                    "规模必须是一个正整数或零" );
        }
        BigDecimal b1 =  new  BigDecimal(Double.toString(v1));
        BigDecimal b2 =  new  BigDecimal(Double.toString(v2));
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    /**
     *提供精确的小数位四舍五入处理。
     * @return四舍五入后的结果
     */
    public static double  round(double  v,int  scale){
        if (scale < 0 ){
            throw new IllegalArgumentException("规模必须是正整数或零" );
        }
        BigDecimal b =  new  BigDecimal(Double.toString(v));
        BigDecimal one =  new BigDecimal("1" );
        return b.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
};