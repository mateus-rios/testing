package com.rivers.testing;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.rivers.config.MockBeanConfig;
import com.rivers.testing.service.CalcService;

@RunWith(SpringRunner.class)
@WebMvcTest
@Import(MockBeanConfig.class)
public class CalcControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private CalcService calcService;
	
	@Test
	public void sumShouldBeThree() throws Exception {
		when(calcService.sum()).thenReturn(8);
		this.mockMvc.perform(get("/sum")).andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$.data", is(6)));
	}
	
}
