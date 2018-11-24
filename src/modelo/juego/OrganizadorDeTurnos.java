package modelo.juego;

import java.util.Random;

public class OrganizadorDeTurnos {

	private Jugador JugadorEnTurno;
	private Jugador JugadorEnEspera;
	
	public OrganizadorDeTurnos(Jugador Jugador1, Jugador Jugador2) {
        if (new Random().nextBoolean()) {
			JugadorEnTurno = Jugador1;
			JugadorEnEspera = Jugador2;
        } else {
			JugadorEnTurno = Jugador2;
			JugadorEnEspera = Jugador1;
		}
	}
	
	public Jugador cambiarTurno() {
		JugadorEnTurno.avanzarTurno();
		Jugador aux = JugadorEnTurno;
		JugadorEnTurno = JugadorEnEspera;
		JugadorEnEspera = aux;
		return JugadorEnTurno;
	}
}
