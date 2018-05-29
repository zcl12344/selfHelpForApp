package com.springboot.tongyuyan.selfhelp.tool.responestool;

/**
 * JAVA
* @ClassName: AjaxResult
* @Description: TODO(这里用一句话描述这个类的作用)
* @yangchoa.cool@gmail.com
* @date 2017年7月28日 下午5:26:58
*
 */
public class AjaxResult<T> {

	private boolean success;

	private String msg;

	private T data;

	public AjaxResult<T> returnSuccess(T t) {
		this.data = t;
		this.success = true;
		this.msg = "成功";
		return this;
	}

	public AjaxResult<T> returnFail(String msg) {
		this.success = false;
		this.msg = msg;
		return this;
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "AjaxResult [success=" + success + ", msg=" + msg + ", data=" + data + "]";
	}
}
