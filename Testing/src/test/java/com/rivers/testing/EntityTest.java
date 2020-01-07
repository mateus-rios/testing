package com.rivers.testing;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.rivers.config.MockBeanConfig;
import com.rivers.testing.entity.Generic;
import com.rivers.testing.service.GenericService;

@RunWith(SpringRunner.class)
@Import(MockBeanConfig.class)
public class EntityTest {

	@Autowired
	private GenericService genericService;
	
	
	@Test
	public void findEntity_thenReturnNull() {
		Generic g = genericService.getGenericByName("");
		Assertions.assertThat(g).isNull();
	}
	
	@Test
	public void findEntity_thenReturnGeneric() {
		Mockito.when(genericService.getGenericByName("")).thenReturn(new Generic(1L, "Teste"));
		Generic g = genericService.getGenericByName("");
		
		Assertions.assertThat(g.getId()).isEqualTo(1L);
		Assertions.assertThat(g.getName()).isEqualTo("Teste");
	}
	
}
