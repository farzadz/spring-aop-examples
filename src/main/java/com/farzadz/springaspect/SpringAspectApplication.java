package com.farzadz.springaspect;

import com.farzadz.springaspect.aspect.AppConfig;
import com.farzadz.springaspect.aspect.PeopleService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.farzadz.springaspect.aspect")
@SpringBootApplication
public class SpringAspectApplication {

  public static void main(String[] args) throws InterruptedException {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PeopleService peopleService = context.getBean("peopleService", PeopleService.class);
        // getters called inside the class are not called:
        // https://stackoverflow.com/questions/13564627/spring-aop-not-working-for-method-call-inside-another-method
        System.out.println(peopleService.getPerson().getFullName());

    System.out.println(peopleService.getPerson().sayHello("Jack", "Joe"));
  }

}
