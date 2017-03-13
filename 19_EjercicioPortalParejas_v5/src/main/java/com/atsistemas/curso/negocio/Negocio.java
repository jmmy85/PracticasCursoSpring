package com.atsistemas.curso.negocio;

import com.atsistemas.curso.entidades.Persona;

public interface Negocio {
	public boolean esAfin(Persona target, Persona candidata);
	public boolean esIdeal(Persona persona1, Persona candidata);

}
