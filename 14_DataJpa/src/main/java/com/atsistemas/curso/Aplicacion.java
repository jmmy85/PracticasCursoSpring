package com.atsistemas.curso;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.entidades.Factura;
import com.atsistemas.curso.negocio.DummyNegocio;
import com.atsistemas.curso.persistencia.ClienteDao;
import com.atsistemas.curso.persistencia.FacturaDao;

public class Aplicacion {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);

		//ClienteDao clienteDdao = contexto.getBean(ClienteDao.class);
		//FacturaDao facturaDao = contexto.getBean(FacturaDao.class);
		
		DummyNegocio negocio = contexto.getBean(DummyNegocio.class);
		
		
		Cliente cliente = new Cliente("Victor");
		Factura factura = new Factura(33000f, cliente);
		
		negocio.altaClienteYFactura(cliente, factura);
		
		contexto.close();

	}

}
