package modelo.edificios;

import modelo.Ataque;
import modelo.Oro;
import modelo.mapa.Mapa;
import modelo.unidades.Colocable;
import modelo.unidades.Unidad;
import modelo.unidades.armadeasedio.ArmaDeAsedio;

import java.util.ArrayList;

public class Castillo extends Edificio {

    Oro oro;
	
    private static final int RANGO_DE_ATAQUE = 5;
	
	public Castillo(Oro oro) {
		this.vidaMaxima = 1000;
		this.vida = 1000;
		this.reparacion = 15;
		this.tamanio = 16;
		this.oro = oro;		
		this.posiciones = new ArrayList<>();
	}	
	
	
	@Override
	public void terminoDeCrearse() {
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
	
	
	
	
	
	public void atacarMapa(Mapa mapa) {
		 ArrayList<Colocable> colocables = buscarColocablesEnRango(mapa);
		 atacarAColocables(colocables);
	}
	
	
	
	private void atacarAColocables(ArrayList<Colocable> colocables) {
		for(Colocable colocable: colocables) {
			colocable.recibirDanio(this);
		}
	}
	
	
	public void atacar(Edificio edificio) {
		edificio.recibirDanio(this);
	}
	public void atacar(Castillo castillo) {
		castillo.recibirDanio(this);
		
	}
	public void atacar(Unidad unidad) {
		unidad.recibirDanio(this);
		
	}

	
	public void recibirDanio(Castillo castillo) {
		//Castillo no recibe daño si lo ataca castillo
	}
	


	
	

	
	

}
