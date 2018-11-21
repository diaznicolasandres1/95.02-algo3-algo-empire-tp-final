package modelo;

import modelo.edificios.Castillo;
import modelo.edificios.Cuartel;
import modelo.edificios.Edificio;
import modelo.edificios.PlazaCentral;
import modelo.mapa.Mapa;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.armadeasedio.ArmaDeAsedio;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;

import java.util.ArrayList;

public class Civilizacion {

	private Oro oro;
	private Poblacion poblacion;
	private Estructuras estructuras;
	private ArrayList<Edificio> edificios;
	private int aldeanosIniciales = 3;
	private Mapa mapa;

	public Civilizacion(Mapa mapa, int castilloFil, int castilloCol, int plazaFil, int plazaCol) {

		this.oro = new Oro(275);
		this.poblacion = new Poblacion();
		this.estructuras = new Estructuras();
		this.colocarCastillo(oro, castilloFil, castilloCol, mapa);
		this.colocarPlaza(oro, plazaFil, plazaCol, mapa);
		this.crearAldeanosIniciales(oro, plazaFil, plazaCol, mapa);
	}

	public int getPoblacion() {
		return poblacion.getCantidad();
	}

	public int getCantidadDeEdificios() {
		return estructuras.getCantidad();
	}

	public int getOro() {
		return oro.getOro();
	}

	public void crearAldeano(PlazaCentral plaza) {
		Aldeano aldeano = plaza.crearAldeanoDesdePlaza();
		this.poblacion.agregarUnidad(aldeano);
	}
	
	public void crearEspadachin(Cuartel cuartel) {
		Espadachin espadachin = cuartel.crearEspadachinDesdeCuartel();
		this.poblacion.agregarUnidad(espadachin);
	}
	
	public void crearArquero(Cuartel cuartel) {
		Arquero arquero = cuartel.crearArqueroDesdeCuartel();
		this.poblacion.agregarUnidad(arquero);
	}
	
	public void crearArmaDeAsedio(Castillo castillo) {
		ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio();
		this.poblacion.agregarUnidad(armaDeAsedio);
	}

	public void avanzarTurno() {

		this.estructuras.avanzarTurno();
		this.poblacion.avanzarTurno();
	}

	private void colocarPlaza(Oro oro, int fila, int columna, Mapa mapa) {
		PlazaCentral plaza = new PlazaCentral(oro);
		plaza.colocarseEn(mapa, fila, columna);
		this.estructuras.agregarEdificio(plaza);
	}

	private void colocarCastillo(Oro oro, int fila, int columna, Mapa mapa) {
		Castillo castillo = new Castillo(oro);
		castillo.colocarseEn(mapa, fila, columna);
		this.estructuras.agregarEdificio(castillo);
	}

	private void crearAldeanosIniciales(Oro oro, int plazaFil, int plazaCol, Mapa mapa) {

		for (int i = 0; i < aldeanosIniciales; i++) {
			Aldeano aldeano = new Aldeano(oro);
			aldeano.colocarseEn(mapa, plazaFil + 2, plazaCol + i);
			poblacion.agregarUnidad(aldeano);
		}
	}
}

	

