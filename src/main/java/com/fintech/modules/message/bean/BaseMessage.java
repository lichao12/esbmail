package com.fintech.modules.message.bean;

import java.io.InputStream;
import java.io.Serializable;

/**
 * @Description: 邮件模型
 * @author lc
 * @date 2018年4月24日
 */
public class BaseMessage implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -8840079326802564269L;
	
	/**
	 * 发送者
	 */
	private String from;
	
	/**
	 * 接受者
	 */
	private String[] to;
	
	/**
	 * 抄送着
	 */
	private String[] cc;
	
	/**
	 * 邮件主题
	 */
	private String subject;
	
	/**
	 * 邮件主题内容
	 */
	private String text;
	
	/**
	 * 标识
	 */
	private String attachFlag;
	
	/**
	 * 附件类型
	 */
	private String attachType;
	
	/**
	 * 附件名称
	 */
	private String attachName;
	
	/**
	 * 附件内容
	 */
	private String attachContent;
	
	/**
	 * 附件流
	 */
	private InputStream is;
	
	public BaseMessage(){
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String[] getTo() {
		return to;
	}


	public void setTo(String[] to) {
		this.to = to;
	}

	public String[] getCc() {
		return cc;
	}

	public void setCc(String[] cc) {
		this.cc = cc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getAttachFlag() {
		return attachFlag;
	}


	public void setAttachFlag(String attachFlag) {
		this.attachFlag = attachFlag;
	}


	public String getAttachType() {
		return attachType;
	}


	public void setAttachType(String attachType) {
		this.attachType = attachType;
	}


	public String getAttachName() {
		return attachName;
	}


	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}


	public String getAttachContent() {
		return attachContent;
	}


	public void setAttachContent(String attachContent) {
		this.attachContent = attachContent;
	}

	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}
}
