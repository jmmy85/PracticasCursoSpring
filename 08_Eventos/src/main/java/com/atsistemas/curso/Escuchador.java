package com.atsistemas.curso;

import org.springframework.context.ApplicationListener;

public class Escuchador implements ApplicationListener<MiEvento> {

	public void onApplicationEvent(MiEvento event) {
		// Aqu� viene la l�gica cuando se produce un evento.
		System.out.println(event.getSource());
	}

}
