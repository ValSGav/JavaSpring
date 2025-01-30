package ru.gb.springdemo.aspect;


import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import com.google.common.base.Defaults;

@Aspect
@Component
public class RecoverExceptionAspect {

    @Pointcut("@annotation(ru/gb/springdemo/aspect/RecoverException.java)")
    public void myServiceBeanMethodsPointcut() {
    }
    @AfterThrowing(value = "myServiceBeanMethodsPointcut()"
            , throwing = "ex")
//    public Object afterThrowingMethodAnnotatedWith(RecoverException rEx, Throwable ex, @org.jetbrains.annotations.NotNull JoinPoint joinPoint) throws Throwable{
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        RecoverException annotation = rEx;
//        if(annotation.noRecoverFor().length > 0 ){
//            for (Class clazz : annotation.noRecoverFor()
//                 ) {
//                if(clazz.isAssignableFrom(ex.getClass())){
//                    throw ex;
//                }
//            }
//        }
//        return Defaults.defaultValue(signature.getReturnType());
//
//    }
    public void afterThrowingMethodAnnotatedWith(RecoverException rX, Throwable eX){
        System.out.println(rX.noRecoverFor() +" "+ eX.toString());
    }
}
