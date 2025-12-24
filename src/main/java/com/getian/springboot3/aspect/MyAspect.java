package com.getian.springboot3.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* com.getian.springboot3.service.UserService.*(..))")
    public void myExecution(){}

    @Before("myExecution()")
    public void before(){
        System.out.println("Service方法即将执行");
    }
}
