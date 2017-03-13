package com.atsistemas.curso.jpa;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsistemas.curso.entidades.Persona;
import com.atsistemas.curso.negocio.BasadoEnNombreNegocio;
import com.atsistemas.curso.negocio.Negocio;
import com.atsistemas.curso.servicios.Servicio;
import com.atsistemas.curso.servicios.ServicioImpl;

public class Aplicacion {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);

		Servicio servicio = contexto.getBean(ServicioImpl.class);
//		Persona ana = new Persona(1,"Ana",20,1.7F,"M");
//		Persona maria = new Persona(2,"Maria",22,1.8F,"M");
//		Persona pedro = new Persona(3,"Pedro",30,1.6F,"H");
//		Persona luisa = new Persona(4,"Luisa",25,1.65F,"M");
//		Persona marta = new Persona(5,"Marta",40,1.75F,"M");
//		Persona joaquin = new Persona(6,"Joaquin",20,1.72F,"H");
		Persona juan = new Persona(7,"Juan",20,1.62F,"H");
//		Persona ana = new Persona(8,"Ana",20,1.7F,"M");
//		Persona maria = new Persona(9,"Maria",22,1.8F,"M");
//		Persona pedro = new Persona(10,"Pedro",30,1.6F,"H");
//		Persona luisa = new Persona(11,"Luisa",25,1.65F,"M");
//		Persona marta = new Persona(12,"Marta",40,1.75F,"M");
//		Persona joaquin = new Persona(13,"Joaquin",20,1.72F,"H");
//		Persona juan = new Persona(14,"Juan",20,1.62F,"H");
//		servicio.altaPersona(ana);
//		servicio.altaPersona(maria);
//		servicio.altaPersona(pedro);
//		servicio.altaPersona(luisa);
//		servicio.altaPersona(marta);
//		servicio.altaPersona(joaquin);
//		servicio.altaPersona(juan);
		
		List<Persona> afinesDeJuan = servicio.busquedaAfines(juan);
		
		System.out.println("Y los afines son.......");
		for (Persona afin : afinesDeJuan) {
			System.out.println(afin);

		}
		Persona ideal = servicio.busquedaIdeal(juan);
		System.out.println("Y el ideal es.......");
		System.out.println(ideal);
		
		contexto.close();

	}

}
