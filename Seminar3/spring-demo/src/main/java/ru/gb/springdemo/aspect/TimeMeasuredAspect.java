package ru.gb.springdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Timer;

@Slf4j
@Component
@Aspect
public class TimeMeasuredAspect {
    @Pointcut("within(@ru.gb.springdemo.aspect.TimeMeasured *)")
    public void beansAnnotatedWith() {

    }

    @Pointcut("@annotation(ru.gb.springdemo.aspect.TimeMeasured)")
    public void methodsAnnotatedWith() {

    }

    @Around("beansAnnotatedWith() || methodsAnnotatedWith()")
    public Object loggableAspect(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        try {
            Object returnValue = joinPoint.proceed();
            log.info("class name {} method name {} execution time {}"
                    , joinPoint.getTarget().getClass()
                    , joinPoint.getSignature().getName()
                    , System.currentTimeMillis() - startTime);
            return returnValue;
        } catch (Throwable e) {
            log.info("exception = [{} {}]", e.getClass(), e.getMessage());
            throw e;
        }
    }
}
