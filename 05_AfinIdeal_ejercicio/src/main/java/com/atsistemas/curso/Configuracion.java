package com.atsistemas.curso;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.atsistemas.curso")
public class Configuracion {
	
	@Bean
	public Map<Long,Persona> personas(){
		HashMap<Long,Persona> map = new HashMap<Long,Persona>();
		map.put(1L, new Persona(1,"Victor"));
		map.put(2L, new Persona(2,"Maria"));
		return map;
	}
}
