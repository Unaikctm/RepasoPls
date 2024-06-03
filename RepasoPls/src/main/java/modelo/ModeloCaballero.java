package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloCaballero{
	
	private Conector con;
	
	public ArrayList<Caballero> getCaballeros() {
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
		try {
			ModeloArma ma = new ModeloArma();
			ma.setConector(con);
			ModeloEscudo me = new ModeloEscudo();
			me.setConector(con);
			Statement st = con.getCon().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM caballeros");
			
			while(rs.next()) {
				Caballero caballero = new Caballero();
				caballero.setId(rs.getInt("id"));
				caballero.setNombre(rs.getString("nombre"));
				caballero.setFuerza(rs.getInt("fuerza"));
				caballero.setExperiencia(rs.getInt("experiencia"));
				caballero.setFoto(rs.getString("foto"));
				caballero.setArma(ma.getArma(rs.getInt("arma_id")));
				caballero.setEscudo(me.getEscudo(rs.getInt("escudo_id")));
				caballeros.add(caballero);
			}
			return caballeros;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	
	public Caballero getCaballero(int id) {
		try {
			ModeloArma ma = new ModeloArma();
			ma.setConector(con);
			ModeloEscudo me = new ModeloEscudo();
			me.setConector(con);
			PreparedStatement pst =con.getCon().prepareStatement("SELECT * FROM caballeros WHERE id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				Caballero caballero = new Caballero();
				caballero.setId(rs.getInt("id"));
				caballero.setNombre(rs.getString("nombre"));
				caballero.setFuerza(rs.getInt("fuerza"));
				caballero.setExperiencia(rs.getInt("experiencia"));
				caballero.setFoto(rs.getString("foto"));
				caballero.setArma(ma.getArma(rs.getInt("arma_id")));
				caballero.setEscudo(me.getEscudo(rs.getInt("escudo_id")));
				return caballero;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insert(Caballero caballero) {
		try {
			ModeloArma ma = new ModeloArma();
			ma.setConector(con);
			ModeloEscudo me = new ModeloEscudo();
			me.setConector(con);
			PreparedStatement pst =con.getCon().prepareStatement("INSERT INTO caballeros (id, nombre, fuerza, experiencia, foto, arma_id, escudo_id) VALUES (?,?,?,?,?,?,?)");
			pst.setInt(1, caballero.getId());
			pst.setString(2, caballero.getNombre());
			pst.setInt(3, caballero.getFuerza());
			pst.setInt(4, caballero.getExperiencia());
			pst.setString(5, caballero.getFoto());
			pst.setInt(6, caballero.getArma().getId());
			pst.setInt(7, caballero.getEscudo().getId());
			pst.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Caballero caballero) {
	    try {
	        ModeloArma ma = new ModeloArma();
	        ma.setConector(con);
	        ModeloEscudo me = new ModeloEscudo();
	        me.setConector(con);
	        String sql = "UPDATE caballeros SET nombre = ?, fuerza = ?, experiencia = ?, arma_id = ?, escudo_id = ? WHERE id = ?";
	        PreparedStatement pst = con.getCon().prepareStatement(sql);
	        pst.setString(1, caballero.getNombre());
	        pst.setInt(2, caballero.getFuerza());
	        pst.setInt(3, caballero.getExperiencia());
	        pst.setInt(4, caballero.getArma().getId());
	        pst.setInt(5, caballero.getEscudo().getId());
	        pst.setInt(6, caballero.getId());
	        
	        pst.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void delete(int id) {
			String sql = "DELETE FROM CABALLEROS WHERE id=?";

			try {
				PreparedStatement pst = con.getCon().prepareStatement(sql);
				pst.setInt(1, id);
				pst.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void setConector(Conector con) {
		this.con= con;
	}
}