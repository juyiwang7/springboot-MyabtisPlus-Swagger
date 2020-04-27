package com.example.bootMp.api;

import com.example.bootMp.annotation.AopTest;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopTestController {

    @Pointcut(value = "@annotation(com.example.bootMp.annotation.AopTest))")
    public void pointCut(){}

    @After(value = "@annotation(aopTest)")
    public void aroundMethod(AopTest aopTest){
        System.out.println("我定义了一个Aop，传入了参数："+ aopTest.value());
    }

}
