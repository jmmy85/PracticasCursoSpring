package com.atsistemas.curso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaDaoImpl implements PersonaDao {
	
	private Map<Long,Persona> personas;

	@Autowired
	public PersonaDaoImpl(Map<Long, Persona> personas) {
		super();
		this.personas = personas;
	}
	public void insertar(Persona persona) {
		this.personas.put(persona.getId(), persona);
	}
	public Persona consultarPorNombre(String nombre){
		Persona[] listado =  (Persona[])this.personas.values().toArray();
		boolean encontrado = false;
		Persona p = null;
		int i=0;
		while (!encontrado && i<listado.length) {
			p = listado[i];
			if(p.getNombre().equals(nombre)) {
				encontrado=true;
			}
		}
		return p;
		
//		int resultado=(int)(Math.random()*26+65);//Sumamos al numero de letras (sin ñ) el valor en ASCII 
//		char letra = (char)resultado;
//		String nomAux =""+letra;
//		return new Persona(nomAux.toUpperCase()+"aeiou");
		
	}
	public Collection consultarTodos(){
		return personas.values();
		
	}
}
