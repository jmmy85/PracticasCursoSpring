package com.atsistemas.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service // Definido as� no es necesario definirlos en el fichero de configuraci�n
public class Servicio {
	
	private PersonaDao dao;
	private PersonaDao otro;
	
	public Servicio() {
	}

	// Inyecci�n por constructor
	// En cuanto creamos un constructor, el compilador ya no crea el constructor "por defecto"
	@Autowired
	public Servicio(@Qualifier("memoriaPersonaDao") PersonaDao dao, 
			@Qualifier("memoriaPersonaDao") PersonaDao otro) {
		super();
		this.dao = dao;
	}

	// Inyecci�n por Setter	
	public void setDao(@Qualifier("memoriaPersonaDao") PersonaDao dao) {
		this.dao = dao;
	}

	// Inyecci�n por Setter
	@Autowired
	public void setOtro(@Qualifier("memoriaPersonaDao") PersonaDao otro) {
		this.otro = otro;
	}

	public void altaUsuario(String avatar, String mail, String password) {
		
		// Me acopla con la implementaci�n en memoria
		// MemoriaPersonaDao dao = new MemoriaPersonaDao();
		// Inertar en la BD la persona
		dao.insertar(new Persona(avatar, mail, password));
		// Mandar correo electr�nico de confirmaci�n/activaci�n
	}
}
