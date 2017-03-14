package com.atsistemas.curso;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.stereotype.Component;

@Component
public class ProgramaMundo {

	public static void main(String[] args) {
		
		// Siempre se devuelve el mismo objeto
		Dios dios = Dios.getInstance();
		Dios dios2 = Dios.getInstance();
		
		if(dios==dios2) {
			System.out.println("dios y dios2 son el mismo dios");
		}
		else {
			System.out.println("dios y y dios2 son dioses distintos");
		}

		dios.fabricarAisatico();
		dios.fabricarAisatico();
		dios.fabricarAisatico();
		dios.fabricarEuropeo();
		dios.fabricarEuropeo();
		dios.fabricarEuropeo();
	}

}
