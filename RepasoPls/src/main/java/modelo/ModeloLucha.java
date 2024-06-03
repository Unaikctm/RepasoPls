package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloLucha {
	private Conector con;
	
	public ArrayList<Lucha> getLuchas() {
		ArrayList<Lucha> luchas= new ArrayList<Lucha>();
		try {
			ModeloCaballero mc = new ModeloCaballero();
			mc.setConector(con);
			Statement st =con.getCon().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM luchas");
			
			while(rs.next()) {
				Lucha lucha = new Lucha();
				lucha.setId(rs.getInt("id"));
				lucha.setFecha(rs.getDate("fecha"));
				lucha.setCaballero1(mc.getCaballero(rs.getInt("caballero1_id")));
				lucha.setCaballero2(mc.getCaballero(rs.getInt("caballero2_id")));
				lucha.setGanador(mc.getCaballero(rs.getInt("ganador_id")));
				luchas.add(lucha);
			}
			return luchas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Lucha getLucha(int id) {
		try {
			ModeloCaballero mc = new ModeloCaballero();
			mc.setConector(con);
			PreparedStatement pst =con.getCon().prepareStatement("SELECT * FROM luchas WHERE id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				Lucha lucha = new Lucha();
				lucha.setId(rs.getInt("id"));
				lucha.setFecha(rs.getDate("fecha"));
				lucha.setCaballero1(mc.getCaballero(rs.getInt("caballero1_id")));
				lucha.setCaballero2(mc.getCaballero(rs.getInt("caballero2_id")));
				lucha.setGanador(mc.getCaballero(rs.getInt("ganador_id")));
				return lucha;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insertar(Lucha lucha) {
		try {
			PreparedStatement pst =con.getCon().prepareStatement("INSERT INTO luchas (id, fecha, caballero1_id, caballero2_id, ganador_id) VALUES (?,?,?,?,?)");
			pst.setInt(1, lucha.getId());
			pst.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
			pst.setInt(3, lucha.getCaballero1().getId());
			pst.setInt(4, lucha.getCaballero2().getId());
			pst.setInt(5, lucha.getGanador().getId());
			pst.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setConector(Conector con) {
		this.con= con;
	}
}