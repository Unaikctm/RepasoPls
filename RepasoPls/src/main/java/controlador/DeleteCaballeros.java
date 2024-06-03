package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.*;

/**
 * Servlet implementation class DeleteCaballeros
 */
@WebServlet("/DeleteCaballeros")
public class DeleteCaballeros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCaballeros() {
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
		String caballerosAEliminarStr = request.getParameter("borrar");
		String[] caballerosAEliminar = caballerosAEliminarStr.split(",");
		
		ModeloCaballero mc = new ModeloCaballero();
		mc.setConector(new Conector());
		for (String caballeroid : caballerosAEliminar) {
			mc.delete(Integer.parseInt(caballeroid));
		}
		
		
		response.sendRedirect("Index_caballero");
	}

}
