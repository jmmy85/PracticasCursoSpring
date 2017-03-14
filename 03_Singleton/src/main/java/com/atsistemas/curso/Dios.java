package com.atsistemas.curso;

public class Dios {
	
	private static Dios instance = new Dios();
	
	private Dios(){
		
	}
	
	// Factoría estática
	public static Dios getInstance(){
		return instance;
	}
	
	// Factoría instanciada
	public Hombre fabricarAisatico(){
		System.out.println("Fabricando asiático... OK");
		return new Asiatico();
	}
	
	public Hombre fabricarEuropeo(){
		System.out.println("Fabricando europeo... OK");
		return new Europeo();
	}

}
