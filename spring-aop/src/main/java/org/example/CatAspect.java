package org.example;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

@Aspect
@Component
public class CatAspect {

    @Pointcut("execution(* org.example.Cat.*(..))")
    public void allCatMethods() { }

    @Before("allCatMethods()")
    public void beforeCallAtMethod1(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        System.out.println("before " + jp.toString() + ", args=[" + args + "]");
    }

    @After("allCatMethods()")
    public void afterCallAt(JoinPoint jp) {
        System.out.println("after " + jp.toString());
    }

    @Before("execution(* org.example.Cat.sleep(..))")
    public void beforeSleep(JoinPoint jp) {
        System.out.println("Спаааать!!! " + jp.toString());
    }

    @Before("@annotation(org.example.SayMeow)")
    public void beforeSayMeowAnnotationAdvice(){
        System.out.println("Мяу ! А потом ... ");
    }

  @After("@annotation(org.example.SayMeow)")
    public void afterSayMeowAnnotationAdvice(JoinPoint jp){
        System.out.println("... А теперь - Мяу ! ");
    }

    @Around("execution(* jump(..))")
    public void replaceJump(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Начало: " +  joinPoint.getSignature().getName() +" "+ new Date());

        Object value = joinPoint.proceed();

        System.out.println("Завершение: " +  joinPoint.getSignature().getName() +" "+ new Date());
    }

@AfterThrowing("execution(* crush(..))")
public void ifCatIsBroken(){
    System.out.println("Какой ужас !");
}

}