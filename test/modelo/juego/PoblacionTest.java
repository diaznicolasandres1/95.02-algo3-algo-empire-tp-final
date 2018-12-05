package modelo.juego;

import modelo.edificios.plazacentral.PlazaCentral;
import modelo.unidades.aldeano.Aldeano;
import modelo.excepciones.AldeanoEstaOcupadoException;
import modelo.excepciones.LimiteDePoblacionAlcanzadoException;
import org.junit.Assert;
import org.junit.Test;

public class PoblacionTest {

	@Test
	public void test01PoblacionSeCreaSinUnidades() {
		Poblacion poblacion = new Poblacion();
		
		Assert.assertEquals(0, poblacion.getCantidad());
	}

	@Test
	public void test02AgregarUnidadAumentaCantidadDeUnidades() {
		Poblacion poblacion = new Poblacion();
		Oro oro = new Oro(25);
		Aldeano aldeano = new Aldeano(oro);
		poblacion.agregarUnidad(aldeano);
		
		Assert.assertEquals(1, poblacion.getCantidad());
	}

	@Test
	public void test03AgregarUnidadPerteneceAPoblacion() {
		Poblacion poblacion = new Poblacion();
		Oro oro = new Oro(25);
		Aldeano aldeano = new Aldeano(oro);
		poblacion.agregarUnidad(aldeano);
		
		Assert.assertTrue(poblacion.perteneceUnidad(aldeano));
	}
	
	@Test(expected = LimiteDePoblacionAlcanzadoException.class)
	public void test04AgregarUnidadConLimiteDePoblacionAlcanzadoLanzaExcepcion() {
		Poblacion poblacion = new Poblacion();
		for (int i = 0; i <= 50; i++) {
			Oro oro = new Oro(25);
			Aldeano aldeano = new Aldeano(oro);
			poblacion.agregarUnidad(aldeano);
		}
	}

	@Test(expected = AldeanoEstaOcupadoException.class)
	public void test05AvanzarTurnoConAldeanoSigueOcupado() {
		Poblacion poblacion = new Poblacion();
		Oro oro = new Oro(125);
		Aldeano aldeano = new Aldeano(oro);
		poblacion.agregarUnidad(aldeano);
		aldeano.estarOcupado(2);
        poblacion.finalizarTurno();
		PlazaCentral plaza = aldeano.construirPlazaCentral();
	}
	
	@Test
	public void test06AvanzarTurnoConAldeanoSeDesocupa() {
		Poblacion poblacion = new Poblacion();
		Oro oro = new Oro(125);
		Aldeano aldeano = new Aldeano(oro);
		poblacion.agregarUnidad(aldeano);
		aldeano.estarOcupado(1);
        poblacion.finalizarTurno();
        poblacion.finalizarTurno();
		PlazaCentral plaza = aldeano.construirPlazaCentral();
		
		Assert.assertNotNull(plaza);
		
	}

	@Test
	public void test07UnidadRemovidaYaNoPertenece() {
		Poblacion poblacion = new Poblacion();
		Oro oro = new Oro(25);
		Aldeano aldeano = new Aldeano(oro);
		poblacion.agregarUnidad(aldeano);
		poblacion.removerUnidad(aldeano);
		
		Assert.assertFalse(poblacion.perteneceUnidad(aldeano));
	}
	

	
}