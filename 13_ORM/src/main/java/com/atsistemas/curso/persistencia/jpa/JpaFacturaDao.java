package com.atsistemas.curso.persistencia.jpa;

import java.util.Collection;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.query.Query;

import com.atsistemas.curso.entidades.Factura;
import com.atsistemas.curso.persistencia.dao.FacturaDao;

@Named
@Transactional
public class JpaFacturaDao implements FacturaDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void insertar(Factura entidad) {
		entityManager.persist(entidad);
	}

	public Factura consultarPorId(float id) {
		return entityManager.find(Factura.class,id);
	}

	public Collection<Factura> consultarTodos() {
		// No es SQL sino JPQL
		return entityManager.createQuery("from Factura",Factura.class).getResultList();
		// Query SQL:
		//return session.createNativeQuery("select * from Factura",Factura.class).getResultList();
	}

	public List<Factura> consultarPorCantidad(float cantidad) {
		// No es SQL sino JPQL
		TypedQuery<Factura> query = entityManager.createQuery("from Factura f where f.cantidad = :cant",Factura.class);
		query.setParameter("cant", cantidad);
		return query.getResultList();
	}

}
