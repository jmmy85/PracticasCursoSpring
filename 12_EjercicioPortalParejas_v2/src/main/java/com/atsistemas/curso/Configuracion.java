package com.atsistemas.curso;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.atsistemas.curso.persistencia.jdbc.springtemplate.JdbcTemplatePersonaDao;

@Configuration
@ComponentScans({@ComponentScan("com.atsistemas.curso"),
		@ComponentScan("com.atsistemas.curso.entidades"),
		@ComponentScan("com.atsistemas.curso.negocio"),
		@ComponentScan("com.atsistemas.curso.persistencia"),
		@ComponentScan("com.atsistemas.curso.persistencia.jdbc.springtemplate"),
		@ComponentScan("com.atsistemas.curso.servicios")})
public class Configuracion {

	@Bean
	public JdbcTemplatePersonaDao personaDao(JdbcTemplate jdbcTemplate) {
		JdbcTemplatePersonaDao jdbcTemplatePersonaDao = new JdbcTemplatePersonaDao(jdbcTemplate);

		return jdbcTemplatePersonaDao;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplatePersonaDao(DataSource dataSource){
		return new JdbcTemplate(dataSource);
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
