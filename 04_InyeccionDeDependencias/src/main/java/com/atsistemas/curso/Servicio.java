package com.atsistemas.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Definido así no es necesario definirlos en el fichero de configuración
public class Servicio {
	
	@Autowired
	private PersonaDao dao;
	private PersonaDao otro;
	
	public Servicio() {
		
	}

	// Inyección por constructor
	// En cuanto creamos un constructor, el compilador ya no crea el constructor "por defecto"
	public Servicio(PersonaDao dao, PersonaDao otro) {
		super();
		this.dao = dao;
	}

	// Inyección por Setter
	public void setDao(PersonaDao dao) {
		this.dao = dao;
	}

	public void altaUsuario(String avatar, String mail, String password) {
		
		// Me acopla con la implementación en memoria
		// MemoriaPersonaDao dao = new MemoriaPersonaDao();
		// Inertar en la BD la persona
		dao.insertar(new Persona(avatar, mail, password));
		// Mandar correo electrónico de confirmación/activación
	}
}
