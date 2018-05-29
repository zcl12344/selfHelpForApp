package com.springboot.tongyuyan.selfhelp.tool.responestool;

import java.io.Serializable;

/**
 * 
* @ClassName: ResultDto
* @Description: TODO(这里用一句话描述这个类的作用)
* @yangchoa.cool@gmail.com
* @date 2017年10月17日 上午10:01:31
* 
* @param <T>
 */
public class ResultDto<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int code=200;

    private String mgs = "成功";

    private String message = "成功";

    private T data;
    
    public ResultDto<T> addData(T t) {
    	this.data = t;
    	return this;
    }

    public ResultDto() {
    }

    public ResultDto(T data) {
		super();
		this.data = data;
	}

	public ResultDto(int code, String mgs, String message, T data) {
        this.code = code;
        this.mgs = mgs;
        this.message = message;
        this.data = data;
    }

    public ResultDto(int code, String mgs, String message) {
        this.code = code;
        this.mgs = mgs;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMgs() {
        return mgs;
    }

    public void setMgs(String mgs) {
        this.mgs = mgs;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResultDto [code=" + code + ", mgs=" + mgs + ", message=" + message + ", data=" + data + "]";
	}
}
