package com.atsistemas.curso.servicios;

import java.util.List;

import com.atsistemas.curso.entidades.Persona;

public interface Servicio {
	
	public void altaPersona(Persona p);
	public List<Persona> busquedaAfines(Persona p);
	public Persona busquedaIdeal(Persona p);

}
