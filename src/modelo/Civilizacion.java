package modelo;

import modelo.edificios.Edificio;
import modelo.edificios.PlazaCentral;
import modelo.edificios.Castillo;
import modelo.edificios.Cuartel;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.armadeasedio.ArmaDeAsedio;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;

import java.util.ArrayList;

public class Civilizacion {

	private Oro oro;
	private ArrayList<Unidad> unidades;
	private ArrayList<Edificio> edificios;
	private int limitePoblacion = 50;
	private int aldeanosIniciales = 3;
	private Mapa mapa;

	public Civilizacion(Mapa mapa, int castilloFil, int castilloCol, int plazaFil, int plazaCol) {

		this.oro = new Oro(275);
		this.unidades = new ArrayList<>();
		this.edificios = new ArrayList<>();
		this.colocarCastillo(oro, castilloFil, castilloCol, mapa);
		this.colocarPlaza(oro, plazaFil, plazaCol, mapa);
		this.crearAldeanosIniciales(oro, plazaFil, plazaCol, mapa);
	}

	public int getPoblacion() {
		return unidades.size();
	}

	public int getCantidadDeEdificios() {
		return edificios.size();
	}

	public int getOro() {
		return oro.getOro();
	}

	public void crearAldeano(PlazaCentral plaza) {

		if (this.verificarLimitePoblacion())
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

	public void avanzarTurno() {

		for (Edificio edificio : edificios) {
			edificio.avanzarTurno();
		}
		for (Unidad unidad : unidades) {
			unidad.avanzarTurno();
		}
	}

	private boolean verificarLimitePoblacion() {
		return unidades.size() >= limitePoblacion;
	}

	private void colocarPlaza(Oro oro, int fila, int columna, Mapa mapa) {
		PlazaCentral plaza = new PlazaCentral(oro);
		plaza.colocarseEn(mapa, fila, columna);
		this.edificios.add(plaza);
	}

	private void colocarCastillo(Oro oro, int fila, int columna, Mapa mapa) {
		Castillo castillo = new Castillo(oro);
		castillo.colocarseEn(mapa, fila, columna);
		this.edificios.add(castillo);
	}

	private void crearAldeanosIniciales(Oro oro, int plazaFil, int plazaCol, Mapa mapa) {

		for (int i = 0; i < aldeanosIniciales; i++) {
			Aldeano aldeano = new Aldeano(oro);
			aldeano.colocarseEn(mapa, plazaFil + 2, plazaCol + i);
			unidades.add(aldeano);
		}
	}
}

	

