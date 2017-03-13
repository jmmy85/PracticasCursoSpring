package com.atsistemas.curso.persistencia;

import java.util.Collection;
import java.util.List;

import com.atsistemas.curso.entidades.Persona;

public interface PersonaDao extends Dao<Persona> {

	public void insertar(Persona persona);
	public List<Persona> consultarPorNombre(String nombre);
	public Collection<Persona> consultarTodos();
}
