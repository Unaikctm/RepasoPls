package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.*;
/**
 * Servlet implementation class SeleccionaCaballero
 */
@WebServlet("/SeleccionaCaballeroDos")
public class SeleccionaCaballeroDos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeleccionaCaballeroDos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCab1=Integer.parseInt(request.getParameter("cab1"));
		ModeloCaballero mc = new ModeloCaballero();
		mc.setConector(new Conector());
		int idCab2 =Integer.parseInt(request.getParameter("caballero"));

		request.setAttribute("cab1", mc.getCaballero(idCab1));
		
		request.setAttribute("cab2", mc.getCaballero(idCab2));
		
		request.getRequestDispatcher("versus.jsp").forward(request, response);
		
	}

}