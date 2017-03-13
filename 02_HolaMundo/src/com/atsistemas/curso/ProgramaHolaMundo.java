package com.atsistemas.curso;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProgramaHolaMundo {

	public static void main(String[] args) {
		// Tiene que instanciar el contexto Spring
		// y acceder a él para buscar los beans
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfiguracionSpring.class);
		
		//Saludador saludador = context.getBean(Saludador.class);
		//Saludador bean2 = (Saludador)context.getBean("primerSaludador");
		Saludador saludador = context.getBean("primerSaludador",Saludador.class);
		
		// Usamos el bean obtenido del contenedor
		saludador.saludar();
		
		Saludador otro = context.getBean("primerSaludador", Saludador.class);
		
		if(saludador==otro) {
			System.out.print("Son el mismo");
		}
		

	}

}
