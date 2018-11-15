package modelo;

import junit.framework.Assert;
import org.junit.Test;
import unidades.Espadachin;

public class EspadachinTest {

	@Test
	public void test01CreacionDeEspadachin() {

		Oro oro = new Oro(500);
		Espadachin espadachin = new Espadachin(oro);

		Assert.assertEquals(espadachin.getVida(), 100);
	}
	
	@Test 
	public void test02CrearEspadachinCuestaOro() {

		Oro oro = new Oro(500);
		Espadachin espadachin = new Espadachin(oro);

		Assert.assertEquals(oro.getOro(), 450);
	}

	@Test(expected = NoTenesOroSuficienteException.class)
	public void test03CrearEspadachinConOroInsuficiente() {

		Oro oro = new Oro(5);

		Espadachin espadachin = new Espadachin(oro);	
	}

	@Test(expected = PosicionFueraDeRangoException.class)
	public void test04espadachinSeMueveFueraDeRangoYLanzaExcepcion() {

		Oro oro = new Oro(300);
		Espadachin espadachin = new Espadachin(oro);
		Posicion unaPosicion = new Posicion(5, 5);
		Posicion otraPosicion = new Posicion(10, 10);

		espadachin.setPosicion(unaPosicion);

		espadachin.moverHacia(otraPosicion);
	}
	
	

}
