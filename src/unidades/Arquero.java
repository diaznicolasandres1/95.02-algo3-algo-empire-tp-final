package unidades;

import modelo.Oro;

public class Arquero extends Unidad {
	
	public Arquero(Oro oro) {
		vida = 75;
		oro.restarOro(75);
	}

	
}
