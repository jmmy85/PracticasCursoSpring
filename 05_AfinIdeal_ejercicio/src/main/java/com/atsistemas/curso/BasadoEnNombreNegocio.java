package com.atsistemas.curso;

import org.springframework.stereotype.Component;

@Component
public class BasadoEnNombreNegocio implements Negocio{

	public boolean esAfin(Persona target, Persona candidata) {
		boolean afines = false;
		String aux1 = String.valueOf(target.getNombre().charAt(0)).toUpperCase();
		String aux2 = String.valueOf(candidata.getNombre().charAt(0)).toUpperCase();
		if(aux1.equals(aux2)) {
			afines=true;
		}
		System.out.println(target.getNombre()+" y " + candidata.getNombre() + " son afines: "+afines);
		return afines;
	}
	
	public boolean esIdeal(Persona target, Persona candidata){
	boolean ideales = false;
	String aux1 = target.getNombre().toUpperCase();
	String aux2 = candidata.getNombre().toUpperCase();
	if(aux1.equals(aux2)) {
		ideales=true;
	}
	System.out.println(target.getNombre()+" y " + candidata.getNombre() + " son ideales: "+ideales);
	return ideales;
}

}