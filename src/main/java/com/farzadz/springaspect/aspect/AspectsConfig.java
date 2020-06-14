package com.farzadz.springaspect.aspect;

import com.farzadz.springaspect.aspect.AspectAnnotations.SayGoodbyeAspectAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectsConfig {

  // sample advice with inline pointcut for all getters without arguments that return a string
  @Before("execution(String com.farzadz.springaspect.aspect.Person.get*())")
  public void onAllStringGets() {
    System.out.println("onAllStringGets");
  }

  // advice to run upon hitting onSayHello pointcut, capturing the first "String" arg leaving the rest
  @Before("com.farzadz.springaspect.aspect.AspectsConfig.onSayHello() && args(someName,..)")
  public void sayGreetings(String someName) {
    System.out.println("Aspect Greeting to: " + someName);
  }

  @Around("executeAroundAnnotated()")
  public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("Hi from around advice before proceeding joinPoint!");
    Object result = joinPoint.proceed();
    System.out.println("Hi from around advice after proceeding joinPoint!");
    return result;
  }

  /**
   *  See spring AOP example section:
   *   any join point (method execution only in Spring AOP) which takes a single parameter, and where the runtime type of the argument passed has the @Classified annotation:
   *   @args(com.xyz.security.Classified)
   */

  @Around("executeAroundMethodWithAnnotatedArgs() && args(.. ,@com.farzadz.springaspect.aspect.AspectAnnotations.SayGoodbyeAspectAnnotation name, *)")
  public Object aroundArgAnnotatedAdvice(ProceedingJoinPoint joinPoint, String name)
      throws Throwable {
    System.out.println("Bye Bye from aspect : " + name);
    return joinPoint.proceed();
  }

  @Pointcut("execution(String com.farzadz.springaspect.aspect.Person.sayHello(..))")
  public void onSayHello() {
  }

  @Pointcut("@annotation(com.farzadz.springaspect.aspect.AspectAnnotations.ExecuteAroundAspect))")
  public void executeAroundAnnotated() {
  }

  @Pointcut("execution(* *(.., @com.farzadz.springaspect.aspect.AspectAnnotations.SayGoodbyeAspectAnnotation (*), ..))")
  public void executeAroundMethodWithAnnotatedArgs() {
  }


}
