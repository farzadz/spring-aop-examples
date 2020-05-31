package com.farzadz.springaspect.aspect;

import com.farzadz.springaspect.aspect.AspectAnnotations.ExecuteAroundAspect;
import com.farzadz.springaspect.aspect.AspectAnnotations.SayGoodbyeAspectAnnotation;

public class Person {

  private String firstName;

  private String lastName;

  private int age;

  public Person(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFullName() {
    return this.getFirstName() + " " + this.getLastName();
  }

  @ExecuteAroundAspect
  public int getAge() {
    return age;
  }


  public String sayHello(String name){
    String greeting = "Person sayHello: Hey " + name;
    return greeting;
  }

  public String sayGoodbye(String firstName, @SayGoodbyeAspectAnnotation String name, String secondName){
    String goodbye = "Person say goodbye: bye bye " + name;
    return goodbye;
  }
}
