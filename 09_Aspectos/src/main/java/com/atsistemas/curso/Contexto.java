package com.atsistemas.curso;

public class Contexto {
	
	public Object getBean(String tipo){
		if(tipo.equals("servicio")) {
			
			// No hace esto, que es lo que en principio podr�amos esperar:
			//return new MiServicio();
			
			// En realidad hace esto:
			return new ProxyServicio(new MiServicio(), new ExtensionImpl());
		}
		else {
			return null;
		}
	}

}
