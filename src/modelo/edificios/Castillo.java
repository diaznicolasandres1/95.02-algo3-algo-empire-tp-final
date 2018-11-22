package modelo.edificios;

import modelo.Oro;
import modelo.mapa.Mapa;
import modelo.unidades.Colocable;
import modelo.unidades.armadeasedio.ArmaDeAsedio;

import java.util.ArrayList;

public class Castillo extends Edificio {

    Oro oro;
	EstadoCastilloConstruido estado;
    private static final int RANGO_DE_ATAQUE = 5;
	
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

    private ArrayList<Colocable> buscarColocablesEnRango(Mapa mapa) {
        return this.posiciones.get(0).buscarColocablesEnRangoDe(mapa, Castillo.RANGO_DE_ATAQUE);
    }
	
	/*Castillo crea arma de asedio*/
	
	public ArmaDeAsedio crearArmaDeAsedio() {
		ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro) ;
		return armaDeAsedio;	
		
	}
	

}
