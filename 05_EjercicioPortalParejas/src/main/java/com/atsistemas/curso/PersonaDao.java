package com.atsistemas.curso;

import java.util.Collection;
import java.util.Map;

public interface PersonaDao {

	public void insertar(Persona persona);
	public Persona consultarPorNombre(String nombre);
	public Collection<Persona> consultarTodos();
}
