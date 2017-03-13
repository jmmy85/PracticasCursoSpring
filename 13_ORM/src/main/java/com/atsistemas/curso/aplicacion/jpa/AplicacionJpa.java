package com.atsistemas.curso.aplicacion.jpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsistemas.curso.aplicacion.jpa.Configuracion;
import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.entidades.Factura;
import com.atsistemas.curso.negocio.DummyNegocio;

public class AplicacionJpa {
	AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);

	//ClienteDao clienteDdao = contexto.getBean(ClienteDao.class);
	//FacturaDao facturaDao = contexto.getBean(FacturaDao.class);
	
	DummyNegocio negocio = contexto.getBean(DummyNegocio.class);
	
	
	Cliente cliente = new Cliente("Victor");
	Factura factura = new Factura(33000f, cliente);
	//dao.insertar(factura);
	
	negocio.altaClienteYFactura(cliente, factura);

}
