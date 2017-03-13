package com.atsistemas.curso.controladores;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.curso.entidades.Persona;

//@Controller
//@ResponseBody
// Controller y ResponseBody juntas son exactamente coomo RestController,
// por eso se reemplazan por ella
@RestController
@RequestMapping(path="/Persona",
		produces={
				MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE},
		consumes={
				MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE})
public class PersonaController {
	
	@RequestMapping(method=RequestMethod.GET, consumes=MediaType.ALL_VALUE)
	public ResponseEntity<List<Persona>> consultar(
			@RequestParam(required=false) Integer edad
			){
		LinkedList<Persona> personas = new LinkedList<Persona>();
		if(edad!=null) {
			personas.add(new Persona(1,"Juan",edad,1.70,"Hombre"));
		}
		else {
			personas.add(new Persona(1,"Juan",21,1.70,"Hombre"));
			personas.add(new Persona(2,"Juan",34,1.60,"Mujer"));
		}
		
		return new ResponseEntity<>(personas, HttpStatus.OK);
	}

	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Persona> consultarPorId(@PathVariable long id){
		return new ResponseEntity<>(new Persona(id,"Juan",35,1.70,"Hombre"),HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity insertar (@RequestBody Persona persona, HttpServletRequest request) {
		//TODO Retorna códigos de respuesta y location
		System.out.println(persona);
		HttpHeaders cabeceras = new HttpHeaders();
		try {
			cabeceras.setLocation(new URI(request
					.getRequestURL().append("/")
					.append(persona.getId()).toString()));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity actualizar(@RequestBody Persona persona){
		//TODO Retorna códigos de respuesta
		return new ResponseEntity<>(persona,HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.DELETE)
	public void borrarPorId(@PathVariable long id){
		//TODO Retorna códigos de respuesta
	}
	
}
