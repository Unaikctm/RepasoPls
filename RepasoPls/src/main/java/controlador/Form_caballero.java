package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Arma;
import modelo.Conector;
import modelo.Escudo;
import modelo.ModeloArma;
import modelo.ModeloEscudo;

/**
 * Servlet implementation class Form_caballero
 */
@WebServlet("/Form_caballero")
public class Form_caballero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Form_caballero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloArma ma = new ModeloArma();
		ma.setConector(new Conector());
		ArrayList<Arma> armas =ma.getArmas();
		
		ModeloEscudo me = new ModeloEscudo();
		me.setConector(new Conector());
		ArrayList<Escudo> escudos =me.getEscudos();
		
		request.setAttribute("armas", armas);
		request.setAttribute("escudos", escudos);
		
		request.getRequestDispatcher("formCaballero.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
