package com.atsistemas.curso.servicio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.atsistemas.curso.persistencia.FacturaDao;
import com.atsistemas.curso.servicios.BasicoServicio;

public class PruebaBasicoServicio {

	@Test
	public void testAltaFactura() {
		
		FacturaDao mockFacturaDao = mock(FacturaDao.class);
		
		When(mockFacturaDao.save(new Factura()).
		
		BasicoServicio sut = new BasicoServicio(facturaDao,null);
		
		// La prueba
		sut.altaFactura(factura);
		
		
		fail("Not yet implemented");
	}

}
