package modelo.edificios;

import junit.framework.Assert;
import modelo.NoTenesOroSuficienteException;
import modelo.Oro;
import modelo.mapa.CasilleroOcupadoException;
import modelo.mapa.Mapa;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.armadeasedio.ArmaDeAsedio;

import org.junit.Test;


public class CastilloTest {

    @Test
    public void test01crearCastillo() {

        Oro oro = new Oro(1000);
        Castillo castillo = new Castillo(oro);

        Assert.assertEquals(1000, castillo.getVida());
    }

    @Test
    public void test02CastilloRecibeDanio() {

        Oro oro = new Oro(1000);
        Castillo castillo = new Castillo(oro);

        castillo.recibirDanio(500);

        Assert.assertEquals(500, castillo.getVida());
    }

    @Test
    public void test03CastilloRecibeDanioYSeCuraAsiMismo() {

        Oro oro = new Oro(1000);
        Castillo castillo = new Castillo(oro);
        castillo.recibirDanio(50);

        castillo.repararseAsimismo();

        Assert.assertEquals(965, castillo.getVida());
    }

    @Test(expected = EdificioTieneVidaMaximaException.class)
    public void test04castilloLanzaExcepcionSiSeLoQuiereSeguirReparandoConVidaMaxima() {

        Oro oro = new Oro(1000);
        Castillo castillo = new Castillo(oro);

        castillo.recibirDanio(50);

        castillo.repararseAsimismo();
        castillo.repararseAsimismo();
        castillo.repararseAsimismo();
        castillo.repararseAsimismo();
        castillo.repararseAsimismo();
        castillo.repararseAsimismo();
        castillo.repararseAsimismo();
        castillo.repararseAsimismo();
        castillo.repararseAsimismo();
        castillo.repararseAsimismo();
        castillo.repararseAsimismo();
    }

    @Test
    public void test05CastilloCreaArmaDeAsedioRestaOro() {

        Oro oro = new Oro(1000);
        Castillo castillo = new Castillo(oro);

        ArmaDeAsedio arma = castillo.crearArmaDeAsedio();

        Assert.assertEquals(oro.getOro(), 800);
    }

    @Test
    public void test06CastilloCreaArmaYEstaExiste() {

        Oro oro = new Oro(1000);
        Castillo castillo = new Castillo(oro);

        ArmaDeAsedio arma = castillo.crearArmaDeAsedio();

        Assert.assertEquals(arma.getVida(), 150);
    }

    @Test(expected = NoTenesOroSuficienteException.class)
    public void test07CastilloCreaArmaDeAsedioHastaNoTenerDineroLanzaExcepcion() {

        Oro oro = new Oro(1000);
        Castillo castillo = new Castillo(oro);

        castillo.crearArmaDeAsedio();
        castillo.crearArmaDeAsedio();
        castillo.crearArmaDeAsedio();
        castillo.crearArmaDeAsedio();
        castillo.crearArmaDeAsedio();
        castillo.crearArmaDeAsedio();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test08castilloIntentaColocarseFueraDelRangoDelMapaPositivoLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(500);
        Castillo castillo = new Castillo(oro);

        castillo.colocarseEn(mapa, 100, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test09castilloIntentaColocarseFueraDelRangoDelMapaNegativoLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(500);
        Castillo castillo = new Castillo(oro);

        castillo.colocarseEn(mapa, -1000, -1000);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test10castilloIntentaColocarseFueraDelRangoDelMapaNuloLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(500);
        Castillo castillo = new Castillo(oro);

        castillo.colocarseEn(mapa, 0, 0);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test11castilloSeColocaEnMapaYSeIntentaColocarOtraPlazaEnMismoLugarLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(500);
        Castillo unCastillo = new Castillo(oro);
        Castillo otroCastillo = new Castillo(oro);

        unCastillo.colocarseEn(mapa, 10, 10);

        otroCastillo.colocarseEn(mapa, 10, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test12castilloSeColocaYSeDescolocaYSeColocaUnidadesEnElMismoLugarLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(10000);
        Castillo castillo = new Castillo(oro);

        castillo.colocarseEn(mapa, 10, 10);
        castillo.descolocarseDe(mapa);
        mapa.colocarUnidad(new Aldeano(oro), 10, 10);
        mapa.colocarUnidad(new Aldeano(oro), 10, 11);
        mapa.colocarUnidad(new Aldeano(oro), 11, 10);
        mapa.colocarUnidad(new Aldeano(oro), 11, 11);

        mapa.colocarUnidad(new Aldeano(oro), 11, 10);
    }

}
