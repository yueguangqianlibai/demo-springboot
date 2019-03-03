package com.xtang.controller;

import com.xtang.properties.GirlPorperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springbootdemo
 * @Date: 2019/3/3 13:40
 * @Author: river
 * @Description:
 */
@RestController
public class HelloController {

    //配置内容的注入
//    @Value("${cupSize}")
//    private String cupSize;
//
//    @Value("${age}")
//    private int age;
//
//    @Value("${content}")
//    private String content;

    @Autowired
    private GirlPorperties girlPorperties;

    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
    public String say(){
//        return cupSize + age;
//        return content;
        return girlPorperties.getCupSize();
//        return "index";
    }
}
