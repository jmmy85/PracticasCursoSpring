package com.atsistemas.curso.servicios;

import java.util.List;

import com.atsistemas.curso.entidades.Cliente;

public interface ClienteServicio {

	List<Cliente> busquedaCliente();
	void altaCliente(Cliente cliente);
	void actualizarCliente(Cliente cliente);
	Cliente buscarClientePorId(long parseLong);
	void borrarClientePorId(long parseLong);
}
