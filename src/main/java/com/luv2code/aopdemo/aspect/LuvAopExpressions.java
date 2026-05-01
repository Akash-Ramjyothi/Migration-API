package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

    // ==============================
    // Base Package Pointcuts
    // ==============================

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.luv2code.aopdemo.service.*.*(..))")
    public void forServicePackage() {}

    @Pointcut("execution(* com.luv2code.aopdemo.controller.*.*(..))")
    public void forControllerPackage() {}

    // ==============================
    // Method Type Pointcuts
    // ==============================

    // getters
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    public void getter() {}

    // setters
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    public void setter() {}

    // business methods (exclude getters/setters)
    @Pointcut("!(getter() || setter())")
    public void noGetterSetter() {}

    // ==============================
    // Combined Pointcuts
    // ==============================

    // DAO layer business logic
    @Pointcut("forDaoPackage() && noGetterSetter()")
    public void forDaoPackageNoGetterSetter() {}

    // Service layer
    @Pointcut("forServicePackage()")
    public void forServiceLayer() {}

    // Controller layer
    @Pointcut("forControllerPackage()")
    public void forControllerLayer() {}

    // All application layers (excluding getters/setters)
    @Pointcut("(forDaoPackage() || forServicePackage() || forControllerPackage()) && noGetterSetter()")
    public void forAppFlow() {}
}
