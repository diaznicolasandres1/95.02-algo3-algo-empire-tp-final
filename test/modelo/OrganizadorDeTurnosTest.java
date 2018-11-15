package modelo;

import org.junit.Test;
import org.junit.Assert;

import modelo.mapa.Mapa;
import modelo.Civilizacion;
import modelo.OrganizadorDeTurnos;

public class OrganizadorDeTurnosTest {


	Mapa mapa = new Mapa(15, 15);
	Civilizacion civ1 = new Civilizacion(mapa);
	Civilizacion civ2 = new Civilizacion(mapa);
	


	@Test
	public void test01OrganizadorDeTurnosDevuelveUnaDeLasCivilizaciones() {
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civ1 = new Civilizacion(mapa);
		Civilizacion civ2 = new Civilizacion(mapa);
		OrganizadorDeTurnos organizador = new OrganizadorDeTurnos(civ1, civ2);
		Civilizacion civilizacion = organizador.cambiarTurno();
		Assert.assertTrue(civilizacion == civ1 || civilizacion == civ2);
	}

	@Test
	public void test02OAvanzarDevuelveLaSiguienteCivilizacion() {
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civ1 = new Civilizacion(mapa);
		Civilizacion civ2 = new Civilizacion(mapa);
		OrganizadorDeTurnos organizador = new OrganizadorDeTurnos(civ1, civ2);
		Civilizacion primerCiv = organizador.cambiarTurno();
		Civilizacion segundoCiv = organizador.cambiarTurno();
		if(primerCiv == civ1)
			Assert.assertEquals(segundoCiv, civ2);
		else
			Assert.assertEquals(segundoCiv, civ1);
		
	}
	
}
