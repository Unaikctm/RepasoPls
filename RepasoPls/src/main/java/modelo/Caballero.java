package modelo;

public class Caballero {
	private int id;
	private String nombre;
	private int fuerza;
	private int experiencia;
	private String foto;
	private Arma arma;
	private Escudo escudo;
	
	public Caballero() {}
	public Caballero(String nombre, int fuerza, int experiencia, String foto, Arma arma, Escudo escudo) {
		this.nombre = nombre;
		this.fuerza = fuerza;
		this.experiencia = experiencia;
		this.foto = foto;
		this.arma = arma;
		this.escudo = escudo;
	}

	public Caballero(int id2, String nombre2, int fuerza2, int experiencia2, Arma arma2, Escudo escudo2) {
		id=id2;
		nombre=nombre2;
		fuerza=fuerza2;
		experiencia=experiencia2;
		arma=arma2;
		escudo=escudo2;
		
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getFuerza() {
		return fuerza;
	}
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	public int getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Arma getArma() {
		return arma;
	}
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	public Escudo getEscudo() {
		return escudo;
	}
	public void setEscudo(Escudo escudo) {
		this.escudo = escudo;
	}
	@Override
	public String toString() {
		return "Caballero [id=" + id + ", nombre=" + nombre + ", fuerza=" + fuerza + ", experiencia=" + experiencia
				+ ", foto=" + foto + ", arma=" + arma+escudo+"]";
	}
	
	
}