package com.ravi.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import com.ravi.BootProj41SpbDataJpaProj14InteractingWithMultipleDBsApplication;

import jakarta.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.ravi.customer_repository",
										entityManagerFactoryRef = "mysqlEMF",
										transactionManagerRef = "mysqlTxMgmr")
public class MySQLDBConfig {

	@Bean(name = "mysqlDs")
	@ConfigurationProperties(prefix = "mysql.ds")
	public DataSource createMYSQLDS() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "mysqlEMF")
	public LocalContainerEntityManagerFactoryBean createEMFB(EntityManagerFactoryBuilder builder) {
		
		//set jpa properties
		Map<String ,Object> map=new HashMap<>();
		map.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		map.put("hibernate.hbm2ddl.auto", "update");
		
		
		//create object LocalContainerEntityManagerFactoryBean class object using builder
		return builder.dataSource(createMYSQLDS())
					  .packages("com.ravi.customer_entity")//entity class package name
					  .properties(map)
					  .build();	
	}
	
	@Bean(name = "mysqlTxMgmr")
	public PlatformTransactionManager createTxMgmr(@Qualifier("mysqlEMF")EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}
	
}
