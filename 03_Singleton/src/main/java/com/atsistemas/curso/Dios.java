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
		return new Asiatico();
	}
	
	public Hombre fabricarEuropeo(){
		return new Europeo();
	}
	
	private class Asiatico implements Hombre{
		
	}
	
	private class Europeo implements Hombre{
		
	}

}
