package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Caballero;
import modelo.Comparador;
import modelo.Conector;
import modelo.ModeloCaballero;

/**
 * Servlet implementation class Index_caballero
 */
@WebServlet("/Index_caballero")
public class Index_caballero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index_caballero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloCaballero mc = new ModeloCaballero();
		mc.setConector(new Conector());
		ArrayList<Caballero> caballeros = mc.getCaballeros();
		
		caballeros.sort(new Comparador());
		
		request.setAttribute("caballeros", caballeros);
		
		request.getRequestDispatcher("caballero.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String string = request.getParameter("string");
		
		ModeloCaballero mc = new ModeloCaballero();
		mc.setConector(new Conector());
		ArrayList<Caballero> caballeros = mc.getCaballeros();
		
		Iterator<Caballero> it = caballeros.iterator();
		while (it.hasNext()) {
			if (!(it.next().getNombre().toLowerCase().contains(string.toLowerCase()))) {
				it.remove();
			}
		}
		
		request.setAttribute("caballeros", caballeros);
		
		request.getRequestDispatcher("caballero.jsp").forward(request, response);
	}

}