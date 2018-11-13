package unidades;

import modelo.Oro;

public class EstadoAldeanoDisponible implements EstadoAldeano {
	
	public void recolectarOro(Oro oro) {
		oro.sumarOro(25);
		
	}
	
}


