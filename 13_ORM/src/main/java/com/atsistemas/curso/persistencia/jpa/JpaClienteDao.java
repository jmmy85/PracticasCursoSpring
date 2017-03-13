package com.atsistemas.curso.persistencia.jpa;

import java.util.Collection;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.persistencia.dao.ClienteDao;

@Named
@Transactional
public class JpaClienteDao implements ClienteDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void insertar(Cliente entidad) {
		entityManager.persist(entidad);
	}

	public Cliente consultarPorId(float id) {
		return entityManager.find(Cliente.class,id);
	}

	public Collection<Cliente> consultarTodos() {
		// No es SQL sino JPQL
		return entityManager.createQuery("from Cliente",Cliente.class).getResultList();
		// Query SQL:
		//return session.createNativeQuery("select * from Cliente",Cliente.class).getResultList();
	}

	public List<Cliente> consultarPorNombre(String nombre) {
		// No es SQL sino JPQL
		TypedQuery<Cliente> query = entityManager.createQuery("from Cliente c where c.nombre = :nom",Cliente.class);
		query.setParameter("nom", nombre);
		return query.getResultList();
	}

}
