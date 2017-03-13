package com.atsistemas.curso.controladores;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.entidades.Factura;
import com.atsistemas.curso.servicios.Servicio;

@RestController
@RequestMapping("/Rest")
public class RestFacturaControlador {
	
	private Servicio servicio;

	@Autowired
	public RestFacturaControlador(Servicio servicio) {
		super();
		this.servicio = servicio;
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Factura> altaFactura(@RequestBody Factura factura) {
		servicio.altaFactura(factura);
		return new ResponseEntity<Factura>(HttpStatus.CREATED);
	}

	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Factura> bajaFactura(long id) {
		servicio.bajaFactura(id);
		return new ResponseEntity<Factura>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Factura> actualizarFactura(Factura factura) {
		servicio.actualizarFactura(factura);
		return new ResponseEntity<Factura>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Factura> obtenerFactura(@PathVariable long id, HttpServletRequest request) {
		Factura factura = servicio.obtenerFactura(id);
		HttpHeaders cabeceras = new HttpHeaders();
		try {
			cabeceras.setLocation(new URI(request
					.getRequestURL().append("/")
					.append(factura.getId()).toString()));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Factura>(HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Factura>> obtenerFacturas() {
		List<Factura> facturas = servicio.obtenerFacturas();
		return new ResponseEntity<List<Factura>>(facturas,HttpStatus.OK);
	}

	@RequestMapping(path="/{id}/Cliente",method=RequestMethod.GET)
	public ResponseEntity<Cliente> obtenerClienteDeFactura(@PathVariable("id") long idFactura) {
		Cliente cliente = servicio.obtenerClienteDeFactura(idFactura);
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}

}
