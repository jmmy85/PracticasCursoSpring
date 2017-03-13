package com.atsistemas.curso.controladores;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.atsistemas.curso.entidades.Persona;
import com.atsistemas.curso.servicios.Servicio;
import com.atsistemas.curso.servicios.SimpleServicio;
import com.atsistemas.curso.vistas.AfinesPdfView;
import com.atsistemas.curso.vistas.MensajeView;

@Controller
@RequestMapping("/Persona")
@SessionAttributes({"generos"})
public class PersonaController {
	
	private Servicio servicio;
	
	@ModelAttribute
	public String[] iniGeneros(){
		return new String[]{"Hombre","Mujer"};
	}
	
	@Autowired
	public PersonaController(){
		super();
		this.servicio = servicio;
	}

	@RequestMapping(path="/Alta/{id}", method=RequestMethod.POST)
	public ModelAndView altaPersona(@PathVariable long id, @Valid Persona persona, Errors errors){
		System.out.println(errors);
		if(!errors.hasErrors()) {
			System.out.println("Llamada a la lógica.");
		}
		
		ModelAndView modelAndView = new ModelAndView(new MensajeView());
		String mensaje ="Error!!!";
		try {
			servicio.altaPersona(persona);
			mensaje = "El alta se ha realizado de forma correcta con los datos." + persona;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelAndView.addObject("mensaje",mensaje);
		
		return modelAndView;
	}

	@RequestMapping(path="/Alta/{id}", method=RequestMethod.GET)
	public String inicializadorFormularioAltaPersona(Model model){
		model.addAttribute("persona", new Persona());
		
		// Sólo estaría disponible para este método
		model.addAttribute("generos", new String[]{"Hombre","Mujer"});
		
		return "alta";
	}
	
	@RequestMapping("/Afines")
	public View busquedaAfines(Model model, HttpSession session) {
		Persona persona = (Persona) session.getAttribute("usuario");
		String mensaje ="Error!!!";
		
		try {
			List<Persona> afines = servicio.busquedaAfines(persona);
			mensaje = "Búsqueda realizada correctamente";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("afines");
		return new AfinesPdfView();
	}
	
	
	@RequestMapping("/Ideal")
	public String busquedaIdeal(Model model, HttpSession session) {
		Persona usuario = (Persona) session.getAttribute("usuario");
		
		try {
			Persona ideal = servicio.busquedaIdeal(usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("ideal");
		return "ideal";
		
	}
	
	@RequestMapping("/Login/{id}")
	public String login(@PathVariable("id") long parseLong, HttpSession session, Model model){
		Persona usuario = servicio.buscarPersonaPorId(parseLong);
		
		try {
			if(usuario!=null) {
				session.setAttribute("usuario", usuario);
				return "principal";
			}
			else {
				model.addAttribute("mensaje","Login incorrecto!!!");
				return "formularioLogin";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("mensaje","Error!!!"+e.getMessage());
			return "formularioLogin";
		}
	}
	
	
	@RequestMapping("/Login/{id}")
	public String logout(HttpSession session){
		session.invalidate();
		return "formularioLogin";
	}
	/*
	@RequestMapping(name="/Alta/{id}",method=RequestMethod.GET)
	public String inicializarAltaPersona(@PathVariable long id,
			@PathVariable String nombre,
			@PathVariable int edad,
			@PathVariable double altura,
			@PathVariable String genero
			) {
		System.out.println("Estoy en inicializarAltaPersona");
		Persona persona = new Persona(id, nombre, edad, altura, genero);
		getServicio().altaPersona(persona);
		return "alta";
	}
	
	@RequestMapping(name="/Alta",method=RequestMethod.POST)
	public String procesarAltaPersona() {
		System.out.println("Estoy en procesarAltaPersona");
		return "alta";
	}
	
	@RequestMapping("/Afines")
	public String afinesPersona(@RequestParam String nombre) {
		System.out.println("Estoy en afinesPersona");
		Persona persona = new Persona();
		persona.setNombre(nombre);
		getServicio().busquedaAfines(persona);
		return "alta";
		
	}
	
	@RequestMapping("/Ideal")
	public String idealPersona(@RequestParam String nombre) {
		System.out.println("Estoy en idealPersona");
		Persona persona = new Persona();
		persona.setNombre(nombre);
		getServicio().busquedaIdeal(persona);
		return "alta";
		
	}
*/
}
