package com.atsistemas.curso;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aplicacion {

	public static void main(String[] args) {
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuracion.class);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		Servicio servicio = context.getBean("servicio",Servicio.class);
		
		servicio.altaUsuario("fenix", "email@email.com", "clave");;
	}
}