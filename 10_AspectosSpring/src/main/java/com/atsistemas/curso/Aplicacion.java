package com.atsistemas.curso;

import javax.security.auth.login.Configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

public class Aplicacion {

	public static void main(String[] args) {

		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuracion.class);

		//System.setProperty("spring.profiles.active", "ConAspectos");
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "ConAspectos");
		
		
		Servicio proxyServicio = context.getBean(Servicio.class);
		System.out.println(proxyServicio.metodoInterceptado("12"));
		
		//((Extension)proxyServicio).metodoNuevo();

	}

}
