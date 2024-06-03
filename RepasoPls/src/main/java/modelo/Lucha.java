package modelo;

import java.util.Date;

public class Lucha {
	private int id;
	private Date fecha;
	private Caballero caballero1;
	private Caballero caballero2;
	private Caballero ganador;
	
	public int getId() {
		return id;
	}
	public Caballero getCaballero1() {
		return caballero1;
	}
	public void setCaballero1(Caballero caballero1) {
		this.caballero1 = caballero1;
	}
	public Caballero getCaballero2() {
		return caballero2;
	}
	public void setCaballero2(Caballero caballero2) {
		this.caballero2 = caballero2;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Caballero getGanador() {
		return ganador;
	}
	public void setGanador(Caballero ganador) {
		this.ganador = ganador;
	}
	@Override
	public String toString() {
		return "Lucha [id=" + id + ", fecha=" + fecha + ", caballero1=" + caballero1 + ", caballero2=" + caballero2
				+ ", ganador=" + ganador + "]";
	}
	
	public void luchar(Caballero caballero1, Caballero caballero2) {
		setFecha(new Date());
		setCaballero1(caballero1);
		setCaballero2(caballero2);
		
		int poder1 =caballero1.getArma().getCapacidad_danio()+caballero1.getEscudo().getCapacidad_defensa();
		int poder2 =caballero2.getArma().getCapacidad_danio()+caballero2.getEscudo().getCapacidad_defensa();
		
		if(poder1>=poder2) {
			setGanador(caballero1);
		}else {
			setGanador(caballero2);
		}
		ModeloLucha ml = new ModeloLucha();
		ml.setConector(new Conector()); 
		ml.insertar(this);
		
	}
	
}