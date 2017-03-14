package com.atsistemas.curso;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.atsistemas.curso") // Sirve para que Spring tenga en cuenta las anotaciones (Por defecto no se tienen en cuenta)
public class Configuracion {
//
//	@Bean
//	public PersonaDao dao(){
//		return new MemoriaPersonaDao();
//	}
//
//	@Bean
//	public Servicio otroServicio(PersonaDao dao){
//		Servicio servicio = new Servicio();
//		servicio.setDao(dao);
//		return servicio;
//	}
//	
//	@Bean
//	// Autoinyección: El propio spring busca quien cumpla con este contrato metodo(argumento)
//	public Servicio servicio(PersonaDao dao) {
//		return new Servicio(dao, null);
//	}
}
