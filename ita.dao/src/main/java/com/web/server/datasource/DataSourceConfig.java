package com.web.server.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "com.web.server.dao", sqlSessionFactoryRef = "itaSqlSessionFactory")
public class DataSourceConfig {

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.url}")
	private String jdbcUrl;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Primary
	@Bean(name = "itaDataSource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().driverClassName(driverClassName).url(jdbcUrl).username(username)
				.password(password).build();
	}

	@Primary
	@Bean(name = "itaSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("itaDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		Resource[] resource = new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*.xml");
		bean.setMapperLocations(resource);
		return bean.getObject();
	}

	@Primary
	@Bean(name = "itaSqlSessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(@Qualifier("itaSqlSessionFactory") SqlSessionFactory factory) {
		return new SqlSessionTemplate(factory);
	}

}
