package com.xtang.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: springbootdemo
 * @Date: 2019/3/3 19:15
 * @Author: river
 * @Description:
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     *"(..)"意思为拦截所有参数
     * 匹配控制器方法
     */
//    @Before("execution(public * com.xtang.controller.GirlController.*(..))")
//    public void log(){
//        System.out.println("+-+-+-");
//    }
//
//    @After("execution(public * com.xtang.controller.GirlController.*(..))")
//    public void logAfter(){
//        System.err.println("-+-+-+");
//    }

    @Pointcut("execution(public * com.xtang.controller.GirlController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.error("url={}",request.getRequestURI());
        //method
        logger.error("method={}",request.getMethod());
        //ip
        logger.error("ip={}",request.getRemoteAddr());
        //类方法
        logger.error("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.error("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void deAfter(){
        logger.info("}{}{}{}{");
//        System.err.println("}{}{}{}{");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }

}
