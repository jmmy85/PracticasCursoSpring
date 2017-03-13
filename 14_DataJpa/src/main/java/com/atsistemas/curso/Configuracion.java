package com.atsistemas.curso;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.atsistemas.curso.negocio")
@EnableTransactionManagement
@EnableJpaRepositories("com.atsistemas.curso.persistencia")
public class Configuracion {
	
	@Bean
	public JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setPackagesToScan("com.atsistemas.curso.entidades");
		
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyTenSevenDialect");
		properties.setProperty("hibernate.show_sql","true");
		properties.setProperty("hibernate.format_sql","true");
		properties.setProperty("hibernate.hbm2ddl.auto","validate");
		
		entityManagerFactoryBean.setJpaProperties(properties);
		
		return entityManagerFactoryBean;
	}
	
	@Bean
	public DataSource datasource(
			@Value("${db.user}") String user,
			@Value("${db.password}") String password,
			@Value("${db.url}") String url,
			@Value("${db.driver.class.name}") String driverClassName){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(password);
		
		return ds;
	}
	
	// Tipología que permite al contexto spring leer con las sintaxis ${key}
	@Bean
	public PropertyPlaceholderConfigurer properties() {
		PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
		propertyPlaceholderConfigurer.setLocation(new ClassPathResource("Configuracion.properties"));
		
		return propertyPlaceholderConfigurer;
	}
}
