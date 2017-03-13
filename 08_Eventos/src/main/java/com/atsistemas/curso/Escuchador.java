package com.atsistemas.curso;

import org.springframework.context.ApplicationListener;

public class Escuchador implements ApplicationListener<MiEvento> {

	public void onApplicationEvent(MiEvento event) {
		// Aquí viene la lógica cuando se produce un evento.
		System.out.println(event.getSource());
	}

}
