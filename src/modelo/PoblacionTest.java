package modelo;

import modelo.Poblacion;
import modelo.unidades.aldeano.Aldeano;
import modelo.edificios.PlazaCentral;
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
		
		Assert.assertTrue(poblacion.PerteneceUnidad(aldeano));
	}
	
	@Test(expected = LimiteDePoblacionAlcanzadoException.class)
	public void test05AgregarUnidadConLimiteDePoblacionAlcanzadoLanzaExcepcion() {
		Poblacion poblacion = new Poblacion();
		for (int i = 0; i < 50; i++) {
			Oro oro = new Oro(25);
			Aldeano aldeano = new Aldeano(oro);
			poblacion.agregarUnidad(aldeano);
		}
	}

	@Test
	public void test4AvanzarTurno() {
	}

}
