package modelo;

import modelo.Ataque;
import modelo.EdificioElegidoNoEsAliadoException;
import modelo.EdificioObjetivoEsAliadoException;
import modelo.Estructuras;
import modelo.Oro;
import modelo.Poblacion;
import modelo.Posicion;
import modelo.UnidadElegidaNoEsAliadaException;
import modelo.UnidadObjetivoEsAliadaException;
import modelo.edificios.Castillo;
import modelo.edificios.Edificio;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.armadeasedio.ArmaDeAsedio;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;


public class Jugador {

	private Oro oro;
	private Poblacion poblacion;
	private Estructuras estructuras;
	private int aldeanosIniciales = 3;
	private Mapa mapa;

	public Jugador(Mapa mapa, int castilloFil, int castilloCol, int plazaFil, int plazaCol) {

		this.oro = new Oro(275);
		this.poblacion = new Poblacion();
		this.estructuras = new Estructuras();
		this.mapa = mapa;
		this.colocarCastillo(oro, castilloFil, castilloCol);
		this.colocarPlaza(oro, plazaFil, plazaCol);
		this.crearAldeanosIniciales(oro, plazaFil, plazaCol);
	}

	/*-----Inicializadores-----*/
	
	private void colocarPlaza(Oro oro, int fila, int columna) {
		PlazaCentral plaza = new PlazaCentral(oro);
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.colocarseEn(this.mapa, fila, columna);
		this.estructuras.agregarEdificio(plaza);
	}

	private void colocarCastillo(Oro oro, int fila, int columna) {
		Castillo castillo = new Castillo(oro);
		castillo.colocarseEn(this.mapa, fila, columna);
		this.estructuras.agregarEdificio(castillo);
	}

	private void crearAldeanosIniciales(Oro oro, int plazaFil, int plazaCol) {

		for (int i = 0; i < aldeanosIniciales; i++) {
			Aldeano aldeano = new Aldeano(oro);
			aldeano.colocarseEn(this.mapa, plazaFil + 2, plazaCol + i);
			poblacion.agregarUnidad(aldeano);
		}
	}
	
	/*-----Verificadores-----*/
	
	private void verificarUnidadEsAliada(Unidad unidad) {
		if(!this.poblacion.perteneceUnidad(unidad))
			throw new UnidadElegidaNoEsAliadaException();
	}
	
	private void verificarEdificioEsAliado(Edificio edificio) {
		if(!this.estructuras.perteneceEdificio(edificio))
			throw new EdificioElegidoNoEsAliadoException();
	}
	
	/*-----Metodos getters-----*/
	
	public int getPoblacion() {
		return poblacion.getCantidad();
	}

	public int getCantidadDeEdificios() {
		return estructuras.getCantidad();
	}

	public int getOro() {
		return oro.getOro();
	}

	/*-----Metodos de Edificios-----*/
	// Aun no se colocan, falta implementar buscador de casilleros disponibles
	
	public void crearAldeano(PlazaCentral plaza) {
		this.verificarEdificioEsAliado(plaza);
		Aldeano aldeano = plaza.crearAldeanoDesdePlaza();
		//aldeano.colocarseEn(this.mapa, fila, columna);
		this.poblacion.agregarUnidad(aldeano);
	}
	
	public void crearEspadachin(Cuartel cuartel) {
		this.verificarEdificioEsAliado(cuartel);
		Espadachin espadachin = cuartel.crearEspadachinDesdeCuartel();
		//espadachin.colocarseEn(this.mapa, fila, columna);
		this.poblacion.agregarUnidad(espadachin);
	}
	
	public void crearArquero(Cuartel cuartel) {
		this.verificarEdificioEsAliado(cuartel);
		Arquero arquero = cuartel.crearArqueroDesdeCuartel();
		//arquero.colocarseEn(this.mapa, fila, columna);
		this.poblacion.agregarUnidad(arquero);
	}
	
	public void crearArmaDeAsedio(Castillo castillo) {
		this.verificarEdificioEsAliado(castillo);
		ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio();
		//armaDeAsedio.colocarseEn(this.mapa, fila, columna);
		this.poblacion.agregarUnidad(armaDeAsedio);
	}
	
	/*-----Metodos de Aldeano-----*/
	
	public void construirCuartel(Aldeano aldeano, int fila, int columna) {
		this.verificarUnidadEsAliada(aldeano);
        Cuartel cuartel = aldeano.construirCuartel();
        cuartel.colocarseEn(this.mapa, fila, columna);
        this.estructuras.agregarEdificio(cuartel);
    }

    public void construirPlazaCentral(Aldeano aldeano, int fila, int columna) {
    	this.verificarUnidadEsAliada(aldeano);
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        plaza.colocarseEn(this.mapa, fila, columna);
        this.estructuras.agregarEdificio(plaza);
    }
    
    public void repararEdificio(Aldeano aldeano, Edificio edificio) {
    	this.verificarUnidadEsAliada(aldeano);
    	this.verificarEdificioEsAliado(edificio);
    	aldeano.aldeanoRepararEdificio(edificio);
    }
    
	/*-----Metodos de Ataque-----*/
		
	public void atacar(Ataque atacante, Unidad objetivo) {
		this.verificarUnidadEsAliada((Unidad) atacante);
		if(this.poblacion.perteneceUnidad(objetivo))
			throw new UnidadObjetivoEsAliadaException();
		atacante.atacar(objetivo);
	}
	
	public void atacar(Ataque atacante, Edificio objetivo) {
		this.verificarUnidadEsAliada((Unidad) atacante);
		if(this.estructuras.perteneceEdificio(objetivo))
			throw new EdificioObjetivoEsAliadoException();
		atacante.atacar(objetivo);
	}
	
	/*-----Metodos de Arma de Asedio-----*/
	
	public void montarArma(ArmaDeAsedio arma) {
		this.verificarUnidadEsAliada(arma);
		arma.montarArma();
	}
    
	public void desmontarArma(ArmaDeAsedio arma) {
		this.verificarUnidadEsAliada(arma);
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
    	this.verificarUnidadEsAliada(unidad);
    	Posicion destino = new Posicion(fila,columna);
    	unidad.moverHacia(destino, this.mapa);
    }

	public void avanzarTurno() {

		this.estructuras.avanzarTurno();
		this.poblacion.avanzarTurno();
	}

	public void removerUnidad(Unidad unidad) {
		this.poblacion.removerUnidad(unidad);
	}
	
	public void removerEdificio(Edificio edificio) {
		this.estructuras.removerEdificio(edificio);
	}
	
}