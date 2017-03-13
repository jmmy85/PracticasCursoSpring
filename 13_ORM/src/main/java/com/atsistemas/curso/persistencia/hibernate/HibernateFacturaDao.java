package com.atsistemas.curso.persistencia.hibernate;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atsistemas.curso.entidades.Factura;
import com.atsistemas.curso.persistencia.dao.FacturaDao;

@Component
@Transactional
public class HibernateFacturaDao implements FacturaDao {

	private SessionFactory sessionFactory;

	@Autowired
	public HibernateFacturaDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public void insertar(Factura entidad) {
		sessionFactory.getCurrentSession().persist(entidad);
		sessionFactory.getCurrentSession().flush();

	}

	public Factura consultarPorId(float id) {
		return sessionFactory.getCurrentSession().find(Factura.class,id);
	}

	public Collection<Factura> consultarTodos() {
		// No es SQL sino JPQL
		return sessionFactory.getCurrentSession().createQuery("from Factura",Factura.class).getResultList();
	}

	public List<Factura> consultarPorCantidad(float cantidad) {
		// No es SQL sino JPQL
		Query<Factura> query = sessionFactory.getCurrentSession().createQuery("from Factura f where f.cantidad = :cant",Factura.class);
		query.setParameter("cant", cantidad);
		return query.getResultList();
	}

}
