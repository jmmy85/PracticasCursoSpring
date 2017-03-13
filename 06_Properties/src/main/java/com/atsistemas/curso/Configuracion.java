package com.atsistemas.curso;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;

@Configuration
public class Configuracion {
	
	// Tipología que permite al contexto spring leer con las sintaxis ${key}
	@Bean
	public PropertyPlaceholderConfigurer properties(){
		PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
		propertyPlaceholderConfigurer.setLocation(new ClassPathResource("Configuracion.properties"));
		
		return propertyPlaceholderConfigurer;
	}
	
	@Bean
	public DataSource datasource(
			@Value("${db.user}") String user,
			@Value("${db.password}") String password,
			@Value("${db.url}") String url,
			@Value("${bd.driver.class.name}") String driverClassName){
		
		System.out.format("1$%s 2$%s 3$%s 4$%s", user, password, url, driverClassName);
		return null;
	}

}
