package com.maxvision.zfba.enums;

/**
 * @author minte
 */
public enum ZyEnum {

    /**登陆成功*/
    LOGIN_SUCCESS("0","login_success"),
    /**登陆失败*/
    LOGIN_FAILURE("1","login_failure")

    ;

    private String code;
    private String msg;

    ZyEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
