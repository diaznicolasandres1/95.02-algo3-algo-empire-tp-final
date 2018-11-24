
package modelo.mapa;

import modelo.juego.Oro;
import modelo.excepciones.CoordenadasInvalidasException;
import modelo.excepciones.RangoInvalidoException;
import modelo.excepciones.CasilleroOcupadoException;
import modelo.unidades.aldeano.Aldeano;
import org.junit.Assert;
import org.junit.Test;

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

    @Test(expected = CasilleroOcupadoException.class)
    public void test11posicionDescolocaUnidadDeMapaYSeColocaDosUnidadesEnElMismoLugarLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Posicion posicion = new Posicion(10, 10);
        Oro oro = new Oro(5000);

        mapa.colocarUnidad(new Aldeano(oro), 10, 10);
        posicion.descolocarColocable(mapa);

        mapa.colocarUnidad(new Aldeano(oro), 10, 10);
        mapa.colocarUnidad(new Aldeano(oro), 10, 10);
    }

    @Test
    public void test12posicionCalculaDistanciaConOtraPosicionDevuelveValorCorrecto() {

        Posicion unaPosicion = new Posicion(1, 1);
        Posicion otraPosicion = new Posicion(6, 6);

        Assert.assertEquals(5, unaPosicion.calcularDistanciaA(otraPosicion));
    }

    @Test
    public void test13posicionCalculaDistanciaConOtraPosicionDevuelveValorCorrecto() {

        Posicion unaPosicion = new Posicion(0, 0);
        Posicion otraPosicion = new Posicion(11, 15);

        Assert.assertEquals(15, unaPosicion.calcularDistanciaA(otraPosicion));
    }
}
