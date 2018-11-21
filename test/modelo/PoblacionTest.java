package modelo;

import modelo.Poblacion;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.aldeano.AldeanoEstaOcupadoException;
import modelo.edificios.PlazaCentral;
import modelo.Oro;
import modelo.LimiteDePoblacionAlcanzadoException;
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
		poblacion.avanzarTurno();
		PlazaCentral plaza = aldeano.construirPlazaCentral();
	}
	
	@Test
	public void test06AvanzarTurnoConAldeanoSeDesocupa() {
		Poblacion poblacion = new Poblacion();
		Oro oro = new Oro(125);
		Aldeano aldeano = new Aldeano(oro);
		poblacion.agregarUnidad(aldeano);
		aldeano.estarOcupado(1);
		poblacion.avanzarTurno();
		poblacion.avanzarTurno();
		PlazaCentral plaza = aldeano.construirPlazaCentral();
		
		Assert.assertNotNull(plaza);
		
	}
	
	@Test
	public void test07AvanzarTurnoBorraUnidadesEliminadas() {
		Poblacion poblacion = new Poblacion();
		Oro oro = new Oro(25);
		Aldeano aldeano = new Aldeano(oro);
		poblacion.agregarUnidad(aldeano);
		aldeano.recibirDanio(50);
		poblacion.avanzarTurno();
		
		Assert.assertEquals(0, poblacion.getCantidad());
	}
	
	@Test
	public void test08AvanzarTurnoBorraSoloUnidadesEliminadas() {
		Poblacion poblacion = new Poblacion();
		Oro oro = new Oro(50);
		Aldeano aldeano1 = new Aldeano(oro);
		Aldeano aldeano2 = new Aldeano(oro);
		poblacion.agregarUnidad(aldeano1);
		poblacion.agregarUnidad(aldeano2);
		aldeano2.recibirDanio(50);
		poblacion.avanzarTurno();
		
		Assert.assertEquals(1, poblacion.getCantidad());
	}
	
}