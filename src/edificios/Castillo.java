package edificios;

import modelo.Oro;
import unidades.ArmaDeAsedio;

public class Castillo extends Edificio {

	protected Oro oro;
	EstadoCastilloConstruido estado;
	
	public Castillo(Oro oro) {
		vidaMaxima = 1000;
		vida = 1000;
		reparacion = 15;
		tamanio = 8;
		estado = new EstadoCastilloConstruido();
	}	
	
	@Override
	protected void terminoDeCrearse() {
		//Ya empieza construido.
		
	}
	
	public ArmaDeAsedio crearArmaDeAsedio() {
		return estado.crearArmaDeAsedio(oro);
		
	}
	

}
