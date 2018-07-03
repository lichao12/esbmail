package com.fintech.modules.message.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fintech.modules.message.bean.BaseMessage;
import com.fintech.modules.message.bean.BaseResponse;
import com.fintech.modules.message.enums.PublicEnum;


/**
 * @Description:  邮件管理service
 * @author lc
 * @date 2018年6月27日
 */
@Service
public class MailManageService {
	
	//读取配置文件中的参数
    @Value("${spring.mail.username}")
    private String from; 
	
	@Autowired
	private MailSendService sendService;
	
	private static Logger logger = LoggerFactory.getLogger(MailManageService.class);
	
	/**
	 * @Description: 邮件前置操作
	 * @author lc
	 */
	public BaseResponse preposition(BaseMessage message){
		BaseResponse response = null;
		message.setFrom(from);
		if (PublicEnum.N.getCode().equals(message.getAttachFlag())) {
			response = sendService.sendMail(message);
		} else if (PublicEnum.Y.getCode().equals(message.getAttachFlag())) {
			message.setIs(changeInputStream(message.getAttachContent()));
			response = sendService.sendAttachmentsMail(message);
		}
		return response;
	}
		
	/**
	 * @Description: 字符串转InputStream
	 * @author lc
	 */
	public InputStream changeInputStream(String str){
		InputStream is = null;
		char[] hex = null;
		byte[] data = null;
		try{
			hex = str.toCharArray();
			data= Hex.decodeHex(hex);
			is = new ByteArrayInputStream(data);  
			is.close();
		}catch(Exception e){
			e.printStackTrace();
			logger.error("字符串转InputStream异常！{}", e.getMessage());
		}
		return is;
	}
	
	/**
	 * @Description: InputStream转16进制字符串
	 * @author lc
	 */
	public String changeStr(InputStream is) throws IOException{
		byte[] data=null;
		char[] hex=null;
		try {
			data=new byte[is.available()];
			is.read(data);
			is.close();
			hex=Hex.encodeHex(data);
			System.out.println("byte length:"+data.length);
			System.out.println("--------------------------");
			System.out.println("char hex length:"+hex.length);
			System.out.println("--------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String str = new String(hex);
		System.out.println("String length:"+ str.length());
		return str;  
	}
}
