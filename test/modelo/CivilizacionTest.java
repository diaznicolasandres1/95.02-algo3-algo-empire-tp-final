import org.junit.Test;
import org.junit.Assert;

import modelo.Civilizacion;
import modelo.mapa.Mapa;
import edificios.PlazaCentral;
import modelo.LimiteDePoblacionAlcanzadoException;

public class CivilizacionTest {
	Mapa mapa = new Mapa(15, 15);
	Civilizacion civilizacion = new Civilizacion(mapa);

	@Test
	public void test01OroInicialEs100() {
		Assert.assertEquals(100, civilizacion.cantidadDeOro());
	}

	@Test
	public void test02CantidadDeUnidadesInicialEs3() {
		Assert.assertEquals(3, civilizacion.cantidadDeUnidades());
	}

	@Test
	public void test03CantidadDeEdificiosIinicialEs2() {
		Assert.assertEquals(2, civilizacion.cantidadDeEdificios());
	}

/*	@Test
	public void test04CrearUnidadConLimiteDePoblacionAlcanzado() {
		for(int i=0, i<50, i++) {
			PlazaCentral plaza = new PlazaCentral();
			civilizacion.crearAldeanoDesdePlaza(plaza);
		}
		
	}
	
	@Test
	public void test04CrearAldeanoDesdePlazaAumentaUnidades() {
		PlazaCentral plaza = new PlazaCentral();
		civilizacion.crearAldeanoDesdePlaza(plaza);
		Assert.assertEquals(3, civilizacion.cantidadDeUnidades());
	}

	@Test
	public void testCrearEspadachin() {
		fail("Not yet implemented");
	}

	@Test
	public void testCrearArquero() {
		fail("Not yet implemented");
	}

	@Test
	public void testCrearArmaDeAsedio() {
		fail("Not yet implemented");
	}

	@Test
	public void testAvanzarTurnoCivilizacion() {
		
	}
	*/

}
