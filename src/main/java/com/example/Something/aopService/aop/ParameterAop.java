package com.example.Something.aopService.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ParameterAop {

    // 어느 지점에 AOP를 적용할 것인지
    @Pointcut("execution(* com.example.Something.aopService.controller..*.*(..))")
    private void cut() {

    }

    // cut() 포인트컷이 적용되는 지점이 실행되기 전에
    // JoinPoint : 들어가는 지점에 대한 정보를 가지고 있다
    @Before("cut()")
    private void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        Object[] args = joinPoint.getArgs();    // 메서드에 들어가는 Argument들
        for (Object arg : args) {
            System.out.println("type = " + arg.getClass().getSimpleName());
            System.out.println("arg = " + arg);
        }
    }

    // cut() 포인트컷이 적용되는 지점의 반환값
    @AfterReturning(value = "cut()", returning = "returnObj")
    private void afterReturn(JoinPoint joinPoint, Object returnObj) {
        System.out.println("returnObj = " + returnObj);
    }
}
