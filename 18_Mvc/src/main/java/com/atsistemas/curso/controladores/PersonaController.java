package com.atsistemas.curso.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import com.atsistemas.curso.vistas.AfinesPdfView;

@Controller
@RequestMapping("/Persona")
public class PersonaController {
	
	@RequestMapping(name="/Alta/{id}",method=RequestMethod.POST) // Entre llaves se ponen las variables
	public String procesarAltaPersona(@PathVariable long id, Persona persona) { // Con PathVariable se asignan
		System.out.println("Alta");
		return "formularioAlta";
	}

	@RequestMapping(name="/Alta",method=RequestMethod.GET)
	public String inicializarAltaPersona(@RequestParam String nombre) {
		System.out.println(nombre);
		return "formularioAlta";
	}
	
	@RequestMapping(name="/BuscarAfines", method=RequestMethod.GET)
	public View procesarBuscarAfines(Model model, HttpSession session) {
		System.out.println("BuscarAfines");
		List<String> afines = new ArrayList<String>();
		afines.add("Juan");
		afines.add("Maria");
		model.addAttribute("listadoAfines",afines);
		//return (View) new ModelAndView("listadoAfines");
		return new AfinesPdfView();
	}

}
