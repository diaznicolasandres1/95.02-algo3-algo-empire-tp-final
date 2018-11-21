package modelo.edificios;

import modelo.Oro;
import modelo.unidades.armadeasedio.ArmaDeAsedio;

import java.util.ArrayList;

public class Castillo extends Edificio {

    Oro oro;
	EstadoCastilloConstruido estado;
	
	public Castillo(Oro oro) {
		this.vidaMaxima = 1000;
		this.vida = 1000;
		this.reparacion = 15;
		this.tamanio = 16;
		this.oro = oro;
		this.estado = new EstadoCastilloConstruido();
		this.posiciones = new ArrayList<>();
	}	
	
	
	@Override
	protected void terminoDeCrearse() {
		//Ya empieza construido.
		
	}
	
	/*Castillo crea arma de asedio*/
	
	public ArmaDeAsedio crearArmaDeAsedio() {
		ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro) ;
		return armaDeAsedio;	
		
	}
	

}
