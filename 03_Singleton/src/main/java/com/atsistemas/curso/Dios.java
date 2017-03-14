package com.atsistemas.curso;

public class Dios {
	
	private static Dios instance = new Dios();
	
	private Dios(){
		
	}
	
	// Factor�a est�tica
	public static Dios getInstance(){
		return instance;
	}
	
	// Factor�a instanciada
	public Hombre fabricarAisatico(){
		System.out.println("Fabricando asi�tico... OK");
		return new Asiatico();
	}
	
	public Hombre fabricarEuropeo(){
		System.out.println("Fabricando europeo... OK");
		return new Europeo();
	}

}
