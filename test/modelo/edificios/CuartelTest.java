package modelo.edificios;

import junit.framework.Assert;
import modelo.excepciones.EdificioTieneVidaMaximaException;
import modelo.excepciones.OroInsuficienteException;
import modelo.juego.Oro;
import modelo.edificios.cuartel.Cuartel;
import modelo.excepciones.CuartelCreandoseException;
import modelo.excepciones.CasilleroOcupadoException;
import modelo.mapa.Mapa;
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
        cuartel.repararseAsimismo();

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

        cuartel.repararse();
        cuartel.repararse();
        cuartel.repararse();
        cuartel.repararse();
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
}
