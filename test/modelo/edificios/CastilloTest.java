package modelo.edificios;

import junit.framework.Assert;
import modelo.edificios.castillo.Castillo;
import modelo.edificios.castillo.CastilloFueDestruidoException;
import modelo.excepciones.*;
import modelo.juego.Oro;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.armadeasedio.ArmaDeAsedio;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;
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

        castillo.reducirVida(500);

        Assert.assertEquals(500, castillo.getVida());
    }

    @Test
    public void test03CastilloRecibeDanioYSeCuraAsiMismo() {

        Oro oro = new Oro(1000);
        Castillo castillo = new Castillo(oro);
        castillo.reducirVida(50);

        castillo.incrementarVida();

        Assert.assertEquals(965, castillo.getVida());
    }

    @Test(expected = EdificioTieneVidaMaximaException.class)
    public void test04castilloLanzaExcepcionSiSeLoQuiereSeguirReparandoConVidaMaxima() {

        Oro oro = new Oro(1000);
        Castillo castillo = new Castillo(oro);

        castillo.reducirVida(50);

        castillo.incrementarVida();
        castillo.incrementarVida();
        castillo.incrementarVida();
        castillo.incrementarVida();
        castillo.incrementarVida();
        castillo.incrementarVida();
        castillo.incrementarVida();
        castillo.incrementarVida();
        castillo.incrementarVida();
        castillo.incrementarVida();
        castillo.incrementarVida();
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

    @Test(expected = OroInsuficienteException.class)
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

    @Test(expected = NoHayLugarSuficenteParaColocarEdificioException.class)
    public void test08castilloIntentaColocarseFueraDelRangoDelMapaPositivoLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(500);
        Castillo castillo = new Castillo(oro);

        castillo.colocarseEn(mapa, 100, 100);
    }

    @Test(expected = NoHayLugarSuficenteParaColocarEdificioException.class)
    public void test09castilloIntentaColocarseFueraDelRangoDelMapaNegativoLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(500);
        Castillo castillo = new Castillo(oro);

        castillo.colocarseEn(mapa, -1000, -1000);
    }

    @Test(expected = NoHayLugarSuficenteParaColocarEdificioException.class)
    public void test10castilloIntentaColocarseFueraDelRangoDelMapaNuloLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(500);
        Castillo castillo = new Castillo(oro);

        castillo.colocarseEn(mapa, 0, 0);
    }

    @Test(expected = NoHayLugarSuficenteParaColocarEdificioException.class)
    public void test11castilloSeColocaEnMapaYSeIntentaColocarOtroCastilloEnMismoLugarLanzaExcepcion() {

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
    @Test
    public void test13CastilloAtacaUnidadesAlRededor() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(10000);
        Castillo castillo = new Castillo(oro);
        Aldeano aldeano = new Aldeano(oro);
        Arquero arquero = new Arquero(oro);
        Espadachin espadachin = new Espadachin(oro);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);
        castillo.colocarseEn(mapa, 9, 10);
        mapa.colocarUnidad(espadachin, 8, 10);
        mapa.colocarUnidad(aldeano, 13, 10);
        mapa.colocarUnidad(arquero, 13, 11);
        mapa.colocarUnidad(armaDeAsedio, 8, 11);

         castillo.atacarAlrededor(mapa);

        Assert.assertEquals(30, aldeano.getVida());
        Assert.assertEquals(80, espadachin.getVida());
        Assert.assertEquals(55, arquero.getVida());
        Assert.assertEquals(130, armaDeAsedio.getVida());
    }

    @Test
    public void test14CastilloAtacaEdificiosAlRededor() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(10000);
        Castillo castillo = new Castillo(oro);
        PlazaCentral plaza = new PlazaCentral(oro);
        castillo.colocarseEn(mapa, 9, 10);
        mapa.colocarEdificio(plaza, 4, 13, 10);

        castillo.atacarAlrededor(mapa);

        Assert.assertEquals(plaza.getVida(), 430);
    }

    @Test
    public void test14CastilloAtacaUnidadesYEdificiosAlRededor() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(10000);
        Castillo castillo = new Castillo(oro);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);
        PlazaCentral plaza = new PlazaCentral(oro);
        Espadachin espadachin = new Espadachin(oro);

        castillo.colocarseEn(mapa, 9, 10);
        mapa.colocarEdificio(plaza, 4, 6, 10);
        mapa.colocarUnidad(espadachin, 8, 10);
        mapa.colocarUnidad(unAldeano, 13, 10);
        mapa.colocarUnidad(otroAldeano, 13, 11);
        plaza.avanzarTurno();
        plaza.avanzarTurno();
        plaza.avanzarTurno();

        castillo.atacarAlrededor(mapa);

        Assert.assertEquals(unAldeano.getVida(), 30);
        Assert.assertEquals(otroAldeano.getVida(), 30);
        Assert.assertEquals(espadachin.getVida(), 80);
        Assert.assertEquals(plaza.getVida(), 430);
    }

    @Test
    public void test15CastilloAtacaPeroAldeanoEstaFueraDelRangoDeAtaqueYNoLeSacaVida() {
        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(10000);
        Castillo castillo = new Castillo(oro);
        Aldeano aldeano = new Aldeano(oro);

        castillo.colocarseEn(mapa, 2, 2);
        mapa.colocarUnidad(aldeano, 20, 20);

        castillo.atacarAlrededor(mapa);
        Assert.assertEquals(aldeano.getVida(), 50);
    }

    @Test(expected = EdificioSiendoReparadoException.class)
    public void test16castilloSeIntentaRepararPorDosAldeanosDiferentesLanzaExcepcion() {

        Oro oro = new Oro(1000);
        Castillo castillo = new Castillo(oro);

        castillo.reducirVida(100);
        castillo.repararse(new Aldeano(oro));

        castillo.repararse(new Aldeano(oro));
    }

    @Test
    public void test17castilloCalculaDistanciaHaciaOtraPosicionDevuelveValorCorrecto() {

        Oro oro = new Oro(2000);
        Castillo castillo = new Castillo(oro);
        Mapa mapa = new Mapa(20, 20);
        Posicion posicion = new Posicion(15, 15);

        castillo.colocarseEn(mapa, 10, 10);

        Assert.assertEquals(2, castillo.calcularDistanciaA(posicion));
    }

    @Test(expected = CastilloFueDestruidoException.class)
    public void test18castilloReduceVidaYEsDestruidoLanzaExcepcion() {

        Oro oro = new Oro(2000);
        Castillo castillo = new Castillo(oro);

        castillo.reducirVida(20000);
    }
}
