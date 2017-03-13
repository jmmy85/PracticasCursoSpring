package com.atsistemas.curso;

import com.atsistemas.curso.entidades.Persona;
import com.atsistemas.curso.servicios.IServicio;

public class Aplicacion {

	public static void main(String[] args) {
	    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	    IServicio servicio = context.getBean(IServicio.class);
	    Persona personaObtenida = servicio.metodo(new Persona());
	}
}
