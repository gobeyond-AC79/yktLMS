package cn.imust.yktlms.config;

import cn.imust.yktlms.exception.YktException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author SERENDIPITY
 * @Date 2020/5/12 21:22
 */
public class DefaultExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public Result serverError(Exception e) {
        String errMsg = "";
        if (e instanceof NullPointerException) {
            errMsg = "发生空指针异常";
        } else if (e instanceof RuntimeException) {
            errMsg = "发生运行时异常";
        } else {
            errMsg = "发生未知异常";
        }
        logger.error("############" + errMsg + "############", e);
        return ResultTemplate.error(500, errMsg);
    }

    @ExceptionHandler(value = YktException.class)
    public Result<Object> paramError(YktException e) {
        logger.info("############" + e.getMessage() + "############");
        return ResultTemplate.error(e.getCode(), e.getMessage());
    }
}
