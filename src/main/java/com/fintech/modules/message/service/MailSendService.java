package com.fintech.modules.message.service;

import javax.activation.DataSource;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.fintech.modules.message.bean.BaseMessage;
import com.fintech.modules.message.bean.BaseResponse;
import com.fintech.modules.message.enums.MailRetCodeEnum;


/**
 * @Description: 邮件发送service
 * @author lc
 * @date 2018年4月24日
 */
@Service
public class MailSendService {
	
	private static Logger logger = LoggerFactory.getLogger(MailSendService.class);
	
	@Autowired
	private JavaMailSender mailSender;
   
   
   /**
    * @Description: 发送普通邮件
    * @author lc
    */
   public BaseResponse sendMail(BaseMessage email){
	   BaseResponse response = null;
	   MimeMessage message = null;
	    try {
	        message = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setFrom(email.getFrom());
	        helper.setTo(email.getTo());
	        helper.setSubject(email.getSubject());
	        // 发送htmltext值需要给个true，不然不生效
	        helper.setText(email.getText(), true);
			if(email.getCc() != null){
				helper.setCc(email.getCc());
			}
			mailSender.send(message);
	    } catch (Exception e) {
	    	logger.error("发送普通邮件异常！{}",e);
	    	response = new BaseResponse(MailRetCodeEnum.SMS_FAIL.getCode(), "发送普通邮件异常", e.getMessage());
	    }
	    return response;
   }
   
   /**
    * @Description: 发送带附件的邮件
    * @author lc
    */
   public BaseResponse sendAttachmentsMail(BaseMessage email){
	   BaseResponse response = null;
	   MimeMessage message = null;
       try {
           message = mailSender.createMimeMessage();
           MimeMessageHelper helper = new MimeMessageHelper(message, true);
           helper.setFrom(email.getFrom());
           helper.setTo(email.getTo());
           helper.setSubject(email.getSubject());
           helper.setText(email.getText());
           if(email.getCc() != null){
        	   helper.setCc(email.getCc());
           }
           // 用流的形式发送附件邮件
           DataSource source = new ByteArrayDataSource(email.getIs(), email.getAttachType());  
           helper.addAttachment(email.getAttachName(), source);
           mailSender.send(message);
       } catch (Exception e){
           logger.error("发送附件邮件异常！{}",e);
           response = new BaseResponse(MailRetCodeEnum.SMS_FAIL.getCode(), "发送附件邮件异常", e.getMessage());
       }
       return response;
   }
}
