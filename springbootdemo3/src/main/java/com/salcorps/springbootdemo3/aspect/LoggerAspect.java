package com.salcorps.springbootdemo3.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    // Intercept any methods / class of any type + accepting any parameters starting from the url path pattern.
    @Around("execution(* com.salcorps.springbootdemo1..*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info(joinPoint.getSignature().toString() + " method execution start");
        Instant start = Instant.now();
        Object returnObj = joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start,finish).toMillis();

        log.info("Time took to execute " + joinPoint.getSignature().toString() + " method is : " + timeElapsed);
        log.info(joinPoint.getSignature().toString() + " method execution start");
        return returnObj;
    }

    // Handling the logs for all exceptions that might occur across your application.
    @AfterThrowing(value = "execution(* com.salcorps.springbootdemo1.*.*(..)))", throwing = "ex")
    public void logException(JoinPoint joinPoint , Exception ex) {
        log.error(joinPoint.getSignature() + "An exception happened due to : " + ex.getMessage());
    }

}
