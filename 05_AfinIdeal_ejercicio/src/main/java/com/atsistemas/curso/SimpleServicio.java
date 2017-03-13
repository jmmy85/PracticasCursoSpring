package com.atsistemas.curso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleServicio implements Servicio{
	
	@Autowired
	private PersonaDao dao;
	private Negocio negocio;
	
	SimpleServicio(PersonaDao dao, Negocio negocio) {
		super();
		this.dao=dao;
		this.negocio = negocio;
	}

	public void altaPersona(Persona persona) {
		dao.insertar(persona);
	}
	public List<Persona> busquedaAfines(Persona target){
		Collection<Persona> candidatas = dao.consultarTodos();
		List<Persona> afines = new LinkedList<Persona>();
		int i = 0;
		for(Persona candidata : candidatas){
			if(negocio.esAfin(target,candidata)){
				afines.add(candidata);
			}
		}
		return afines;
	}
	
	public Persona busquedaIdeal(Persona target){
		Collection<Persona> candidatas = dao.consultarTodos();
		Persona ideal=null;
		for(Persona candidata : candidatas){
			if(negocio.esIdeal(target, candidata)){
				ideal=candidata;				
			}
		}
		return ideal;
	}

}