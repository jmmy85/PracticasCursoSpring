package com.atsistemas.curso.servicios;

import java.util.List;

import com.atsistemas.curso.entidades.Persona;

public interface Servicio {
	
	void altaPersona(Persona p);
	List<Persona> busquedaAfines(Persona p);
	Persona busquedaIdeal(Persona p);
	Persona buscarPersonaPorId(long id);
}
