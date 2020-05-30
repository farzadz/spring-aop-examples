package com.farzadz.springaspect.aspect;

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

  @Pointcut("execution(String com.farzadz.springaspect.aspect.Person.sayHello(..))")
  public void onSayHello() {
  }

}
