package com.atsistemas.curso;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.atsistemas.curso.controladores")
@EnableWebMvc
public class ConfiguracionWeb {
	
	@Bean
	public DataSource dataSource(@Value("${db.jndi}" String jndiName) {
	    JndiDataSourceLookup lookup = new JndiDataSourceLookup();
	    lookup.setResourceRef(true);
	    return lookup.getDataSource(jndiName);
	}
}
