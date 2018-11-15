package modelo;

import edificios.Edificio;
import edificios.PlazaCentral;
import modelo.mapa.Casillero;
import modelo.mapa.Mapa;
import unidades.Unidad;

import java.util.ArrayList;

public class Civilizacion {
	
	Oro oro;
	ArrayList<Unidad> unidades;
	ArrayList<Edificio> edificios;
	int limitePoblacion = 50;
	int aldeanosIniciales = 3;
	Mapa mapa;
	

	public Civilizacion(Mapa mapa, int posCastilloX, int posCastilloY) {
		oro = new Oro(100);
		unidades = new ArrayList<>();
		edificios = new ArrayList<>();
/*		PlazaCentral plaza = new PlazaCentral(oro);
		plaza.colocarseEn(mapa, posCastilloX, posCastilloY);
		
		for(int i=0; i<aldeanosIniciales; i++){
			Unidad unidad = plaza.crearAldeanoDesdePlaza();
			Casillero casillero = plaza.casilleroAlrededorDisponible(); falta implementar
			casillero.colocar(unidad);
			unidades.add(unidad);
		}*/
	}
	
	public void avanzarTurnoCivilizacion(){
		for(Edificio edificio: edificios){
			edificio.avanzarTurno();
		}
		for(Unidad unidad: unidades){
			unidad.avanzarTurno();
		}
	}
}

	

