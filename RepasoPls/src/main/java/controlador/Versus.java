package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Caballero;
import modelo.Conector;
import modelo.Lucha;
import modelo.ModeloCaballero;

/**
 * Servlet implementation class Versus
 */
@WebServlet("/Versus")
public class Versus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Versus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCab1=Integer.parseInt(request.getParameter("cab1"));
		int idCab2=Integer.parseInt(request.getParameter("cab2"));
		ModeloCaballero mc = new ModeloCaballero();
		mc.setConector(new Conector());
		Caballero cab1 = mc.getCaballero(idCab1);
		Caballero cab2 = mc.getCaballero(idCab2);
		
		Lucha lucha = new Lucha();
		
		lucha.luchar(cab1, cab2);
		request.setAttribute("lucha", lucha);
		
		request.getRequestDispatcher("ganador.jsp").forward(request, response);
	}

}