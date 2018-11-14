
package modelo;

import org.junit.Test;
import org.junit.Assert;

public class PosicionTest {

    @Test(expected = CoordenadasInvalidasException.class)
    public void test01posicionSeCreaConCoordenadasNegativas() {
        Posicion posicion = new Posicion(-42, -53);
    }

    @Test
    public void test02posicionSeCreaConCoordenadaNula() {

        Posicion posicion = new Posicion(0, 0);

        Assert.assertNotNull(posicion);
    }

	@Test
    public void test03posicionDentroDeRangoDevuelveTrue() {

        Posicion unaPosicion = new Posicion(1, 1);
        Posicion otraPosicion = new Posicion(1, 2);

        Assert.assertTrue(unaPosicion.estaDentroDelRango(otraPosicion, 3));
	}
		
	@Test
    public void test04posicionDentroDeRangoLimiteDevuelveTrue() {

        Posicion unaPosicion = new Posicion(1, 1);
        Posicion otraPosicion = new Posicion(1, 6);

        Assert.assertTrue(unaPosicion.estaDentroDelRango(otraPosicion, 5));
	}
	
	@Test
    public void test05posicionFueraDeRangoDevuelveFalse() {

        Posicion unaPosicion = new Posicion(1, 1);
        Posicion otraPosicion = new Posicion(1, 7);

        Assert.assertFalse(unaPosicion.estaDentroDelRango(otraPosicion, 5));
	}
	
	@Test
    public void test06posicionDentroDeRangoMenorDevuelveFalse() {

        Posicion unaPosicion = new Posicion(1, 1);
        Posicion otraPosicion = new Posicion(1, 6);

        Assert.assertFalse(unaPosicion.estaDentroDelRango(otraPosicion, 4));
	}
	
	@Test
    public void test07posicionDentroDeRangoDiagonalDevuelveTrue() {
        Posicion unaPosicion = new Posicion(1, 1);
        Posicion otraPosicion = new Posicion(6, 6);
        Assert.assertTrue(unaPosicion.estaDentroDelRango(otraPosicion, 5));
	}
	
	@Test
    public void test08posicionFueraDeRangoDiagonalDevuelveFalse() {

        Posicion unaPosicion = new Posicion(1, 1);
        Posicion otraPosicion = new Posicion(7, 7);

        Assert.assertFalse(unaPosicion.estaDentroDelRango(otraPosicion, 5));
    }

    @Test(expected = RangoInvalidoException.class)
    public void test09posicionSeComparaConRangoNegativoLanzaExcepcion() {

        Posicion unaPosicion = new Posicion(10, 100);
        Posicion otraPosicion = new Posicion(15, 49);

        unaPosicion.estaDentroDelRango(otraPosicion, -13);
    }

    @Test(expected = RangoInvalidoException.class)
    public void test10posicionSeComparaConRangoNuloLanzaExcepcion() {

        Posicion unaPosicion = new Posicion(140, 100);
        Posicion otraPosicion = new Posicion(56, 49);

        unaPosicion.estaDentroDelRango(otraPosicion, 0);
    }
}
