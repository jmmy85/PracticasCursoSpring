package com.atsistemas.curso.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.atsistemas.curso.dto.FacturaDto;
import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.entidades.Factura;
import com.atsistemas.curso.persistencia.ClienteDao;
import com.atsistemas.curso.persistencia.FacturaDao;

public class BasicoServicio implements Servicio {
	
	private FacturaDao facturaDao;
	private ClienteDao clienteDao;
	
	@Autowired
	public BasicoServicio(FacturaDtoDao facturaDao, ClienteDao clienteDao) {
		this.facturaDao = facturaDao;
		this.clienteDao = clienteDao;
	}

	public void altaFactura(FacturaDto factura) {
		facturaDao.save(factura);
		s
	}

	public void altaCliente(ClienteDto cliente) {
		clienteDao.save(cliente);
		
	}

	public void bajaFactura(long id) {
		facturaDao.delete(id);
	}

	public void bajaCliente(long id) {
		clienteDao.delete(id);
	}

	public void actualizarFactura(FacturaDto factura) {
		facturaDao.save(factura);
	}

	public void actualizarCliente(ClienteDto cliente) {
		clienteDao.save(cliente);
	}

	public Factura obtenerFactura(long id) {
		return facturaDao.findOne(id);
	}

	public Cliente obtenerCliente(long id) {
		return clienteDao.findOne(id);
	}

	public List<FacturaDto> obtenerFacturas() {
		return facturaDao.findAll();
	}

	public List<Cliente> obtenerClientes() {
		return clienteDao.findAll();
	}

	public List<FacturaDto> obtenerFacturasDeCliente(long idCliente) {
		return clienteDao.findOne(idCliente).getFacturas();
	}

	public Cliente obtenerClienteDeFactura(long idFactura) {
		return facturaDao.findOne(idFactura).getCliente();
	}

}
