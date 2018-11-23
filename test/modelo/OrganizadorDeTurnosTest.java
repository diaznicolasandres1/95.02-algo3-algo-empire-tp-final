package modelo;

import modelo.mapa.Mapa;
import org.junit.Assert;
import org.junit.Test;

public class OrganizadorDeTurnosTest {

	@Test
	public void test01OrganizadorDeTurnosDevuelveUnaDeLasJugadores() {

		Mapa mapa = new Mapa(20, 20);
		Jugador unJugador = new Jugador(mapa, 1, 1, 1, 5);
		Jugador otroJugador = new Jugador(mapa, 1, 10, 1, 14);

		OrganizadorDeTurnos organizador = new OrganizadorDeTurnos(unJugador, otroJugador);
		Jugador jugador = organizador.cambiarTurno();
		Assert.assertTrue(jugador == unJugador || jugador == otroJugador);
	}

	@Test
	public void test02OAvanzarDevuelveLaSiguienteJugador() {

		Mapa mapa = new Mapa(20, 20);
		Jugador unJugador = new Jugador(mapa, 1, 1, 1, 5);
		Jugador otroJugador = new Jugador(mapa, 1, 10, 1, 14);
		OrganizadorDeTurnos organizador = new OrganizadorDeTurnos(unJugador, otroJugador);

		Jugador primerJugador = organizador.cambiarTurno();
		Jugador segundoJugador = organizador.cambiarTurno();

		if (primerJugador == unJugador) {
			Assert.assertEquals(segundoJugador, otroJugador);
		} else {
			Assert.assertEquals(segundoJugador, unJugador);
		}
	}
}
