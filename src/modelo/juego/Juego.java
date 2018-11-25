package modelo.juego;

import modelo.unidades.Atacante;
import modelo.unidades.Colocable;
import modelo.edificios.Edificio;
import modelo.edificios.castillo.Castillo;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;
import modelo.unidades.aldeano.Aldeano;

import java.util.Random;

public class Juego {
	private	Jugador jugador;
	private Mapa mapa;
	private static final int BASE_MAPA = 50;
	private static final int ALTURA_MAPA = 50;
	
	public Juego(String nombre1, String nombre2) {
		this.mapa = new Mapa(BASE_MAPA, ALTURA_MAPA);
		Jugador jugador1 = new Jugador(nombre1, this.mapa, 1, 1, 1, 6);
		Jugador jugador2 = new Jugador(nombre2, this.mapa, BASE_MAPA-3, ALTURA_MAPA-3, BASE_MAPA-6, ALTURA_MAPA-1);
		jugador1.setOpenente(jugador2);
		jugador2.setOpenente(jugador1);
		if(new Random().nextBoolean()) {
			this.jugador = jugador1;
		}else {
			this.jugador = jugador2;
		}
	}
	
	/*-----Metodos getter-----*/
	
	public String getNombreJugadorActual() {
		return this.jugador.getNombre();
	}
	
	public Colocable obtenerObjeto(int fila, int columna) {
		return this.mapa.buscarColocableEn(fila, columna);
	}
	
	/*-----Metodos de Edificios-----*/
	
	public void crearAldeano(PlazaCentral plaza) {
		jugador.crearAldeano(plaza);
	}
	
	public void crearEspadachin(Cuartel cuartel) {
		jugador.crearEspadachin(cuartel);
	}
	
	public void crearArquero(Cuartel cuartel) {
		this.jugador.crearArquero(cuartel);
	}
	
	public void crearArmaDeAsedio(Castillo castillo) {
		this.jugador.crearArmaDeAsedio(castillo);
	}
	
/*-----Metodos de Aldeano-----*/
	
	public void construirCuartel(Aldeano aldeano, int fila, int columna) {
		this.jugador.construirCuartel(aldeano, fila, columna);
    }

    public void construirPlazaCentral(Aldeano aldeano, int fila, int columna) {
    	this.jugador.construirPlazaCentral(aldeano, fila, columna);
    }
    
    public void repararEdificio(Aldeano aldeano, Edificio edificio) {
    	this.jugador.repararEdificio(aldeano, edificio);
    }
	
    /*-----Metodos de Atacante-----*/

	public void atacar(Atacante atacante, Unidad objetivo) {
		this.jugador.atacar(atacante, objetivo);
	}

	public void atacar(Atacante atacante, Edificio objetivo) {
		jugador.atacar(atacante, objetivo);
	}
	
	/*-----Metodos Otros-----*/
	
	public void moverUnidadHacia(Unidad unidad, int fila, int columna) {
		this.jugador.moverUnidadHacia(unidad, fila, columna);
	}
	
	public void cambiarTurno() {
		this.jugador = this.jugador.avanzarTurno();
	}

	
}
