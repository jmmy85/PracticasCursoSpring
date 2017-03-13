package com.atsistemas.curso.persistencia;

import java.util.Collection;
import java.util.Map;

import com.atsistemas.curso.entidades.Persona;

public interface PersonaDao {

	public void insertar(Persona persona);
	public Persona consultarPorNombre(String nombre);
	public Collection<Persona> consultarTodos();
}
