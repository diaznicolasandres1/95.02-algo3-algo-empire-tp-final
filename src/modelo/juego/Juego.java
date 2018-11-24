package modelo.juego;

import modelo.unidades.Atacante;
import modelo.edificios.Edificio;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;
import modelo.excepciones.UnidadEstaMuertaException;

import java.util.Random;

public class Juego {
	private	Jugador jugador;
	private Jugador oponente;
	private Mapa mapa;
	private int baseMapa = 50;
	private int alturaMapa = 50;
	
	public Juego() {
		this.mapa = new Mapa(baseMapa, alturaMapa);
		Jugador jugador1 = new Jugador(this.mapa, 1, 1, 1, 6);
		Jugador jugador2 = new Jugador(this.mapa, this.baseMapa-3, this.alturaMapa-3, this.baseMapa-6, this.alturaMapa-1);
		if(new Random().nextBoolean()) {
			this.jugador = jugador1;
			this.oponente = jugador2;
		}else {
			this.jugador = jugador2;
			this.oponente = jugador1;
		}
	}
	
	public void cambiarTurno() {
		this.jugador.avanzarTurno();
		Jugador aux = this.jugador;
		this.jugador = this.oponente;
		this.oponente = aux;
	}

	public void atacar(Atacante atacante, Unidad objetivo) {
		try {
			jugador.atacar(atacante, objetivo);
		} catch(UnidadEstaMuertaException e) {
			oponente.removerUnidad(objetivo);
		}
	}

	public void atacar(Atacante atacante, Edificio objetivo) {
		try {
			jugador.atacar(atacante, objetivo);
		} catch(UnidadEstaMuertaException e) {
			oponente.removerEdificio(objetivo);
		}
	}

	
}
