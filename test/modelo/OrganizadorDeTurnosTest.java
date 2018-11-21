package modelo;

import modelo.mapa.Mapa;
import org.junit.Assert;
import org.junit.Test;

public class OrganizadorDeTurnosTest {

	@Test
	public void test01OrganizadorDeTurnosDevuelveUnaDeLasCivilizaciones() {

		Mapa mapa = new Mapa(20, 20);
		Civilizacion unaCiv = new Civilizacion(mapa, 1, 1, 1, 5);
		Civilizacion otraCiv = new Civilizacion(mapa, 1, 10, 1, 14);

		OrganizadorDeTurnos organizador = new OrganizadorDeTurnos(unaCiv, otraCiv);
		Civilizacion civilizacion = organizador.cambiarTurno();
		Assert.assertTrue(civilizacion == unaCiv || civilizacion == otraCiv);
	}

	@Test
	public void test02OAvanzarDevuelveLaSiguienteCivilizacion() {

		Mapa mapa = new Mapa(20, 20);
		Civilizacion unaCiv = new Civilizacion(mapa, 1, 1, 1, 5);
		Civilizacion otraCiv = new Civilizacion(mapa, 1, 10, 1, 14);
		OrganizadorDeTurnos organizador = new OrganizadorDeTurnos(unaCiv, otraCiv);

		Civilizacion primerCiv = organizador.cambiarTurno();
		Civilizacion segundoCiv = organizador.cambiarTurno();

		if (primerCiv == unaCiv) {
			Assert.assertEquals(segundoCiv, otraCiv);
		} else {
			Assert.assertEquals(segundoCiv, unaCiv);
		}
	}
}
