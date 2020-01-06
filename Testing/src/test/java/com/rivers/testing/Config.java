package com.rivers.testing;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

import com.rivers.testing.service.CalcService;

@Configuration
public class Config {
	
	@MockBean
	private CalcService calcService;

}
