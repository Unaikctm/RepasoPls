package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloEscudo{
	
	private Conector con;
	
	public ArrayList<Escudo> getEscudos() {
		ArrayList<Escudo> escudos = new ArrayList<Escudo>();
		try {
			Statement st = con.getCon().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM escudos");
			
			while(rs.next()) {
				Escudo escudo = new Escudo();
				escudo.setId(rs.getInt("id"));
				escudo.setNombre(rs.getString("nombre"));
				escudo.setCapacidad_defensa(rs.getInt("capacidad_defensa"));
				escudos.add(escudo);
			}
			return escudos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	
	public Escudo getEscudo(int id) {
		try {
			PreparedStatement pst =con.getCon().prepareStatement("SELECT * FROM escudos WHERE id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				Escudo escudo = new Escudo();
				escudo.setId(rs.getInt("id"));
				escudo.setNombre(rs.getString("nombre"));
				escudo.setCapacidad_defensa(rs.getInt("capacidad_defensa"));
				return escudo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setConector(Conector con) {
		this.con= con;
	}
}