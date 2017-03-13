package com.atsistemas.curso.persistencia.hibernate;

import java.util.Collection;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atsistemas.curso.entidades.Persona;
import com.atsistemas.curso.persistencia.PersonaDao;

@Component
@Transactional
public class HibernatePersonaDao implements PersonaDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public void insertar(Persona persona) {
		sessionFactory.getCurrentSession().persist(persona);
		sessionFactory.getCurrentSession().flush();
	}

	public List<Persona> consultarPorNombre(String nombre) {
		Query query = sessionFactory.getCurrentSession().createQuery(" from Persona p where p.nombre = :nom");
		query.setParameter("nom", nombre);
		return (List<Persona>)query.getResultList();
	}

	public Collection<Persona> consultarTodos() {
		return sessionFactory.getCurrentSession().createQuery("from Persona",Persona.class).getResultList();
	}

	public Persona consultarPorId(long id) {
		return sessionFactory.getCurrentSession().find(Persona.class,id);
	}

}
