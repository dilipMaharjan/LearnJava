package com.dilipmaharjan.learnjava;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author Dilip
 */


@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Before(value = "execution(* com.dilipmaharjan.learnjava.*.*(..))")
    public void logBefore(JoinPoint joinpoint) {
        log.info("Executing join point before:" + joinpoint);
    }
    @Before(value = "execution(* com.dilipmaharjan.learnjava.*.*(..))")
    public void logAfter(JoinPoint joinpoint) {
        log.info("Executing join point after :" + joinpoint);
    }
}
