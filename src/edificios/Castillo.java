package edificios;

import modelo.Oro;
import unidades.ArmaDeAsedio;

public class Castillo extends Edificio {

	 Oro oro;
	EstadoCastilloConstruido estado;
	
	public Castillo(Oro oro) {
		vidaMaxima = 1000;
		vida = 1000;
		reparacion = 15;
		tamanio = 8;
		this.oro = oro;
		estado = new EstadoCastilloConstruido();
	}	
	
	@Override
	protected void terminoDeCrearse() {
		//Ya empieza construido.
		
	}
	
	public ArmaDeAsedio crearArmaDeAsedio() {
		ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro) ;
		return armaDeAsedio;	
		
	}
	

}
