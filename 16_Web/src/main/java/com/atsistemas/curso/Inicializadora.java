package com.atsistemas.curso;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class Inicializadora implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		// Se crea el contexto
		AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
		
		// Como no tiene un ocontructor al que pasarle el paquete del fichero de configuración,
		// hay que hacer un set
		springContext.setConfigLocation("com.atsistemas.curso");
		servletContext.addListener(new ContextLoaderListener(springContext));
	}
}
