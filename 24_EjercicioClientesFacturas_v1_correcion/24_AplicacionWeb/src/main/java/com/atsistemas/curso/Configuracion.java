package com.atsistemas.curso;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan("com.atsistemas.curso.servicios")
public class Configuracion {
	
	// Tipología que permite al contexto spring leer con las sintaxis ${key}
	@Bean
	public PropertyPlaceholderConfigurer properties() {
		PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
		propertyPlaceholderConfigurer.setLocation(new ClassPathResource("Configuracion.properties"));
		
		return propertyPlaceholderConfigurer;
	}

}
