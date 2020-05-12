package cn.imust.yktlms.config;

/**
 * @author SERENDIPITY
 * @Date 2020/5/12 21:41
 */
public class Result<T> {

    private String msg;
    private Integer code;
    private Object result;

    public Result() {
    }

    public Result(String msg, Integer code, Object result) {
        this.msg = msg;
        this.code = code;
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
