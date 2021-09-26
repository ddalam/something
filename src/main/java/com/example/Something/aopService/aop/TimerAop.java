package com.example.Something.aopService.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {

    @Pointcut("execution(* com.example.Something.aopService.controller..*.*(..))")
    private void cut() {}

    @Pointcut("@annotation(com.example.Something.aopService.annotation.Timer)")
    private void enableTimer() {}

    // 두 포인트컷을 같이 사용할거다
    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();    // 메서드가 실행되는 지점

        stopWatch.stop();

        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());
    }
}
