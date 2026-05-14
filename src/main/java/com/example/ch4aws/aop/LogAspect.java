package com.example.ch4aws.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.example.ch4aws.controller..*.*(..))")
    private void ControllerPointCut(){}

    @Around("ControllerPointCut()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint)throws Throwable{
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String method = request.getMethod();
        String methodname = joinPoint.getSignature().getName();

        log.info("[API-LOG] Request:  {} {} ", method, methodname);
        long startTime = System.currentTimeMillis();
        try{
            Object result = joinPoint.proceed();
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;

            log.info("[API - LOG] Response: {} {} Time:{}ms", method, methodname, executionTime);
            return result;
        }catch (Throwable exception){
             log.error("[API - LOG] Error : ", exception);

             throw exception;
        }
    }
}
