package com.atsistemas.curso.servicios;

import com.atsistemas.curso.entidades.Persona;

@WebService(serviceName="servicio")
public class Servicio {
	
	@WebMethod
	public Persona metodo(Persona persona){
		return new Persona(1,"victor",24,1.5, "Hombre");
	  }
	}
}
