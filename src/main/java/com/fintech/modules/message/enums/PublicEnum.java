package com.fintech.modules.message.enums;

/**
 * @Description: 公共枚举
 * @author lc
 * @date 2018年6月28日
 */
public enum PublicEnum {

    Y("Y", "有"),
    N("N", "无");
   
	
    PublicEnum(String code, String msg) {
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
