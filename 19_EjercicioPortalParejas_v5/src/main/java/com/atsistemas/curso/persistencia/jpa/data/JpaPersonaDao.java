package com.atsistemas.curso.persistencia.jpa.data;

import java.util.Collection;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.atsistemas.curso.entidades.Persona;
import com.atsistemas.curso.persistencia.PersonaDao;

@Named
@Transactional
public class JpaPersonaDao implements PersonaDao extends JpaRepository<Persona, Long> {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void insertar(Persona persona) {
		entityManager.persist(persona);
		entityManager.flush();
	}

	public List<Persona> consultarPorNombre(String nombre) {
		TypedQuery<Persona> query = entityManager.createQuery(" from Persona p where p.nombre = :nom",Persona.class);
		query.setParameter("nom", nombre);
		return (List<Persona>)query.getResultList();
	}

	public Collection<Persona> consultarTodos() {
		return entityManager.createQuery("from Persona",Persona.class).getResultList();
	}

	public Persona consultarPorId(long id) {
		return entityManager.find(Persona.class,id);
	}

}
