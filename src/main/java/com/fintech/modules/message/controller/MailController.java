package com.fintech.modules.message.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fintech.modules.message.bean.BaseMessage;
import com.fintech.modules.message.bean.BaseResponse;
import com.fintech.modules.message.enums.MailRetCodeEnum;
import com.fintech.modules.message.enums.PublicEnum;
import com.fintech.modules.message.service.MailManageService;
import com.fintech.modules.message.service.MailSendService;

/**
 * @Description: 邮件api
 * @author lc
 * @date 2018年6月26日
 */
@RestController
@RequestMapping("/api/mail")
@Api(tags="邮件api请求入口")
public class MailController {
	
	@Autowired
	private MailManageService manageService;
	@Autowired
	private MailSendService sendService;
	
	 private static Logger logger = LoggerFactory.getLogger(MailController.class);
	 
	 /**
	  * @Description: 通用发送邮件接口
	  * @author lc
	  */
	 @ApiOperation(value= "发送邮件", notes= "发送邮件接口")
	 @RequestMapping(value = "/general/send", method = RequestMethod.POST, produces = "application/json")
	 @ResponseBody
	 public String generalSend(HttpServletRequest request, @Valid @RequestBody BaseMessage baseMessage, BindingResult result){
		 logger.info("[通用请求]开始请求发送邮件, 业务原始请求参数为: {}", JSONObject.toJSONString(baseMessage));
		 Assert.notNull(baseMessage.getTo(), "邮件缺少接收者信息");
		 Assert.notNull(baseMessage.getSubject(), "邮件缺少主题信息");
		 Assert.notNull(baseMessage.getAttachFlag(), "邮件缺少标识信息");
		 if(PublicEnum.Y.getCode().equals(baseMessage.getAttachFlag())){
			 Assert.notNull(baseMessage.getAttachType(), "邮件缺少附件类型信息");
			 Assert.notNull(baseMessage.getAttachName(), "邮件缺少附件名称信息");
			 Assert.notNull(baseMessage.getAttachContent(), "邮件缺少附件内容信息");
		 }
		 BaseResponse response = manageService.preposition(baseMessage);
		 if(response == null){
			 response = new BaseResponse(MailRetCodeEnum.SUCC.getCode(), "邮件发送成功", null);
		 }
		 logger.info("[通用请求]发送邮件完成, 返回业务响应信息为: {}", JSONObject.toJSONString(response));
		 return JSONObject.toJSONString(response);
	 }
	 
    /**
     * @Description: 发送邮件是否连通
     * @author lc
     * @throws Exception 
     */
	@ApiOperation(value= "检查邮件服务器连通性", notes= "发送邮件检查是否连通邮件服务器")
	@RequestMapping(value = "/sendEmailReq", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String sendEmailReq(@RequestBody BaseMessage email) {
		logger.info("发送开始-邮件信息：{}", JSONArray.toJSON(email));
		BaseResponse response = sendService.sendMail(email);
		if(response == null ){
			response = new BaseResponse(MailRetCodeEnum.SUCC.getCode(), "邮件发送成功", null);
		}
		logger.info("发送结束{}");
		return JSONObject.toJSONString(response);
	}
}
