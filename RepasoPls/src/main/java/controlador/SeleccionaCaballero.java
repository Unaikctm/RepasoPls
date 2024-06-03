package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Caballero;
import modelo.Conector;
import modelo.ModeloCaballero;

/**
 * Servlet implementation class SeleccionaCaballero
 */
@WebServlet("/SeleccionaCaballero")
public class SeleccionaCaballero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeleccionaCaballero() {
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
		ModeloCaballero mc = new ModeloCaballero();
		mc.setConector(new Conector());
		int idCab1 =Integer.parseInt(request.getParameter("caballero"));

		ArrayList<Caballero> caballeros = mc.getCaballeros();
		
		int i=0;
		while (i<caballeros.size()) {
			if(caballeros.get(i).getId()==idCab1) {
				caballeros.remove(i);
			}
			i=i+1;
		}
		
		request.setAttribute("cab1", idCab1);
		
		request.setAttribute("caballeros", caballeros);
		
		request.getRequestDispatcher("caballeroSelectorDos.jsp").forward(request, response);
		
	}

}