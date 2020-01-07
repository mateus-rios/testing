package com.rivers.testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.rivers.config.MockBeanConfig;
import com.rivers.testing.controller.HelloController;

@RunWith(SpringRunner.class)
@WebMvcTest
@Import(MockBeanConfig.class)
public class HelloControllerTest {
   
	@Autowired
	private HelloController helloController;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(helloController).isNotNull();
	}
	
	@Test
	public void getGreetingFromController() throws Exception {
		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Hello")));
	}

}