package com.atsistemas.curso.persistencia.hibernate;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.entidades.Factura;
import com.atsistemas.curso.persistencia.dao.ClienteDao;

@Component
@Transactional
public class HibernateClienteDao implements ClienteDao {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public HibernateClienteDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public void insertar(Cliente entidad) {
		sessionFactory.getCurrentSession().persist(entidad);
		sessionFactory.getCurrentSession().flush();
	}

	public Cliente consultarPorId(float id) {
		return sessionFactory.getCurrentSession().find(Cliente.class,id);
	}

	public Collection<Cliente> consultarTodos() {
		// No es SQL sino JPQL
		return sessionFactory.getCurrentSession().createQuery("from Cliente",Cliente.class).getResultList();
		// Query SQL:
		//return session.createNativeQuery("select * from Cliente",Cliente.class).getResultList();
	}

	public List<Cliente> consultarPorNombre(String nombre) {
		// No es SQL sino JPQL
		Query<Cliente> query = sessionFactory.getCurrentSession().createQuery("from Cliente c where c.nombre = :nom",Cliente.class);
		query.setParameter("nom", nombre);
		return query.getResultList();
	}

}
