package com.atsistemas.curso.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.negocio.DummyNegocio;
import com.atsistemas.curso.persistencia.ClienteDao;

public class ClienteServicioImpl implements ClienteServicio {

	private ClienteDao dao;
	private DummyNegocio negocio;
	
	@Autowired
	public ClienteServicioImpl(ClienteDao dao, DummyNegocio negocio) {
		super();
		this.dao = dao;
		this.negocio = negocio;
	}
	@Override
	public List<Cliente> busquedaCliente() {
		return dao.findAll();
	}

	@Override
	public void altaCliente(Cliente cliente) {
		dao.save(cliente);

	}

	@Override
	public void actualizarCliente(Cliente cliente) {
		dao.save(cliente);
	}

	@Override
	public Cliente buscarClientePorId(long parseLong) {
		return dao.getOne(parseLong);
	}

	@Override
	public void borrarClientePorId(long parseLong) {
		dao.delete(parseLong);

	}

}
