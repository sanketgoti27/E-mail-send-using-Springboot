package com.Rest.Config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

	@Bean(name = "mySqlDataSource")
	public DataSource mySqlDataSource() {

		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

		dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
		dataSourceBuilder.url("jdbc:mysql://localhost:3306/springboot");
		dataSourceBuilder.username("root");
		dataSourceBuilder.password("Admin@123$");

		return dataSourceBuilder.build();
	}

}