package com.rivers.testing;

import javax.sql.DataSource;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.test.context.junit4.SpringRunner;

import com.rivers.config.DataSourceConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DataSourceConfig.class})
@DataJpaTest
public class DataSourceTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Test
	public void contextLoads() {
		Assertions.assertThat(dataSource).isNotNull();
		Assertions.assertThat(namedParameterJdbcTemplate).isNotNull();
	}
	
	@Test
	public void selectFromTableTest() {
		SqlRowSet set = namedParameterJdbcTemplate.queryForRowSet("SELECT * FROM test", new MapSqlParameterSource());
		Assertions.assertThat(set.next()).isTrue();
	}

}
