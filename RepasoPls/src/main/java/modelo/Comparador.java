package modelo;

import java.util.Comparator;

public class Comparador implements Comparator<Caballero>{

	@Override
	public int compare(Caballero o1, Caballero o2) {
		return o1.getNombre().toLowerCase().compareTo(o2.getNombre().toLowerCase());
	}

}
