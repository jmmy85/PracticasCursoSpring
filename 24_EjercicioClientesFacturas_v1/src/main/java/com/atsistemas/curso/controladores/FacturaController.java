package com.atsistemas.curso.controladores;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.entidades.Factura;
import com.atsistemas.curso.servicios.FacturaServicio;

@RestController
@RequestMapping(path="/Factura",
produces={
		MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE},
consumes={
		MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE})
public class FacturaController {
	
	FacturaServicio servicio;
	
	@Autowired
	public FacturaController (FacturaServicio servicio){
		super();
		this.servicio=servicio;
	}
	
	protected FacturaServicio getServicio() {
		return servicio;
	}

		@RequestMapping(method=RequestMethod.GET, consumes=MediaType.ALL_VALUE)
		public ResponseEntity<List<Factura>> consultar() {
			return new ResponseEntity<List<Factura>>(servicio.busquedaFactura(),HttpStatus.OK);
		}
		
		@RequestMapping(path="/{id}",method=RequestMethod.GET)
		public ResponseEntity<Factura> consultarPorId(@PathVariable long id){
			return new ResponseEntity<>(new Factura(20,new Cliente("Juan")),HttpStatus.OK);
		}

		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity insertar (@RequestBody Factura factura, HttpServletRequest request) {
			//TODO Retorna códigos de respuesta y location
			System.out.println(factura);
			HttpHeaders cabeceras = new HttpHeaders();
			try {
				servicio.altaFactura(factura);
				cabeceras.setLocation(new URI(request
						.getRequestURL().append("/")
						.append(factura.getId()).toString()));
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponseEntity<>(HttpStatus.CREATED);
		}

		@RequestMapping(method=RequestMethod.PUT)
		public ResponseEntity actualizar(@RequestBody Factura factura){
			//TODO Retorna códigos de respuesta
			return new ResponseEntity<>(factura,HttpStatus.OK);
		}

		@RequestMapping(method=RequestMethod.DELETE)
		public void borrarPorId(@PathVariable long id){
			servicio.borrarFacturaPorId(id);
		}

	}
