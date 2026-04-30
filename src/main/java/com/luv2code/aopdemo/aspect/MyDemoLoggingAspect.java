package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private final Logger logger = Logger.getLogger(getClass().getName());

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        logMethodDetails(joinPoint);
        logMethodArguments(joinPoint);
    }

    private void logMethodDetails(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        logger.info("\n=====>>> Executing @Before advice");
        logger.info("Method: " + methodSignature.toShortString());
        logger.info("Declaring Type: " + methodSignature.getDeclaringTypeName());
        logger.info("Return Type: " + methodSignature.getReturnType().getSimpleName());
    }

    private void logMethodArguments(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

        if (args == null || args.length == 0) {
            logger.info("No arguments passed.");
            return;
        }

        logger.info("Arguments: " + Arrays.toString(args));

        for (Object arg : args) {
            if (arg == null) {
                logger.warning("Null argument encountered");
                continue;
            }

            logger.info("Argument Type: " + arg.getClass().getSimpleName());

            if (arg instanceof Account account) {
                logAccountDetails(account);
            }
        }
    }

    private void logAccountDetails(Account account) {
        logger.info("Account Details:");
        logger.info(" - Name  : " + safeValue(account.getName()));
        logger.info(" - Level : " + safeValue(account.getLevel()));
    }

    private String safeValue(String value) {
        return value != null ? value : "N/A";
    }
}
