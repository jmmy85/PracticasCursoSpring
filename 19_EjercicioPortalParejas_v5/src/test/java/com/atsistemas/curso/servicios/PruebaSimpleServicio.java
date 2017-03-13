package com.atsistemas.curso.servicios;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.atsistemas.curso.entidades.Persona;
import com.atsistemas.curso.negocio.Negocio;
import com.atsistemas.curso.persistencia.jpa.data.PersonaDao;
import com.atsistemas.curso.servicios.SimpleServicio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=)
public class PruebaSimpleServicio {

	Persona personaIn = new Persona();
	Persona personaThrow = new Persona(1,"Juan",12,1.8,"Hombre");
	
	@Autowired
	SimpleServicio sut;
	
	@Autowired
	PersonaDao personaDao;
	
	@Autowired
	Negocio negocio;

	@Test
	public void testAltaPersonaCorrecta() {
		// Entorno de ejecución de la prueba controlado
		//PersonaDao personaDao = mock(PersonaDao.class);
		//Negocio negocio = mock(Negocio.class);
		when(personaDao.save(personaIn)).thenReturn(personaIn);
		
		try {
			//Ejecutar la prueba
			sut.altaPersona(personaIn);
			
			// La prueba ha ido correcta
			verify(personaDao).save(personaIn);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test(expected=RuntimeException.class)
	public void testAltaPersonaIncorrecta() {
		
		when(personaDao.save(personaThrow)).thenThrow(new RuntimeException());
	
		//Ejecutar la prueba
		sut.altaPersona(personaThrow);
		
		fail("Se ha ejecutado de forma correcta el procesos de Alta cuando no debería.");
	}

}