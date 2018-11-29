package modelo.edificios;

import junit.framework.Assert;
import modelo.excepciones.*;
import modelo.juego.Oro;
import modelo.edificios.cuartel.Cuartel;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;

import org.junit.Test;

public class CuartelTest {

    @Test
    public void test01CrearCuartel() {

        Oro oro = new Oro(500);
        Cuartel cuartel = new Cuartel(oro);

        Assert.assertEquals(cuartel.getVida(), 250);
    }

    @Test(expected = CuartelCreandoseException.class)
    public void test02CuartelEnConstruccionNoRecibeDanio() {

        Oro oro = new Oro(500);
        Cuartel cuartel = new Cuartel(oro);

        cuartel.recibirDanio(50);
    }

    @Test
    public void test03CuartelConstruidoRecibeDanio() {

        Oro oro = new Oro(500);
        Cuartel cuartel = new Cuartel(oro);
        cuartel.avanzarTurno();
        cuartel.avanzarTurno();
        cuartel.avanzarTurno();

        cuartel.recibirDanio(50);
        Assert.assertEquals(cuartel.getVida(), 200);
    }

    @Test
    public void test04CuartelRecibirDanioYRepararse() {

        Oro oro = new Oro(500);
        Cuartel cuartel = new Cuartel(oro);
        cuartel.avanzarTurno();
        cuartel.avanzarTurno();
        cuartel.avanzarTurno();

        cuartel.recibirDanio(50);
        cuartel.incrementarVida();

        Assert.assertEquals(cuartel.getVida(), 250);
    }

    @Test(expected = EdificioTieneVidaMaximaException.class)
    public void test05CuartelRecibirDanioYRepararseVariasVecesNoSuperaVidaMaxima() {

        Oro oro = new Oro(500);
        Cuartel cuartel = new Cuartel(oro);
        cuartel.avanzarTurno();
        cuartel.avanzarTurno();
        cuartel.avanzarTurno();

        cuartel.recibirDanio(50);

        cuartel.incrementarVida();
        cuartel.incrementarVida();
        cuartel.incrementarVida();
        cuartel.incrementarVida();
    }

    @Test
    public void test06CrearArqueroDesdeCuartel() {

        Oro oro = new Oro(1000);
        Cuartel cuartel = new Cuartel(oro);
        cuartel.avanzarTurno();
        cuartel.avanzarTurno();
        cuartel.avanzarTurno();

        Arquero arquero = cuartel.crearArqueroDesdeCuartel();

        Assert.assertEquals(75, arquero.getVida());
    }

    @Test
    public void test07CrearEspadachinDesdeCuartel() {

        Oro oro = new Oro(500);
        Cuartel cuartel = new Cuartel(oro);
        cuartel.avanzarTurno();
        cuartel.avanzarTurno();
        cuartel.avanzarTurno();

        Espadachin espadachin = cuartel.crearEspadachinDesdeCuartel();

        Assert.assertEquals(100, espadachin.getVida());
    }

    @Test
    public void test08CrearCuartelRestaOro() {

        Oro oro = new Oro(500);
        Cuartel cuartel = new Cuartel(oro);

        Assert.assertEquals(oro.getOro(), 450);
    }

    @Test(expected = OroInsuficienteException.class)
    public void test09CrearCuartelConOroInsuficienteLanzaExcepcion() {

        Oro oro = new Oro(5);

        Cuartel cuartel = new Cuartel(oro);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test10cuartelIntentaColocarseFueraDelRangoDelMapaPositivoLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(500);
        Cuartel cuartel = new Cuartel(oro);

        cuartel.colocarseEn(mapa, 100, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test11cuartelIntentaColocarseFueraDelRangoDelMapaNegativoLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(500);
        Cuartel cuartel = new Cuartel(oro);

        cuartel.colocarseEn(mapa, -1000, -1000);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test12cuartelIntentaColocarseFueraDelRangoDelMapaNuloLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(500);
        Cuartel cuartel = new Cuartel(oro);

        cuartel.colocarseEn(mapa, 0, 0);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test13cuartelSeColocaEnMapaYSeIntentaColocarOtraPlazaEnMismoLugarLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(500);
        Cuartel unaPlaza = new Cuartel(oro);
        Cuartel otraPlaza = new Cuartel(oro);

        unaPlaza.colocarseEn(mapa, 10, 10);

        otraPlaza.colocarseEn(mapa, 10, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test14cuartelSeColocaYSeDescolocaYSeColocaUnidadesEnElMismoLugarLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(10000);
        Cuartel cuartel = new Cuartel(oro);

        cuartel.colocarseEn(mapa, 10, 10);
        cuartel.descolocarseDe(mapa);
        mapa.colocarUnidad(new Aldeano(oro), 10, 10);
        mapa.colocarUnidad(new Aldeano(oro), 10, 11);
        mapa.colocarUnidad(new Aldeano(oro), 11, 10);
        mapa.colocarUnidad(new Aldeano(oro), 11, 11);

        mapa.colocarUnidad(new Aldeano(oro), 11, 10);
    }

    @Test(expected = EdificioSiendoReparadoException.class)
    public void test15cuartelSeIntentaRepararPorDosAldeanosDiferentesLanzaExcepcion() {

        Oro oro = new Oro(1000);
        Cuartel cuartel = new Cuartel(oro);
        cuartel.avanzarTurno();
        cuartel.avanzarTurno();
        cuartel.avanzarTurno();

        cuartel.reducirVida(100);
        cuartel.repararse(new Aldeano(oro));

        cuartel.repararse(new Aldeano(oro));
    }

    @Test
    public void test16cuartelCalculaDistanciaHaciaOtraPosicionDevuelveValorCorrecto() {

        Oro oro = new Oro(2000);
        Cuartel cuartel = new Cuartel(oro);
        Mapa mapa = new Mapa(20, 20);
        Posicion posicion = new Posicion(15, 15);

        cuartel.colocarseEn(mapa, 10, 10);

        Assert.assertEquals(4, cuartel.calcularDistanciaA(posicion));
    }

    @Test
    public void test17cuartelColocaAlrededorMasivo() {

        Oro oro = new Oro(100000);
        Cuartel cuartel = new Cuartel(oro);
        cuartel.avanzarTurno();
        cuartel.avanzarTurno();
        cuartel.avanzarTurno();
        Mapa mapa = new Mapa(20, 20);
        cuartel.colocarseEn(mapa, 3, 3);
 
        for (int i = 0; i < 40; i++) {
            Espadachin espadachin = cuartel.crearEspadachinDesdeCuartel();
            cuartel.colocarAlrededor(mapa, espadachin);
        }
    }
}
