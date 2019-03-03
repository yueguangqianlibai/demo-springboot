package com.xtang.handle;

import com.xtang.controller.GirlController;
import com.xtang.domain.Result;
import com.xtang.exception.GirlException;
import com.xtang.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: springbootdemo
 * @Date: 2019/3/3 21:30
 * @Author: river
 * @Description:
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else {
            logger.error("[系统异常]",e);
            return ResultUtil.error(-1,"未知错误");
        }

    }
}
