package com.fintech.modules.message.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: TODO
 * @author lc
 * @date 2018年6月27日
 */
public class BaseResponse implements Serializable{
	
    /**
     * 返回状态
     */
    private String retCode;
    
    /**
     * 返回消息
     */
    private String retMsg;
    
    /**
     * 返回时间
     */
    private String retTime;
    
    /**
     * 返回错误信息
     */
    private String retError;
    
    public BaseResponse(){
    	
    }
    
    public BaseResponse(String retCode, String retMsg, String retError){
    	this.retCode = retCode;
    	this.retMsg = retMsg;
    	this.retTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    	this.retError = retError;
    }

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public String getRetTime() {
		return retTime;
	}

	public void setRetTime(String retTime) {
		this.retTime = retTime;
	}

	public String getRetError() {
		return retError;
	}

	public void setRetError(String retError) {
		this.retError = retError;
	}
}
