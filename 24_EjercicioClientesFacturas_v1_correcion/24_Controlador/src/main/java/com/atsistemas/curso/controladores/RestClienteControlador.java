package com.atsistemas.curso.controladores;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.entidades.Factura;
import com.atsistemas.curso.servicios.Servicio;

@RestController
@RequestMapping("/Rest")
public class RestClienteControlador {
	
	private Servicio servicio;

	@Autowired
	public RestClienteControlador(Servicio servicio) {
		super();
		this.servicio = servicio;
	}

	public ResponseEntity<Cliente> altaCliente(Cliente cliente, HttpServletRequest request) {
		servicio.altaCliente(cliente);
		HttpHeaders cabeceras = new HttpHeaders();
		try {
			cabeceras.setLocation(new URI(request
					.getRequestURL().append("/")
					.append(cliente.getId()).toString()));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Cliente>(HttpStatus.CREATED);
	}

	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Cliente> bajaCliente(long id) {
		servicio.bajaCliente(id);
		return new ResponseEntity<Cliente>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Cliente> actualizarCliente(Cliente cliente) {
		servicio.actualizarCliente(cliente);
		return new ResponseEntity<Cliente>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Cliente> obtenerCliente(@PathVariable long id) {
		Cliente cliente = servicio.obtenerCliente(id);
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> obtenerClientes() {
		List<Cliente> clientes = servicio.obtenerClientes();
		return new ResponseEntity<List<Cliente>>(clientes,HttpStatus.OK);
	}

	@RequestMapping(path="/{id}/Facturas",method=RequestMethod.GET)
	public ResponseEntity<Cliente> obtenerFacturasDeCliente(@PathVariable("id") long idCliente) {
		List<Factura> facturas = servicio.obtenerFacturasDeCliente(idCliente);
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}

}
