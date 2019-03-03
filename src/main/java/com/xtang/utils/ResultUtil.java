package com.xtang.utils;

import com.xtang.domain.Result;

/**
 * @program: springbootdemo
 * @Date: 2019/3/3 20:59
 * @Author: river
 * @Description:
 */
public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功!");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code,String Msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(Msg);
        return result;
    }
}
