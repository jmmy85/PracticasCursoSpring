package com.atsistemas.curso;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Inicializador implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		// Crear contexto de spring
		AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
		springContext.setConfigLocation("com.atsistemas.curso");
		// Crear objeto dispatcher servlet y asociarlo al contexto de spring
		DispatcherServlet servlet = new DispatcherServlet(springContext);
		// Registrar dispatcher servlet en el contexto de Servlet
		Dynamic dynamic = servletContext.addServlet("dispatcher",servlet);
		// Definir las peticiones que atenderá el dispatcher servlet
		dynamic.addMapping("/api/*");
		
//		//Puede haber más de un dispatcher servlet, por ejemplo:
//		DispatcherServlet servletWeb = new DispatcherServlet(springContext);
//		// Registrar dispatcher servlet en el contexto de Servlet
//		Dynamic dynamicWeb = servletContext.addServlet("dispatcher",servletWeb);
//		// Definir las peticiones que atenderá el dispatcher servlet
//		dynamicWeb.addMapping("/web/*");
//
//		DispatcherServlet servletRest = new DispatcherServlet(springContext);
//		// Registrar dispatcher servlet en el contexto de Servlet
//		Dynamic dynamicRest = servletContext.addServlet("dispatcher",servletRest);
//		// Definir las peticiones que atenderá el dispatcher servlet
//		dynamicRest.addMapping("/rest/*");
	}

}
