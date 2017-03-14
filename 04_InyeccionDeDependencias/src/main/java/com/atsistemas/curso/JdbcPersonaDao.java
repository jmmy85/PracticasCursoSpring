package com.atsistemas.curso;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class JdbcPersonaDao implements PersonaDao {

	public void insertar(Persona persona) {
		System.out.println("Persona insertada por JDBC.");
		// TODO Auto-generated method stub
		
	}

	public void borrar(Persona persona) {
		// TODO Auto-generated method stub
		
	}

	public void modificar(Persona persona) {
		// TODO Auto-generated method stub
		
	}

	public List<Persona> consultar(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	public Persona consultar(Long pk) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
