package modelo;

import edificios.Edificio;
import unidades.Unidad;

import java.util.ArrayList;

public class Civilizacion {
	
	Oro oro;
	ArrayList<Unidad> unidades;
	ArrayList<Edificio> edificios;
	int limitePoblacion = 50;
	int aldeanosIniciales = 3;
	
}
	
	/*
	public Civilizacion(int PosCastilloX, int PosCastilloY) {
		oro = new Oro(100);
		unidades = new ArrayList<>();
		PlazaCentral plaza = new PlazaCentral(oro);
		plaza.colocarseEn(mapa, 1, 1);
		
		for(int i=0; i<aldeanosIniciales; i++){
			Unidad unidad = plaza.crearAldeanoDesdePlaza();
			Casillero casillero = plaza.casilleroAlrededorDisponible(); //falta implementar
			casillero.colocar(Colocable colocable);
			unidades.add(unidad);
		}
	}
	
	public avanzarTurnoCivilizacion(){
		for(Edificio edificio: edificios){
			edificio.avanzarTurno();
		}
		for(Unidad unidad: unidades){
			unidad.avanzarTurno();
		}
	}
}
	*/

	

