package com.rivers.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.mysql.cj.jdbc.MysqlXADataSource;

@TestConfiguration
public class DataSourceConfig {
	
	@Bean
	@ConfigurationProperties(prefix = "test.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().type(MysqlXADataSource.class).build();
	}

}
