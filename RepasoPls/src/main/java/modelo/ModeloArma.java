package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloArma{
	
	private Conector con;
	
	public ArrayList<Arma> getArmas() {
		ArrayList<Arma> armas = new ArrayList<Arma>();
		try {
			Statement st = con.getCon().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM armas");
			
			while(rs.next()) {
				Arma arma = new Arma();
				arma.setId(rs.getInt("id"));
				arma.setNombre(rs.getString("nombre"));
				arma.setFoto(rs.getString("foto"));
				arma.setCapacidad_danio(rs.getInt("capacidad_danio"));
				armas.add(arma);
			}
			return armas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	
	public Arma getArma(int id) {
		try {
			PreparedStatement pst =con.getCon().prepareStatement("SELECT * FROM armas WHERE id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				Arma arma = new Arma();
				arma.setId(rs.getInt("id"));
				arma.setNombre(rs.getString("nombre"));
				arma.setFoto(rs.getString("foto"));
				arma.setCapacidad_danio(rs.getInt("capacidad_danio"));
				return arma;
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