package com.atsistemas.curso.servicios;

import java.util.List;

import com.atsistemas.curso.entidades.Factura;

public interface FacturaServicio {
	List<Factura> busquedaFactura();
	void altaFactura(Factura factura);
	void actualizarFactura(Factura factura);
	Factura buscarFacturaPorId(long parseLong);
	void borrarFacturaPorId(long parseLong);
}
