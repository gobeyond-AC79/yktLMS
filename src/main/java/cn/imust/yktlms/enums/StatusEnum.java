package cn.imust.yktlms.enums;

import lombok.Getter;

/**
 * @author SERENDIPITY
 */
public enum StatusEnum implements CodeEnum{
    ERROR_STATUS(0,"状态不正常"),
    NORMAL_STATUS(1,"状态正常"),
    ;

    private Integer code;

    private String msg;

    StatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
