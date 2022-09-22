package com.codegym.loger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
@Aspect
public class LogAspect {


    @Pointcut("execution(* com.codegym.controller.BookController.*(..))")
    public void allMethodCallPointCut() {
    }

    @Pointcut("execution(* com.codegym.controller.BookController.home(..))")
    public void allMethodListPointCut() {
    }

    @Before("allMethodCallPointCut()")
    public void beforeCallMethodList(JoinPoint joinPoint) {
        System.err.println(" Prepare to run method   : " +
                joinPoint.getSignature().getName() +
                ":  time : " + LocalDate.now());
    }

}
