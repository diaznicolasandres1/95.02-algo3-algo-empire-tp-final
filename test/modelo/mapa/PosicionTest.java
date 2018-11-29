
package modelo.mapa;

import modelo.excepciones.DistanciaInvalidaException;
import modelo.excepciones.PosicionFueraDeRangoException;
import modelo.juego.Oro;
import modelo.excepciones.CoordenadasInvalidasException;
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

    @Test(expected = CasilleroOcupadoException.class)
    public void test03posicionMueveUnidadHaciaOtraPosicionSeIntentaColocarUnidadEnPosicionDeDestinoLanzaExcepcion() {

        Oro oro = new Oro(1000);
        Mapa mapa = new Mapa(20, 20);
        Aldeano aldeano = new Aldeano(oro);
        Posicion origen = new Posicion(10, 10);
        Posicion destino = new Posicion(11, 11);

        mapa.colocarUnidad(aldeano, 10, 10);
        aldeano.setPosicion(origen);
        origen.moverUnidadHacia(aldeano, mapa, destino, 1);

        mapa.colocarUnidad(new Aldeano(oro), 11, 11);
    }

    @Test(expected = PosicionFueraDeRangoException.class)
    public void test04posicionIntentaMoverUnidadHaciaOtraPosicionFueraDeDistanciaMaximaLanzaExcepcion() {

        Oro oro = new Oro(1000);
        Mapa mapa = new Mapa(20, 20);
        Aldeano aldeano = new Aldeano(oro);
        Posicion origen = new Posicion(10, 10);
        Posicion destino = new Posicion(14, 14);

        mapa.colocarUnidad(aldeano, 10, 10);
        aldeano.setPosicion(origen);

        origen.moverUnidadHacia(aldeano, mapa, destino, 1);
    }

    @Test(expected = DistanciaInvalidaException.class)
    public void test05posicionIntentaMoverUnidadHaciaOtraPosicionConDistanciaNegativaLanzaExcepcion() {

        Oro oro = new Oro(1000);
        Mapa mapa = new Mapa(20, 20);
        Aldeano aldeano = new Aldeano(oro);
        Posicion origen = new Posicion(10, 10);
        Posicion destino = new Posicion(14, 14);

        mapa.colocarUnidad(aldeano, 10, 10);
        aldeano.setPosicion(origen);

        origen.moverUnidadHacia(aldeano, mapa, destino, -1);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test06posicionDescolocaUnidadDeMapaYSeColocaDosUnidadesEnElMismoLugarLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Posicion posicion = new Posicion(10, 10);
        Oro oro = new Oro(5000);

        mapa.colocarUnidad(new Aldeano(oro), 10, 10);
        posicion.descolocarColocable(mapa);

        mapa.colocarUnidad(new Aldeano(oro), 10, 10);
        mapa.colocarUnidad(new Aldeano(oro), 10, 10);
    }

    @Test
    public void test07posicionCalculaDistanciaConOtraPosicionDevuelveValorCorrecto() {

        Posicion unaPosicion = new Posicion(1, 1);
        Posicion otraPosicion = new Posicion(6, 6);

        Assert.assertEquals(5, unaPosicion.calcularDistanciaA(otraPosicion));
    }

    @Test
    public void test08posicionCalculaDistanciaConOtraPosicionDevuelveValorCorrecto() {

        Posicion unaPosicion = new Posicion(0, 0);
        Posicion otraPosicion = new Posicion(11, 15);

        Assert.assertEquals(15, unaPosicion.calcularDistanciaA(otraPosicion));
    }

    @Test
    public void test09posicionBuscaColocoblesEnRango1DentroDeMapaYDevuelveColocablesCorrectos() {

        Oro oro = new Oro(1000);
        Mapa mapa = new Mapa(20, 20);
        Aldeano aldeano = new Aldeano(oro);
        Posicion posicion = new Posicion(10, 10);

        mapa.colocarUnidad(aldeano, 11, 11);
        posicion.buscarColocablesEnRangoDe(mapa, 1);

        Assert.assertTrue(posicion.buscarColocablesEnRangoDe(mapa, 1).contains(aldeano));
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test10posicionColocaUnidadAlrededorDeOtraUnidadEnLaPrimeraPosicionLibre() {

        Oro oro = new Oro(1000);
        Mapa mapa = new Mapa(20, 20);
        Aldeano aldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);
        Posicion posicion = new Posicion(10, 10);

        mapa.colocarUnidad(aldeano, 10, 10);
        posicion.colocarAlrededor(mapa, 1, otroAldeano);

        mapa.colocarUnidad(new Aldeano(oro), 9, 9);
    }
}
