package com.atsistemas.curso;

import java.util.List;

public interface PersonaDao {
	// Método que pesisitirá en la BD el usuario
	void insertar(Persona persona);
	void borrar(Persona persona);
	void modificar(Persona persona);
	List<Persona> consultar(Persona persona);
	Persona consultar(Long pk);
	//...
}
