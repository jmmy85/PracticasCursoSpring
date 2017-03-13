package com.atsistemas.curso.negocio;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.entidades.Factura;
import com.atsistemas.curso.persistencia.ClienteDao;
import com.atsistemas.curso.persistencia.FacturaDao;

@Component
public class DummyNegocio {
	
	@PersistenceContext
	private ClienteDao clienteDao;

	@PersistenceContext
	private FacturaDao facturaDao;
	
	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}
	
	public void altaClienteYFactura(Cliente cliente,Factura factura) {
		clienteDao.save(cliente);
		
		//cliente.setNombre("Pepito Grillo"); //Cambia realmente el nombre porque al finalizar el m�todo
		// Se persisten los objetos que hay en memoria. Esto se evita con los Detached para que si hay un cambio
		// en los objetos en memoria, �ste no se plasme en base de datos.
		
		System.out.println("Entre la inserci�n del cliente y la factura");
		
		facturaDao.save(factura);
		
	}
	
	public void altaCliente(Cliente cliente) {
		clienteDao.save(cliente);
		//Mando un correo electr�nico
		//gestorCorreo.enviar(cliente.getEmail(),new CorreoBienvenida(cliente));
		
	}
	
	public void modificarCliente(Cliente cliente) {// En este momento se crea la sesi�n (y se inicia la transacci�n)
		//clienteDao.insertarHistorico(cliente.getId()); // Aunque este m�todo sea transaccional, ya utiliza la
		// sesi�n creada, no crea una nueva.
		//clienteDao.actualizar(cliente);
		//Mando un correo electr�nico
		//gestorCorreo.enviar(cliente.getEmail(),new CorreoBienvenida(cliente));
		
	}// En este momento se cierra la sesi�n (termina la transacci�n)

}
