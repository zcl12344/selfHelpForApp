package com.springboot.tongyuyan.selfhelp.tool.responestool;

/**
 * 
* @ClassName: BindResultFactory
* @Description: TODO(这里用一句话描述这个类的作用)
* @yangchoa.cool@gmail.com
* @date 2017年10月17日 上午10:13:30
*
 */

public class BindResultFactory {
	
	private BindResultFactory(){}
	
	public static  ResultDto<Object> bindResultFactory(Object param) {
		return new ResultDto<Object>(param);
	}

}
