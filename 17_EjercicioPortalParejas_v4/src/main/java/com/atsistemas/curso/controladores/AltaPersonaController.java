package com.atsistemas.curso.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import com.atsistemas.curso.entidades.Persona;

/**
 * Servlet implementation class AltaPersonaController
 */
@WebServlet("/AltaPersona")
public class AltaPersonaController extends SpringWebAbstractController {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaPersonaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id=request.getParameter("id");
		String nombre=request.getParameter("nombre");
		String edad=request.getParameter("edad");
		String altura=request.getParameter("altura");
		String genero=request.getParameter("genero");
		
		if(id!=null && nombre!=null && !nombre.equals("")) {
			
			Persona persona = new Persona(
					Long.parseLong(id),
					nombre,
					Integer.parseInt(edad),
					Double.parseDouble(altura),
					genero);
			
			getServicio().altaPersona(persona);
			
			response.getWriter().append("Persona "+nombre+" insertada correctamente");
			
			request.getSession().setAttribute(USUARIO_SESSION_KEY, persona);
		}
		else {
			response.getWriter().append("Introduce una persona para insertar");
			response.getWriter().append("<form action=\""+request.getContextPath()+"/AltaPersona\">");
			response.getWriter().append("<br/>Id: <input type=\"text\" name=\"id\" value=\"\" />");
			response.getWriter().append("<br/>Nombre: <input type=\"text\" name=\"nombre\" value=\"\" />");
			response.getWriter().append("<br/><input type=\"submit\" name=\"btnEnviar\" value=\"Enviar\" />");
			response.getWriter().append("</form>");
		}
		
		response.getWriter().append("<br/><br/>");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
		

}
