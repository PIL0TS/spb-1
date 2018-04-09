package com.tream.common.aop;

import com.tream.common.result.ErrorInfoInterFace;
import com.tream.common.result.GlobalErrorInfoEnum;
import com.tream.common.result.GlobalErrorInfoException;
import com.tream.common.result.ResultBody;
import com.tream.common.tips.ErrorTip;
import io.jsonwebtoken.JwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常拦截，拦截所有控制器（所有@RequestMapping注解的方法）
 */
@ControllerAdvice
public class GlobalExceptionHandler extends BaseControllerExceptionHander {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @ExceptionHandler(value = JwtException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorTip jwtException (JwtException jwtException) {
        logger.error("400异常", jwtException);

        return new ErrorTip(GlobalErrorInfoEnum.TOKEN_ERROR.getCode(),jwtException.getMessage());
    }

    @ExceptionHandler(value = GlobalErrorInfoException.class)
    public ResultBody errorHanderErrorJson (HttpServletRequest request, GlobalErrorInfoException exception) {

        ErrorInfoInterFace errorInfo = exception.getErrorInfo();
        ResultBody result = new ResultBody(errorInfo);
        return  result;
    }

}
