package modelo;

import modelo.edificios.Castillo;
import modelo.edificios.Cuartel;
import modelo.edificios.PlazaCentral;
import modelo.mapa.Mapa;
import org.junit.Assert;
import org.junit.Test;

public class CivilizacionTest {

	@Test
	public void test01OroInicialEs100() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);

		Assert.assertEquals(100, civilizacion.getOro());
	}

	@Test
	public void test02CantidadDeUnidadesInicialEs3() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);

		Assert.assertEquals(3, civilizacion.getPoblacion());
	}

	@Test
	public void test03CantidadDeEdificiosInicialEs2() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);

		Assert.assertEquals(2, civilizacion.getCantidadDeEdificios());
	}

	@Test(expected = LimiteDePoblacionAlcanzadoException.class)
	public void test04CrearUnidadConLimiteDePoblacionAlcanzadoLanzaExcepcion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		PlazaCentral plaza = new PlazaCentral(oro);
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.avanzarTurno();

		for (int i = 0; i < 50; i++) {
			civilizacion.crearAldeano(plaza);
		}
	}
	
	@Test
	public void test04CrearAldeanoDesdePlazaAumentaPoblacion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		PlazaCentral plaza = new PlazaCentral(oro);
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.avanzarTurno();

		civilizacion.crearAldeano(plaza);

		Assert.assertEquals(4, civilizacion.getPoblacion());
	}

	@Test
	public void test05CrearEspadachinDesdeCuartelAumentaPoblacion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		Cuartel cuartel = new Cuartel(oro);
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();

		civilizacion.crearEspadachin(cuartel);

		Assert.assertEquals(4, civilizacion.getPoblacion());
	}

	@Test
	public void test06CrearArqueroDesdeCuartelAumentaPoblacion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		Cuartel cuartel = new Cuartel(oro);
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();

		civilizacion.crearArquero(cuartel);

		Assert.assertEquals(4, civilizacion.getPoblacion());
	}

	@Test
	public void testCrearArmaDeAsedioDesdeCastilloAumentaPoblacion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		Castillo castillo = new Castillo(oro);

		civilizacion.crearArmaDeAsedio(castillo);

		Assert.assertEquals(4, civilizacion.getPoblacion());

	}

	@Test
	public void testAvanzarTurnoCivilizacion() {
		
	}

}
