package com.atsistemas.curso;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class Inicializadora implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		// Se crea el contexto de Spring
		AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
		
		// Como no tiene un ocontructor al que pasarle el paquete del fichero de configuración,
		// hay que hacer un set
		springContext.setConfigLocation("com.atsistemas.curso.jpa");
		
		// Encapsulamos el contexto de spring dentro del contexto de Servlet a través de un listener.
		// Recordamos que en el contexto de servlet sólo se pueden crear Listeners, Servlets y Filters
		servletContext.addListener(new ContextLoaderListener(springContext));
	}
}
