package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(JoinPoint joinPoint) {

        String methodSignature = joinPoint.getSignature().toShortString();
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        Object[] args = joinPoint.getArgs();

        System.out.println("\n=====>>> [API ANALYTICS START]");
        System.out.println("Timestamp     : " + LocalDateTime.now());
        System.out.println("Class         : " + className);
        System.out.println("Method        : " + methodName);
        System.out.println("Signature     : " + methodSignature);
        System.out.println("Arguments     : " + Arrays.toString(args));
        System.out.println("Thread        : " + Thread.currentThread().getName());
        System.out.println("=====>>> [API ANALYTICS END]");
    }
}
