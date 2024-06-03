package controlador;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import modelo.Caballero;
import modelo.Conector;
import modelo.ModeloArma;
import modelo.ModeloCaballero;
import modelo.ModeloEscudo;
import modelo.Validador;

/**
 * Servlet implementation class Store_caballero
 */
@WebServlet("/Store_caballero")
@MultipartConfig
public class Store_caballero extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Ruta a la carpeta donde se guardarán las fotos
    private static final String UPLOAD_DIR = "fotos";
    private static final String APLICATIN_LOCAL_PATH = "C:\\Users\\plaiaundi\\eclipse-workspace-2\\RepasoPls\\src\\main\\webapp";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Store_caballero() {
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
		String fileName="";
		// Obtener la parte del formulario con el archivo
        Part filePart = request.getPart("foto");
        
        // Comprobar si se ha seleccionado un archivo
        if (filePart != null && filePart.getSize() > 0) {
            // Obtener el nombre del archivo
            fileName = getFileName(filePart);
            
            // Obtener la ruta completa de la carpeta de fotos
//            String applicationPath = request.getServletContext().getRealPath("");
//            String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
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
        
		
		String nombre = request.getParameter("nombre");
		if (Validador.stringVacio(request.getParameter("fuerza")) ==true || Validador.stringVacio(request.getParameter("experiencia"))==true) {
			response.sendRedirect("Index_caballero");
		}else {
			int fuerza = Integer.parseInt(request.getParameter("fuerza"));
			int experiencia = Integer.parseInt(request.getParameter("experiencia"));
			String foto = fileName;
			int arma_id = Integer.parseInt(request.getParameter("arma_id"));
			int escudo_id = Integer.parseInt(request.getParameter("escudo_id"));
			
			ModeloArma ma = new ModeloArma();
			ma.setConector(new Conector());
			
			ModeloEscudo me = new ModeloEscudo();
			me.setConector(new Conector());
			
			Caballero caballero = new Caballero(nombre,fuerza,experiencia,foto,ma.getArma(arma_id),me.getEscudo(escudo_id));
			
			if(Validador.algunFallo(nombre, fuerza, experiencia, nombre, arma_id, escudo_id)==false) {
				ModeloCaballero mc = new ModeloCaballero();
				mc.setConector(new Conector());
				mc.insert(caballero);
				response.sendRedirect("Index_caballero?msg=okay");
			}else response.sendRedirect("Index_caballero?msg=fail");
			
			
		}
		
	}
	// Método para obtener el nombre del archivo
    private String getFileName(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

}