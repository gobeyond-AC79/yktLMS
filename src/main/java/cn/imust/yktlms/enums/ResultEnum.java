package cn.imust.yktlms.enums;

import lombok.Getter;

/**
 * @author SERENDIPITY
 */
public enum ResultEnum implements CodeEnum{
    NOT_FOUND_COURSE(1,"未找到该课程！"),
    NOT_FOUND_TEACHER(2,"未找到该教师！"),
    NOT_FOUND_STUDENT(3,"未找到该学生！"),
    PASSWORD_REST_FAIL(4,"管理员账户不可修改！"),
    NOT_FOUND_USER(5,"未找到该用户！"),
    NOT_SAME_PASSWORD(6,"旧密码不正确！"),
    ATTENDANCE_FAIL(7,"签到失败！")

    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
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
