package com.atsistemas.curso;

public class ProxyServicio implements Servicio, Extension {

	private Servicio target; //El objeto al cual suplanta
	private Extension extension; 

	public ProxyServicio(Servicio target, Extension extension) {
		super();
		this.target = target;
		this.extension = extension;
	}

	public String metodoInterceptado(String numero) {
		return "No me da la gana";
	}

	public String metodoNoInterceptado(String numero) {
		
		String resultado = target.metodoNoInterceptado(numero);
		
		System.out.println("Acaba de llegar: " + numero);
		System.out.println("Acabamos de retornar: " + numero);
		return resultado;
	}

	public void metodoNuevo() {
		extension.metodoNuevo();
	}
}
