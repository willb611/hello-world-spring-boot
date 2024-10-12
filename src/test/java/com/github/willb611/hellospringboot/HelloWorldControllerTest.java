package com.github.willb611.hellospringboot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldControllerTest {

  @Autowired
	private MockMvc mockMvc;

	@Test
	public void rootEndpointShouldRedirectToHello() throws Exception {
	  mockMvc.perform(get("/"))
        .andExpect(status().is3xxRedirection())
        .andExpect(header().string("Location", "/hello"));
	}

  @Test
  public void helloEndPointShouldSayHello() throws Exception {
    var result = mockMvc.perform(get("/hello"))
        .andExpect(status().is2xxSuccessful())
        .andReturn();
    var content = result.getResponse().getContentAsString();
    assertThat(content).contains("Hello");
  }
}
