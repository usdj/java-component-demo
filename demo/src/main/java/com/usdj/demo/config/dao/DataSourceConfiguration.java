package com.usdj.demo.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * @author gerrydeng
 * @date 2019-07-29 12:58
 * @Description:
 */
@Configuration
@MapperScan("com.usdj.demo.dao")
public class DataSourceConfiguration {

	@Value("${jdbc.driver}")
	private String jdbcDriver;
	@Value("${jdbc.url}")
	private String jdbcUrl;
	@Value("${jdbc.username}")
	private String jdbcUsername;
	@Value("${jdbc.password")
	private String jdbcPassword;


	@Bean(name = "dataSource")
	public ComboPooledDataSource createDataSource() throws PropertyVetoException {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setDriverClass(jdbcDriver);
		comboPooledDataSource.setJdbcUrl(jdbcUrl);
		comboPooledDataSource.setUser(jdbcUsername);
		comboPooledDataSource.setPassword(jdbcPassword);
		comboPooledDataSource.setAutoCommitOnClose(false);
		return comboPooledDataSource;
	}
}
