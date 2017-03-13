package com.atsistemas.curso.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.atsistemas.curso.entidades.Persona;
import com.atsistemas.curso.servicios.Servicio;
import com.atsistemas.curso.servicios.ServicioImpl;

/**
 * Servlet implementation class ParejasController
 */
@WebServlet("/Ideal")
public class IdealController extends SpringWebAbstractController {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdealController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Persona usuario = (Persona)request.getSession().getAttribute(USUARIO_SESSION_KEY);
		
		if(usuario!=null) {
			Persona ideal = getServicio().busquedaIdeal(usuario);
			response.getWriter().append("El ideal de "+usuario.getNombre()+" es... ");
			response.getWriter().append(ideal.toString());
		}
		else {
			response.getWriter().append("Introduce un nombre para buscar el ideal.");
			response.getWriter().append("<form action=\""+request.getContextPath()+"/Ideal\">");
			response.getWriter().append("<br/>Nombre: <input type=\"text\"name=\"nombre\" value=\"\" />");
			response.getWriter().append("<br/><input type=\"submit\" name=\"btnEnviar\" value=\"Enviar\" />");
			response.getWriter().append("</form>");
		}
		response.getWriter().append("<br/><br/>");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
