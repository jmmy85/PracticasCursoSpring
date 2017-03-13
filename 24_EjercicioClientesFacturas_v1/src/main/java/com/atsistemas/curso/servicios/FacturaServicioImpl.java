package com.atsistemas.curso.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.atsistemas.curso.entidades.Factura;
import com.atsistemas.curso.negocio.DummyNegocio;
import com.atsistemas.curso.persistencia.FacturaDao;

public class FacturaServicioImpl implements FacturaServicio {

	private FacturaDao dao;
	private DummyNegocio negocio;
	
	@Autowired
	public FacturaServicioImpl(FacturaDao dao, DummyNegocio negocio) {
		super();
		this.dao = dao;
		this.negocio = negocio;
	}
	@Override
	public List<Factura> busquedaFactura() {
		return dao.findAll();
	}

	@Override
	public void altaFactura(Factura factura) {
		dao.save(factura);

	}

	@Override
	public void actualizarFactura(Factura factura) {
		dao.save(factura);
	}

	@Override
	public Factura buscarFacturaPorId(long parseLong) {
		return dao.getOne(parseLong);
	}

	@Override
	public void borrarFacturaPorId(long parseLong) {
		dao.delete(parseLong);

	}

}
