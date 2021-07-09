package com.works.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectMethods {


    @Before("execution(* com.works.services.implemention..*())")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Çalışıyor mu:" + joinPoint.getSignature());
    }

}
