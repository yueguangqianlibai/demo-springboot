package com.xtang.exception;

import com.xtang.Enums.ResultEnum;

/**
 * @program: springbootdemo
 * @Date: 2019/3/3 21:38
 * @Author: river
 * @Description:
 */
public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
    public Integer getCode(){
        return code;
    }
    public void setCode(Integer code){
        this.code = code;
    }
}
