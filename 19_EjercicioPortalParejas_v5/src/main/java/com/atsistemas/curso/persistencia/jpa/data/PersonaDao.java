package com.atsistemas.curso.persistencia.jpa.data;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atsistemas.curso.entidades.Persona;

public interface PersonaDao extends JpaRepository<Persona, Long>{

	public List<Persona> consultarPorNombre(String nombre);
	public Collection<Persona> consultarTodos();

}
