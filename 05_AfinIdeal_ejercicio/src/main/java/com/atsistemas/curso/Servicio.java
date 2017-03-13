package com.atsistemas.curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public interface Servicio {
	
	public void altaPersona(Persona p);
	public List<Persona> busquedaAfines(Persona p);
	public Persona busquedaIdeal(Persona p);

}