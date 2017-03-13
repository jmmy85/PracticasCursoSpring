package com.atsistemas.curso.controladores;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
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
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.atsistemas.curso.entidades.Cliente;
import com.atsistemas.curso.servicios.ClienteServicio;

@RestController
@RequestMapping(path="/Cliente",
produces={
		MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE},
consumes={
		MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE})
public class ClienteController {
	
	ClienteServicio servicio;
	
	@Autowired
	public ClienteController (ClienteServicio servicio){
		super();
		this.servicio=servicio;
	}
	
	protected ClienteServicio getServicio() {
		return servicio;
	}

	@RequestMapping(method=RequestMethod.GET, consumes=MediaType.ALL_VALUE)
	public ResponseEntity<List<Cliente>> consultar() {
		
		return new ResponseEntity<List<Cliente>>(servicio.busquedaCliente(),HttpStatus.OK);
	}
	
	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Cliente> consultarPorId(@PathVariable long id){
		return new ResponseEntity<>(new Cliente("Juan"),HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity insertar (@RequestBody Cliente cliente, HttpServletRequest request) {
		//TODO Retorna códigos de respuesta y location
		System.out.println(cliente);
		HttpHeaders cabeceras = new HttpHeaders();
		try {
			servicio.altaCliente(cliente);
			cabeceras.setLocation(new URI(request
					.getRequestURL().append("/")
					.append(cliente.getId()).toString()));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity actualizar(@RequestBody Cliente cliente){
		//TODO Retorna códigos de respuesta
		return new ResponseEntity<>(cliente,HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.DELETE)
	public void borrarPorId(@PathVariable long id){
		servicio.borrarClientePorId(id);
	}

}
