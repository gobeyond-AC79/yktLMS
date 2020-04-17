package cn.imust.yktlms.enums;

import lombok.Getter;

public enum RoleEnum implements CodeEnum{

    ROLE_ADMIN(1,"管理员"),
    ROLE_STUDENT(2,"学生"),
    ROLE_TEACHER(3,"教师"),
    ;

    private Integer code;

    private String msg;

    RoleEnum(Integer code, String msg) {
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
