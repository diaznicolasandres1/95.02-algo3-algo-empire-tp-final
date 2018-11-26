package modelo.juego;

import modelo.unidades.Atacante;
import modelo.excepciones.EdificioSeleccionadoNoPerteneceAJugadorException;
import modelo.excepciones.EdificioObjetivoEsPropioException;
import modelo.excepciones.UnidadSeleccionadaNoPerteneceAJugadorException;
import modelo.excepciones.UnidadEstaMuertaException;
import modelo.excepciones.UnidadObjetivoEsPropiaException;
import modelo.edificios.castillo.Castillo;

import modelo.edificios.Edificio;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidades.Unidad;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.armadeasedio.ArmaDeAsedio;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;


public class Jugador {

	private String nombre;
	private Oro oro;
	private Poblacion poblacion;
	private Estructuras estructuras;
	private static final int ALDEANOS_INICIALES = 3;
	private Mapa mapa;
	private Jugador oponente;

	public Jugador(String nombre, Mapa mapa, int castilloFil, int castilloCol, int plazaFil, int plazaCol) {

		this.nombre = nombre;
		this.oro = new Oro(275);
		this.poblacion = new Poblacion();
		this.estructuras = new Estructuras();
		this.mapa = mapa;
		this.colocarCastillo(oro, castilloFil, castilloCol);
		this.colocarPlazaYAldeanos(oro, plazaFil, plazaCol);
	}

	/*-----Inicializadores-----*/

	private void colocarPlazaYAldeanos(Oro oro, int fila, int columna) {
		PlazaCentral plaza = new PlazaCentral(oro);
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.colocarseEn(this.mapa, fila, columna);
		this.estructuras.agregarEdificio(plaza);
		this.crearAldeanosIniciales(oro, plaza);
	}

	private void colocarCastillo(Oro oro, int fila, int columna) {
		Castillo castillo = new Castillo(oro);
		castillo.colocarseEn(this.mapa, fila, columna);
		this.estructuras.agregarEdificio(castillo);
	}

	private void crearAldeanosIniciales(Oro oro, PlazaCentral plaza) {
		for (int i = 0; i < ALDEANOS_INICIALES; i++) {
			Aldeano aldeano = new Aldeano(oro);
			plaza.colocarAlrededor(mapa, aldeano);
			this.poblacion.agregarUnidad(aldeano);
		}
	}

	/*-----Verificadores-----*/

	private void esUnidadPropia(Unidad unidad) {
		if (!this.poblacion.perteneceUnidad(unidad))
			throw new UnidadSeleccionadaNoPerteneceAJugadorException();
	}

	private void esEdificioPropio(Edificio edificio) {
		if (!this.estructuras.perteneceEdificio(edificio))
			throw new EdificioSeleccionadoNoPerteneceAJugadorException();
	}

	/*-----Metodos setters y getters-----*/

	public void setOponente(Jugador oponente) {
		this.oponente = oponente;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getPoblacion() {
		return this.poblacion.getCantidad();
	}

	public int getCantidadDeEdificios() {
		return this.estructuras.getCantidad();
	}

	public int getOro() {
		return this.oro.getOro();
	}

	/*-----Metodos de Edificios-----*/

	public void crearAldeano(PlazaCentral plaza) {
		this.esEdificioPropio(plaza);
		Aldeano aldeano = plaza.crearAldeanoDesdePlaza();
		plaza.colocarAlrededor(mapa, aldeano);
		this.poblacion.agregarUnidad(aldeano);
	}

	public void crearEspadachin(Cuartel cuartel) {
		this.esEdificioPropio(cuartel);
		Espadachin espadachin = cuartel.crearEspadachinDesdeCuartel();
		cuartel.colocarAlrededor(mapa, espadachin);
		this.poblacion.agregarUnidad(espadachin);
	}

	public void crearArquero(Cuartel cuartel) {
		this.esEdificioPropio(cuartel);
		Arquero arquero = cuartel.crearArqueroDesdeCuartel();
		cuartel.colocarAlrededor(mapa, arquero);
		this.poblacion.agregarUnidad(arquero);
	}

	public void crearArmaDeAsedio(Castillo castillo) {
		this.esEdificioPropio(castillo);
		ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio();
		castillo.colocarAlrededor(mapa, armaDeAsedio);
		this.poblacion.agregarUnidad(armaDeAsedio);
	}

	/*-----Metodos de Aldeano-----*/

	public void construirCuartel(Aldeano aldeano, int fila, int columna) {
		this.esUnidadPropia(aldeano);
        Cuartel cuartel = aldeano.construirCuartel();
        cuartel.colocarseEn(this.mapa, fila, columna);
        this.estructuras.agregarEdificio(cuartel);
    }

    public void construirPlazaCentral(Aldeano aldeano, int fila, int columna) {
		this.esUnidadPropia(aldeano);
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        plaza.colocarseEn(this.mapa, fila, columna);
        this.estructuras.agregarEdificio(plaza);
    }
    
    public void repararEdificio(Aldeano aldeano, Edificio edificio) {
		this.esUnidadPropia(aldeano);
		this.esEdificioPropio(edificio);
		aldeano.repararEdificio(edificio);
    }

	/*-----Metodos de Atacante-----*/

	public void atacar(Atacante atacante, Unidad objetivo) {
		this.esUnidadPropia((Unidad) atacante);
		if (this.poblacion.perteneceUnidad(objetivo))
			throw new UnidadObjetivoEsPropiaException();
		try {
			atacante.atacar(objetivo);
		} catch (UnidadEstaMuertaException e) {
			this.oponente.removerUnidad(objetivo);
		}
	}

	public void atacar(Atacante atacante, Edificio objetivo) {
		this.esUnidadPropia((Unidad) atacante);
		if (this.estructuras.perteneceEdificio(objetivo))
			throw new EdificioObjetivoEsPropioException();
		try {
			atacante.atacar(objetivo);
		} catch (UnidadEstaMuertaException e) {
			this.oponente.removerEdificio(objetivo);
		}
	}

	/*-----Metodos de Arma de Asedio-----*/

	public void montarArma(ArmaDeAsedio arma) {
		this.esUnidadPropia(arma);
		arma.montarArma();
	}

	public void desmontarArma(ArmaDeAsedio arma) {
		this.esUnidadPropia(arma);
		arma.desmontarArma();
	}

	/*-----Metodo para pruebas-----*/

	public void agregarUnidadEn(Unidad unidad, int fila, int columna) {
		this.poblacion.agregarUnidad(unidad);
		unidad.colocarseEn(this.mapa, fila, columna);
	}

	public void agregarEdificioEn(Edificio edificio, int fila, int columna) {
		this.estructuras.agregarEdificio(edificio);
		edificio.colocarseEn(this.mapa, fila, columna);
	}

    /*-----Metodos Otros-----*/
    
    public void moverUnidadHacia(Unidad unidad, int fila, int columna) {
		this.esUnidadPropia(unidad);
		Posicion destino = new Posicion(fila, columna);
		unidad.moverHacia(destino, this.mapa);
    }

	public Jugador avanzarTurno() {

		this.estructuras.avanzarTurno();
		this.poblacion.avanzarTurno();
		return this.oponente;
	}

	public void removerUnidad(Unidad unidad) {
		this.poblacion.removerUnidad(unidad);
	}

	public void removerEdificio(Edificio edificio) {
		this.estructuras.removerEdificio(edificio);
	}
}