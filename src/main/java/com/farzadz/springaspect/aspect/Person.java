package com.farzadz.springaspect.aspect;

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

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFullName() {
    return this.getFirstName() + " " + this.getLastName();
  }


  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String sayHello(String name, String anotherName){
    String greeting = "Person sayHello: Hey " + name;
    System.out.println();
    return greeting;
  }
}
