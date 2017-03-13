package com.atsistemas.curso;

import org.springframework.stereotype.Component;

@Component
public class ProgramaMundo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// Siempre se devuelve el mismo objeto
		Dios dios = Dios.getInstance();
		Dios dios2 = Dios.getInstance();
	}

}
