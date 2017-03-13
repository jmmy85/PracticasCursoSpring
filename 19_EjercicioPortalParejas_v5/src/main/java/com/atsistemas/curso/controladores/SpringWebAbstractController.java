package com.atsistemas.curso.controladores;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.atsistemas.curso.servicios.Servicio;
import com.atsistemas.curso.servicios.SimpleServicio;

@Controller
public class SpringWebAbstractController {
	
	private Servicio servicio;

	@Autowired
	public SpringWebAbstractController(Servicio servicio) {
		super();
		this.servicio = servicio;
	}
	
	public SpringWebAbstractController() {
		super();
	}
	
	protected Servicio getServicio() {
		return servicio;
	}
}
