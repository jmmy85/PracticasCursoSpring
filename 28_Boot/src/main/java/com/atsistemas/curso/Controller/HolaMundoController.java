package com.atsistemas.curso.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HolaMundoController {
	@RequestMapping("/")
	@ResponseBody
	public String holaMundo() {
		return "Hola mundo";
	}

}
