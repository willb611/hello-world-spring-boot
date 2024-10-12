package com.github.willb611.hellospringboot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SmokeTest {
  @Autowired
  private HelloWorldController helloWorldController;

  @Test
  public void autoWiringShouldNotFailInTest() {
    assertThat(helloWorldController).isNotNull();
  }
}
