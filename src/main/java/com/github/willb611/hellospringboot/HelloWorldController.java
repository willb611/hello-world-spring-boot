package com.github.willb611.hellospringboot;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@Slf4j
public class HelloWorldController {

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String hello() {
    log.info("hello");
    return "Hello world!";
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public void rootPath(HttpServletResponse response) throws IOException {
    response.sendRedirect("/hello");
  }
}
