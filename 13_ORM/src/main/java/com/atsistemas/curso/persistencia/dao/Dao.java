package com.atsistemas.curso.persistencia.dao;

import java.util.Collection;

public interface Dao<E> {

	void insertar(E entidad);
	E consultarPorId(float id);
	Collection<E> consultarTodos();
}
