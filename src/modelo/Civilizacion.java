package modelo;

import modelo.edificios.Edificio;
import modelo.edificios.PlazaCentral;
import modelo.edificios.Castillo;
import modelo.edificios.Cuartel;
import modelo.mapa.Mapa;
import modelo.unidades.Aldeano;
import modelo.unidades.Unidad;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.Espadachin;
import modelo.unidades.ArmaDeAsedio;

import java.util.ArrayList;

public class Civilizacion {
	
	Oro oro;
	ArrayList<Unidad> unidades;
	ArrayList<Edificio> edificios;
	int limitePoblacion = 50;
	int aldeanosIniciales = 3;
	Mapa mapa;
	

	public Civilizacion(Mapa mapa /*, int castilloFil, int castilloCol, int plazaFil, int plazaCol */ ) {
		oro = new Oro(275);
		unidades = new ArrayList<>();
		edificios = new ArrayList<>();
		PlazaCentral plaza = new PlazaCentral(oro);
	//	plaza.colocarseEn(mapa, plazaFil, plazaCol);
		Castillo castillo = new Castillo(oro);
	//	castillo.colocarseEn(mapa, castilloFil, castilloCol);
		edificios.add(plaza);
		edificios.add(castillo);
		
		for(int i=0; i<aldeanosIniciales; i++){
			Aldeano aldeano = new Aldeano(oro);
	//		aldeano.colocarseEn(mapa, posCastillo, columna);
			unidades.add(aldeano);
		}
	}
	
	public int cantidadDeUnidades() {
		return unidades.size();
	}
	
	public int cantidadDeEdificios() {
		return edificios.size();
	}
	
	public int cantidadDeOro() {
		return oro.getOro();
	}
	
	private boolean verificarLimitePoblacion() {
		return unidades.size() >= limitePoblacion;
	}
	
	public void crearAldeanoDesdePlaza(PlazaCentral plaza) {
		if(this.verificarLimitePoblacion())
			throw new LimiteDePoblacionAlcanzadoException();
		Aldeano aldeano = plaza.crearAldeanoDesdePlaza();
		unidades.add(aldeano);
	}
	
	public void crearEspadachin(Cuartel cuartel) {
		Espadachin espadachin = cuartel.crearEspadachinDesdeCuartel();
		unidades.add(espadachin);
	}
	
	public void crearArquero(Cuartel cuartel) {
		Arquero arquero = cuartel.crearArqueroDesdeCuartel();
		unidades.add(arquero);
	}
	
	public void crearArmaDeAsedio(Castillo castillo) {
		ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio();
		unidades.add(armaDeAsedio);
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

	

