package cn.imust.yktlms.enums;

import lombok.Getter;

/**
 * @author SERENDIPITY
 */
public enum LoginErrorEnum {
    ERROR_PASSWORD(0,"密码不正确"),
    ERROR_ACCOUNT(1,"账户不存在"),
    ERROR_KAPTCHA(2,"验证码不正确"),
    ;

    private Integer code;

    private String msg;

    LoginErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
