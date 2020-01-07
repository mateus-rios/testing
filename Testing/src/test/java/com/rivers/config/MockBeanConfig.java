package com.rivers.config;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

import com.rivers.testing.service.CalcService;
import com.rivers.testing.service.GenericService;

@Configuration
public class MockBeanConfig {
	
	@MockBean
	private CalcService calcService;
	
	@MockBean
	private GenericService genericService;

}
