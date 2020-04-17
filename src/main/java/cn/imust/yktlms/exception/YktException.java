package cn.imust.yktlms.exception;

import cn.imust.yktlms.enums.ResultEnum;
import lombok.Getter;

/**
 * @author SERENDIPITY
 */
@Getter
public class YktException extends RuntimeException{

    private Integer code;

    public YktException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public YktException(Integer code,String message) {
        super(message);
        this.code = code;
    }

}
