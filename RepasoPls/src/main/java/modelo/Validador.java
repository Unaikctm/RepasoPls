package modelo;

import java.util.ArrayList;

public class Validador {
	
	public static boolean stringVacio(String name) {
		if(name=="" || name==null) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean ceroYcien(int num) {
		if(num>0 && num<=100) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean nombreRepetido(String name) {	
		boolean respuesta=false;
		
		ModeloCaballero mc = new ModeloCaballero();
		mc.setConector(new Conector());
		ArrayList<Caballero> caballeros = mc.getCaballeros();
		
		for (Caballero caballero : caballeros) {
			if(caballero.getNombre().equalsIgnoreCase(name)) {
				respuesta= true;
			}
		}
		
		return respuesta;
	}
	
	public static boolean armaescudoVacio(int id) {	
		if(id==0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean algunFallo(String nombre, int fuerza, int exp, String cabname, int idA, int idE) {
		if(stringVacio(nombre)==false && ceroYcien(fuerza) ==true
				&& ceroYcien(exp)==true && nombreRepetido(cabname) ==false
				&& armaescudoVacio(idA) ==false
				&& armaescudoVacio(idE) ==false){
			return false;
		}else return true;
	}
}