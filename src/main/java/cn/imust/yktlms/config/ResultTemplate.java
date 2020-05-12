package cn.imust.yktlms.config;

import java.io.Serializable;

/**
 * @author SERENDIPITY
 * @Date 2020/5/12 21:24
 */
public class ResultTemplate<T> implements Serializable {

    private static final long serialVersionUID = -4619804948541255392L;

    /**
     * 返回成功，用于新增、编辑、删除操作
     * @param msg
     * @return
     */
    public static <T> Result<T> success(String msg) {
        Result <T>  result = new Result<T>();
        result.setResult(true);
        result.setCode(200);
        result.setMsg(msg);
        return result;
    }

    /**
     * 返回成功，用于查询
     * @param data
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> successData(T data, String msg) {
        Result<T> result = new Result<>();
        result.setResult(true);
        result.setCode(200);
        result.setMsg(msg);
        return result;
    }


    /**
     * 返回成功，用于新增、编辑、删除操作
     * @param msg
     * @return
     */
    public static <T> Result<T> fail(String msg) {
        Result <T>  result = new Result<T>();
        result.setResult(false);
        result.setCode(500);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> error(Integer code, String msg) {
        Result <T>  result = new Result<T>();
        result.setResult(false);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
