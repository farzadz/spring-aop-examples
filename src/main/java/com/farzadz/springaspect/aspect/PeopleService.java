package com.farzadz.springaspect.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {

  @Autowired
  private Person person;

  public Person getPerson() {
    return person;
  }

}
