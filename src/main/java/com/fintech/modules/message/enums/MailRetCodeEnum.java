package com.fintech.modules.message.enums;

/**
 * @Description: 邮件服务统一返回值
 * @author lc
 * @date 2018年6月27日
 */
public enum MailRetCodeEnum {

    SUCC("0000", "邮件发送成功"),
    SMS_FAIL("1000", "邮件发送失败");

    MailRetCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
