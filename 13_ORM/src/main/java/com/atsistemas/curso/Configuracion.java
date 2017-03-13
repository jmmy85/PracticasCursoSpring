package com.atsistemas.curso;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.entidades.Factura;

@Configuration
@ComponentScans({
	@ComponentScan("com.atsistemas.curso.persistencia.hiberante"),
	@ComponentScan("com.atsistemas.curso.negocio")
})
@EnableTransactionManagement
public class Configuracion {
	
	@Bean
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
		
	}
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource){ // Se inyecta por parámetro
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		
		sessionFactoryBean.setDataSource(dataSource);
		//sessionFactoryBean.setAnnotatedClasses(Cliente.class,Factura.class);
		sessionFactoryBean.setPackagesToScan("com.atsistemas.curso.entidades");
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyTenSevenDialect");
		properties.setProperty("hibernate.show_sql","true");
		properties.setProperty("hibernate.format_sql","true");
		//properties.setProperty("hibernate.current_session_context_class","thread");
		properties.setProperty("hibernate.hbm2ddl.auto","create");
		//properties.setProperty("hibernate.hbm2ddl.auto","validate");
		sessionFactoryBean.setHibernateProperties(properties);
		
		return sessionFactoryBean;
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
