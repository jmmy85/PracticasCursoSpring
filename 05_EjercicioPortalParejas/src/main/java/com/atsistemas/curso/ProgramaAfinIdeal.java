package com.atsistemas.curso;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProgramaAfinIdeal {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.atsistemas.curso");
		
		Servicio servicio = context.getBean(Servicio.class);

		Persona juan = new Persona(3,"Juan");
		servicio.altaPersona(juan);
		servicio.altaPersona(new Persona(4,"Juan"));
		servicio.altaPersona(new Persona(5,"Jaime"));
		
		List<Persona> afinesDeJuan = servicio.busquedaAfines(juan);
		
		System.out.println("Y los afines son.......");
		for (Persona afin : afinesDeJuan) {
			System.out.println(afin);

		}
		Persona ideal = servicio.busquedaIdeal(juan);
		System.out.println("Y el ideal es.......");
		System.out.println(ideal);
		
		context.close();
	}

}
