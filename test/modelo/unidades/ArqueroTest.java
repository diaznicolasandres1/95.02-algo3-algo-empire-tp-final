package modelo.unidades;

import junit.framework.Assert;
import modelo.edificios.castillo.Castillo;
import modelo.excepciones.*;
import modelo.juego.Oro;
import modelo.mapa.Posicion;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.mapa.Mapa;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.arquero.Arquero;

import org.junit.Test;

public class ArqueroTest {

    @Test
    public void test01CreacionDeArquero() {

        Oro oro = new Oro(300);
        Arquero arquero = new Arquero(oro);

        Assert.assertEquals(arquero.getVida(), 75);
    }

    @Test
    public void test02CreacionDeArqueroCuestaOro() {

        Oro oro = new Oro(300);
        Arquero arquero = new Arquero(oro);

        Assert.assertEquals(oro.getOro(), 225);
    }

    @Test(expected = OroInsuficienteException.class)
    public void test03CrearArqueroConOroInsuficiente() {

        Oro oro = new Oro(5);

        Arquero arquero = new Arquero(oro);
    }

    @Test(expected = PosicionFueraDeRangoException.class)
    public void test04arqueroSeMueveFueraDeRangoYLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(300);
        Arquero arquero = new Arquero(oro);
        Posicion unaPosicion = new Posicion(5, 5);
        Posicion otraPosicion = new Posicion(10, 10);

        arquero.setPosicion(unaPosicion);

        arquero.moverHacia(otraPosicion, mapa);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test05arqueroSeMueveHaciaElNorteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Arquero unArquero = new Arquero(oro);
        Arquero otroArquero = new Arquero(oro);

        unArquero.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArquero, 10, 10, 9, 10);

        otroArquero.colocarseEn(mapa, 9, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test06arqueroSeMueveHaciaElSurYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Arquero unArquero = new Arquero(oro);
        Arquero otroArquero = new Arquero(oro);

        unArquero.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArquero, 10, 10, 11, 10);

        otroArquero.colocarseEn(mapa, 11, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test07arqueroSeMueveHaciaElEsteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Arquero unArquero = new Arquero(oro);
        Arquero otroArquero = new Arquero(oro);

        unArquero.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArquero, 10, 10, 10, 11);

        otroArquero.colocarseEn(mapa, 10, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test08arqueroSeMueveHaciaElOesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Arquero unArquero = new Arquero(oro);
        Arquero otroArquero = new Arquero(oro);

        unArquero.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArquero, 10, 10, 10, 9);

        otroArquero.colocarseEn(mapa, 10, 9);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test09arqueroSeMueveHaciaElNoresteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Arquero unArquero = new Arquero(oro);
        Arquero otroArquero = new Arquero(oro);

        unArquero.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArquero, 10, 10, 9, 11);

        otroArquero.colocarseEn(mapa, 9, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test10arqueroSeMueveHaciaElSuresteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Arquero unArquero = new Arquero(oro);
        Arquero otroArquero = new Arquero(oro);

        unArquero.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArquero, 10, 10, 11, 11);

        otroArquero.colocarseEn(mapa, 11, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test11arqueroSeMueveHaciaElSuroesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Arquero unArquero = new Arquero(oro);
        Arquero otroArquero = new Arquero(oro);

        unArquero.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArquero, 10, 10, 11, 9);

        otroArquero.colocarseEn(mapa, 11, 9);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test12arqueroSeMueveHaciaElNoroesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Arquero unArquero = new Arquero(oro);
        Arquero otroArquero = new Arquero(oro);

        unArquero.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArquero, 10, 10, 9, 9);

        otroArquero.colocarseEn(mapa, 9, 9);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test13arqueroIntentaColocarseFueraDelRangoPositivoDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Arquero arquero = new Arquero(oro);

        arquero.colocarseEn(mapa, 100, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test14arqueroIntentaColocarseFueraDelRangoNegativoDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Arquero arquero = new Arquero(oro);

        arquero.colocarseEn(mapa, -1000, -1000);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test15arqueroIntentaColocarseEnLimiteDelRangoNuloDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Arquero arquero = new Arquero(oro);

        arquero.colocarseEn(mapa, 0, 0);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test16arqueroSeColocaEnMapaYSeDescolocaYSeColocanDosUnidadesEnElMismoLugarLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(500);
        Arquero arquero = new Arquero(oro);

        arquero.colocarseEn(mapa, 10, 10);
        arquero.descolocarseDe(mapa);
        mapa.colocarUnidad(new Arquero(oro), 10, 10);

        mapa.colocarUnidad(new Arquero(oro), 10, 10);
    }

    @Test 
    public void test17ArqueroAtacaOtroArqueroYLeResta15deVida() {
        Oro oro = new Oro(300);
        Mapa mapa = new Mapa(20, 20);
        Arquero unArquero = new Arquero(oro);
        Arquero otroArquero = new Arquero(oro);
        mapa.colocarUnidad(unArquero, 10, 10);
        mapa.colocarUnidad(otroArquero, 10, 13);

        unArquero.atacar(otroArquero);

        Assert.assertEquals(otroArquero.getVida(), 60);
    }
    
    @Test 
    public void test18ArqueroAtacaAldeanoYLeResta15deVida() {

        Oro oro = new Oro(300);
        Mapa mapa = new Mapa(20, 20);
        Arquero arquero = new Arquero(oro);
        Aldeano aldeano = new Aldeano(oro);
        mapa.colocarUnidad(arquero, 10, 10);
        mapa.colocarUnidad(aldeano, 10, 11);

        arquero.atacar(aldeano);

        Assert.assertEquals(aldeano.getVida(), 35);
    }
    
    @Test 
    public void test19ArqueroAtacaPlazaCentralYLeResta15deVida() {

        Oro oro = new Oro(800);
        Arquero arquero = new Arquero(oro);
        PlazaCentral plaza = new PlazaCentral(oro);
        Mapa mapa = new Mapa(20, 20);
        mapa.colocarEdificio(plaza, 4, 10, 10);
        mapa.colocarUnidad(arquero, 10, 14);

        arquero.atacar(plaza);

        Assert.assertEquals(plaza.getVida(), 440);
    }

    @Test(expected = ArqueroYaFueUtilizadoEnEsteTurnoException.class)
    public void test20ArqueroSoloPuedeAtacarUnaVezPorTurnoLanzaExcepcion() {

        Oro oro = new Oro(800);
        Mapa mapa = new Mapa(20, 20);
        Arquero arquero = new Arquero(oro);
        PlazaCentral plaza = new PlazaCentral(oro);
        mapa.colocarEdificio(plaza, 4, 10, 10);
        mapa.colocarUnidad(arquero, 10, 14);

        arquero.atacar(plaza);

        arquero.atacar(plaza);
    }

    @Test(expected = ArqueroYaFueUtilizadoEnEsteTurnoException.class)
    public void test21arqueroSoloPuedeMoverseUnaVezPorTurnoLanzaExcepcion() {

        Oro oro = new Oro(800);
        Mapa mapa = new Mapa(20, 20);
        Arquero arquero = new Arquero(oro);
        mapa.colocarUnidad(arquero, 10, 14);

        arquero.moverHacia(new Posicion(15, 10), mapa);

        arquero.moverHacia(new Posicion(16, 10), mapa);
    }

    @Test(expected = ArqueroYaFueUtilizadoEnEsteTurnoException.class)
    public void test22arqueroAtacaYSeIntentaMoverEnElMismoTurnoLanzaExcepcion() {

        Oro oro = new Oro(800);
        Mapa mapa = new Mapa(20, 20);
        Arquero arquero = new Arquero(oro);
        PlazaCentral plaza = new PlazaCentral(oro);
        mapa.colocarUnidad(arquero, 10, 14);
        mapa.colocarEdificio(plaza, 4, 11, 14);

        arquero.atacar(plaza);

        arquero.moverHacia(new Posicion(15, 10), mapa);
    }

    @Test
    public void test23ArqueroAtacaPasaElTurnoYPuedeVolverAAtacar() {

        Oro oro = new Oro(800);
        Arquero arquero = new Arquero(oro);
        PlazaCentral plaza = new PlazaCentral(oro);
        Mapa mapa = new Mapa(20, 20);
        mapa.colocarEdificio(plaza, 4, 10, 10);
        mapa.colocarUnidad(arquero, 10, 14);

        arquero.atacar(plaza);
        arquero.avanzarTurno();

        arquero.atacar(plaza);
        Assert.assertEquals(440, plaza.getVida());
    }

    @Test
    public void test24arqueroAtacaACastilloConSoloUnCasilleroEnRangoYLeQuita10DeVida() {

        Oro oro = new Oro(800);
        Arquero arquero = new Arquero(oro);
        Castillo castillo = new Castillo(oro);
        Mapa mapa = new Mapa(20, 20);
        mapa.colocarUnidad(arquero, 10, 10);
        mapa.colocarEdificio(castillo, 16, 13, 13);

        arquero.atacar(castillo);

        Assert.assertEquals(990, castillo.getVida());
    }

    @Test(expected = ColocableFueraDeRangoDeAtaqueException.class)
    public void test25ArqueroIntentaAtacarEdificioFueraDeRangoYLanzaExcepcion() {

        Oro oro = new Oro(800);
        Arquero arquero = new Arquero(oro);
        PlazaCentral plaza = new PlazaCentral(oro);
        Mapa mapa = new Mapa(20, 20);

        mapa.colocarEdificio(plaza, 4, 10, 10);
        mapa.colocarUnidad(arquero, 1, 2);

        arquero.atacar(plaza);
    }

    @Test(expected = ColocableFueraDeRangoDeAtaqueException.class)
    public void test26ArqueroIntentaAtacarUnidadFueraDeRangoYLanzaExcepcion() {

        Oro oro = new Oro(800);
        Arquero arquero = new Arquero(oro);
        Aldeano aldeano = new Aldeano(oro);
        Mapa mapa = new Mapa(20, 20);

        mapa.colocarUnidad(aldeano, 10, 10);
        mapa.colocarUnidad(arquero, 1, 2);

        arquero.atacar(aldeano);
    }
}
