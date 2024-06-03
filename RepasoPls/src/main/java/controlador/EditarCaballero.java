package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import modelo.Arma;
import modelo.Caballero;
import modelo.Conector;
import modelo.Escudo;
import modelo.ModeloArma;
import modelo.ModeloCaballero;
import modelo.ModeloEscudo;
import modelo.Validador;

/**
 * Servlet implementation class EditarCaballero
 */
@WebServlet("/EditarCaballero")
public class EditarCaballero extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Ruta a la carpeta donde se guardarán las fotos
    private static final String UPLOAD_DIR = "fotos";
    private static final String APLICATIN_LOCAL_PATH = "C:\\Users\\plaiaundi\\eclipse-workspace-jee\\Repaso\\src\\main\\webapp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarCaballero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ModeloCaballero mc = new ModeloCaballero();
		mc.setConector(new Conector());
		Caballero caballero = mc.getCaballero(id);
		
		ModeloArma ma = new ModeloArma();
		ma.setConector(new Conector());
		ArrayList<Arma> armas =ma.getArmas();
		
		ModeloEscudo me = new ModeloEscudo();
		me.setConector(new Conector());
		ArrayList<Escudo> escudos =me.getEscudos();

		Iterator<Arma> it = armas.iterator();
		while (it.hasNext()) {
			if (it.next().getId()==caballero.getArma().getId()) {
				it.remove();
			}
		}
		
		Iterator<Escudo> it2 = escudos.iterator();
		while (it2.hasNext()) {
			if (it2.next().getId()==caballero.getEscudo().getId()) {
				it2.remove();
			}
		}

		request.setAttribute("caballero", caballero);
		request.setAttribute("armas", armas);
		request.setAttribute("escudos", escudos);
		
		request.getRequestDispatcher("editarCaballero.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			/*String fileName="";
			// Obtener la parte del formulario con el archivo
	        Part filePart = request.getPart("foto");
	        
	        // Comprobar si se ha seleccionado un archivo
	        if (filePart != null && filePart.getSize() > 0) {
	            // Obtener el nombre del archivo
	            fileName = getFileName(filePart);
	            
	            // Obtener la ruta completa de la carpeta de fotos
//	            String applicationPath = request.getServletContext().getRealPath("");
//	            String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
	            String uploadFilePath = APLICATIN_LOCAL_PATH + File.separator + UPLOAD_DIR;
	            
	            // Crear la carpeta de destino si no existe
	            File uploadDir = new File(uploadFilePath);
	            if (!uploadDir.exists()) {
	                uploadDir.mkdirs();
	            }
	            
	            // Ruta completa del archivo a guardar
	            String filePath = uploadFilePath + File.separator + fileName;
	            
	            // Guardar el archivo en la ruta especificada
	            try (InputStream inputStream = filePart.getInputStream();
	                 FileOutputStream outputStream = new FileOutputStream(filePath)) {
	                
	                int read;
	                final byte[] bytes = new byte[1024];
	                while ((read = inputStream.read(bytes)) != -1) {
	                    outputStream.write(bytes, 0, read);
	                }
	            }
	        }
	        */
			
			String nombre = request.getParameter("nombre");

			if (Validador.stringVacio(request.getParameter("fuerza")) ==true || Validador.stringVacio(request.getParameter("experiencia"))==true) {
				response.sendRedirect("Index_caballero=msg=fail");
			}else {
				int id = Integer.parseInt(request.getParameter("id"));
				int fuerza = Integer.parseInt(request.getParameter("fuerza"));
				int experiencia = Integer.parseInt(request.getParameter("experiencia"));
				/*String foto = fileName;*/
				int arma_id = Integer.parseInt(request.getParameter("arma_id"));
				int escudo_id = Integer.parseInt(request.getParameter("escudo_id"));
				
				ModeloArma ma = new ModeloArma();
				ma.setConector(new Conector());
				
				ModeloEscudo me = new ModeloEscudo();
				me.setConector(new Conector());
				
				Caballero caballero = new Caballero(id,nombre,fuerza,experiencia,ma.getArma(arma_id),me.getEscudo(escudo_id));
				System.out.println(caballero);
				ModeloCaballero mc = new ModeloCaballero();
				mc.setConector(new Conector());
				mc.update(caballero);
				response.sendRedirect("Index_caballero?msg=okay");
				
			}
			
		}
		/*// Método para obtener el nombre del archivo
	    private String getFileName(Part part) {
	        final String partHeader = part.getHeader("content-disposition");
	        for (String content : partHeader.split(";")) {
	            if (content.trim().startsWith("filename")) {
	                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
	            }
	        }
	        return null;
	    }*/

}
