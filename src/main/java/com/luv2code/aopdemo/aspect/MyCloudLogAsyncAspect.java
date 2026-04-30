package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    private final Logger logger = Logger.getLogger(getClass().getName());

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void logToCloudAsync(JoinPoint joinPoint) {
        String traceId = generateTraceId();

        // fire-and-forget async logging
        sendLogAsync(joinPoint, traceId);
    }

    @Async
    public void sendLogAsync(JoinPoint joinPoint, String traceId) {
        try {
            String methodName = joinPoint.getSignature().toShortString();
            String className = joinPoint.getSignature().getDeclaringTypeName();

            String logPayload = buildLogPayload(traceId, className, methodName);

            // simulate sending to cloud (replace with real integration: Kafka, ELK, etc.)
            logger.info(logPayload);

        } catch (Exception e) {
            logger.severe("Failed to send async log: " + e.getMessage());
        }
    }

    private String buildLogPayload(String traceId, String className, String methodName) {
        return String.format(
                "TRACE_ID=%s | TIMESTAMP=%s | CLASS=%s | METHOD=%s | EVENT=DAO_METHOD_INVOCATION",
                traceId,
                LocalDateTime.now(),
                className,
                methodName
        );
    }

    private String generateTraceId() {
        return UUID.randomUUID().toString();
    }
}
