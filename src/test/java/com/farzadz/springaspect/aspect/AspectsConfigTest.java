package com.farzadz.springaspect.aspect;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class AspectsConfigTest {

  private Logger logger;

  public void setUp() {
    logger = LoggerFactory.getLogger(this.getClass());
  }

  @Test
  void onPublicStringGetName() {
    Person person = new Person("John", "Willson",  32);
    person.getFullName();
  }
}