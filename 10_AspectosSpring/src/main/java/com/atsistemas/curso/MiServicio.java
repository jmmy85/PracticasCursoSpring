package com.atsistemas.curso;

import org.springframework.stereotype.Component;

@Component
public class MiServicio implements Servicio {

	public String metodoInterceptado(String numero) {
		return "prefijo "+numero+" sufijo!!!";
	}

	public String metodoNoInterceptado(String numero) {
		return "prefijo "+numero+" sufijo!!!";
	}

}
