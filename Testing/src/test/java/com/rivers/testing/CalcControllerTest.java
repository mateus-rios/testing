package com.rivers.testing;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.rivers.testing.service.CalcService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CalcControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CalcService calcService;
	
	@Test
	public void sumShouldBeThree() throws Exception {
		when(calcService.sum()).thenReturn(5);
		this.mockMvc.perform(get("/sum")).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("5")));
	}
	
}
