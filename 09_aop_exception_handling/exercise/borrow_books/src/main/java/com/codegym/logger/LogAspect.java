package com.codegym.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Component
@Aspect
public class LogAspect {
    private int count = 0;

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

    @Pointcut("within(com.codegym.controller.BookController*)")
    public void allMethod() {
    }

    @After("allMethod()")
    public void afterAllMethod(JoinPoint joinPoint) {
        count++;
        System.err.println("Method name: " + joinPoint.getSignature().getName() +
                count + " times");
    }

    @Pointcut("execution(* com.codegym.controller.BookController.giveBook*(..))")
    public void payAndBorrowMethod() {
    }


    @After("payAndBorrowMethod()")
    public void afterPayAndBorrowMethod(JoinPoint joinPoint) {
        System.err.println("Method name: " + joinPoint.getSignature().getName() + " | Time: " + LocalDateTime.now());
    }


    @Pointcut("execution(* com.codegym.controller.BookController.borrowBook*(..))")
    public void payAndBorrowMethod1() {
    }

    @After("payAndBorrowMethod1()")
    public void afterPayAndBorrowMethod1(JoinPoint joinPoint) {
        System.err.println("Method name: " + joinPoint.getSignature().getName() + " | Time: " + LocalDateTime.now());
    }
}
