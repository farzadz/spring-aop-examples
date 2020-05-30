package com.farzadz.springaspect.aspect;

import java.util.concurrent.Executor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAspectJAutoProxy
@EnableAsync
public class AppConfig {
  @Bean
  PeopleService peopleService(){
    return new PeopleService();
  }
  @Bean
  public Person person() {
    return new Person("John", "Willson", 32);
  }

  @Bean
  public AspectsConfig aspectsConfig(){
    return new AspectsConfig();
  }

  @Bean
  public Executor taskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(2);
    executor.setMaxPoolSize(2);
    executor.setQueueCapacity(500);
    executor.setThreadNamePrefix("GithubLookup-");
    executor.initialize();
    return executor;
  }


}
