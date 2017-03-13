package com.atsistemas.curso;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProgramaHolaMundo {

	public static void main(String[] args) {
		// Tiene que instanciar el contexto Spring
		// y acceder a él para buscar los beans
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		//Saludador saludador = context.getBean(Saludador.class);
		//Saludador bean2 = (Saludador)context.getBean("primerSaludador");
		Saludador saludador = context.getBean("primerSaludador",Saludador.class);
		
		// Usamos el bean obtenido del contenedor
		saludador.saludar();

	}

}
