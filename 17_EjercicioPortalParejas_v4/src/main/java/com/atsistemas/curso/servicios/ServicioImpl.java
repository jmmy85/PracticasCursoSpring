package com.atsistemas.curso.servicios;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atsistemas.curso.entidades.Persona;
import com.atsistemas.curso.negocio.Negocio;
import com.atsistemas.curso.persistencia.jpa.data.PersonaDao;

@Service
public class ServicioImpl implements Servicio {
	
	@Autowired
	private PersonaDao dao;
	private Negocio negocio;
	
	ServicioImpl(PersonaDao dao, Negocio negocio) {
		super();
		this.dao=dao;
		this.negocio = negocio;
	}
	public List<Persona> busquedaAfines(Persona target){
		Collection<Persona> candidatas = dao.findAll();
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
		Collection<Persona> candidatas = dao.findAll();
		Persona ideal=null;
		for(Persona candidata : candidatas){
			if(negocio.esIdeal(target, candidata)){
				ideal=candidata;				
			}
		}
		return ideal;
	}
	@Override
	public void altaPersona(Persona p) {
		dao.findOne(p.getId());
		// TODO Auto-generated method stub
		
	}

}
