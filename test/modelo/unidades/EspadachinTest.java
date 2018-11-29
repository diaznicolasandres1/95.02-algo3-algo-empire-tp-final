package modelo.unidades;

import junit.framework.Assert;
import modelo.excepciones.*;
import modelo.juego.Oro;
import modelo.mapa.Posicion;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.mapa.Mapa;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.espadachin.Espadachin;

import org.junit.Test;

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

    @Test(expected = OroInsuficienteException.class)
    public void test03CrearEspadachinConOroInsuficiente() {

        Oro oro = new Oro(5);

        Espadachin espadachin = new Espadachin(oro);
    }

    @Test(expected = PosicionFueraDeRangoException.class)
    public void test04espadachinSeMueveFueraDeRangoYLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(300);
        Espadachin espadachin = new Espadachin(oro);
        Posicion unaPosicion = new Posicion(5, 5);
        Posicion otraPosicion = new Posicion(10, 10);

        espadachin.setPosicion(unaPosicion);

        espadachin.moverHacia(otraPosicion, mapa);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test05espadachinSeMueveHaciaElNorteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Espadachin unEspadachin = new Espadachin(oro);
        Espadachin otroEspadachin = new Espadachin(oro);

        unEspadachin.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unEspadachin, 10, 10, 9, 10);

        otroEspadachin.colocarseEn(mapa, 9, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test06espadachinSeMueveHaciaElSurYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Espadachin unEspadachin = new Espadachin(oro);
        Espadachin otroEspadachin = new Espadachin(oro);

        unEspadachin.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unEspadachin, 10, 10, 11, 10);

        otroEspadachin.colocarseEn(mapa, 11, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test07espadachinSeMueveHaciaElEsteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Espadachin unEspadachin = new Espadachin(oro);
        Espadachin otroEspadachin = new Espadachin(oro);

        unEspadachin.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unEspadachin, 10, 10, 10, 11);

        otroEspadachin.colocarseEn(mapa, 10, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test08espadachinSeMueveHaciaElOesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Espadachin unEspadachin = new Espadachin(oro);
        Espadachin otroEspadachin = new Espadachin(oro);

        unEspadachin.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unEspadachin, 10, 10, 10, 9);

        otroEspadachin.colocarseEn(mapa, 10, 9);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test09espadachinSeMueveHaciaElNoresteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Espadachin unEspadachin = new Espadachin(oro);
        Espadachin otroEspadachin = new Espadachin(oro);

        unEspadachin.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unEspadachin, 10, 10, 9, 11);

        otroEspadachin.colocarseEn(mapa, 9, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test10espadachinSeMueveHaciaElSuresteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Espadachin unEspadachin = new Espadachin(oro);
        Espadachin otroEspadachin = new Espadachin(oro);

        unEspadachin.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unEspadachin, 10, 10, 11, 11);

        otroEspadachin.colocarseEn(mapa, 11, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test11espadachinSeMueveHaciaElSuroesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Espadachin unEspadachin = new Espadachin(oro);
        Espadachin otroEspadachin = new Espadachin(oro);

        unEspadachin.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unEspadachin, 10, 10, 11, 9);

        otroEspadachin.colocarseEn(mapa, 11, 9);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test12espadachinSeMueveHaciaElNoroesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Espadachin unEspadachin = new Espadachin(oro);
        Espadachin otroEspadachin = new Espadachin(oro);

        unEspadachin.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unEspadachin, 10, 10, 9, 9);

        otroEspadachin.colocarseEn(mapa, 9, 9);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test13espadachinIntentaColocarseFueraDelRangoPositivoDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Espadachin espadachin = new Espadachin(oro);

        espadachin.colocarseEn(mapa, 100, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test14espadachinIntentaColocarseFueraDelRangoNegativoDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Espadachin espadachin = new Espadachin(oro);

        espadachin.colocarseEn(mapa, -1000, -1000);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test15espadachinIntentaColocarseEnLimiteDelRangoNuloDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Espadachin espadachin = new Espadachin(oro);

        espadachin.colocarseEn(mapa, 0, 0);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test16espadachinSeColocaEnMapaYSeDescolocaYSeColocanDosUnidadesEnElMismoLugarLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Espadachin espadachin = new Espadachin(oro);

        espadachin.colocarseEn(mapa, 10, 10);
        espadachin.descolocarseDe(mapa);
        mapa.colocarUnidad(new Espadachin(oro), 10, 10);

        mapa.colocarUnidad(new Espadachin(oro), 10, 10);
    }
    /*-----PRUEBAS DE ATAQUE A EDIFICIO Y UNIDAD-----*/
    
    @Test 
    public void test18EspadachinAtacaAldeanoYLeResta10deVida() {

        Oro oro = new Oro(300);
        Espadachin espadachin = new Espadachin(oro);
        Aldeano aldeano = new Aldeano(oro);
        Mapa mapa = new Mapa(20, 20);
        mapa.colocarUnidad(espadachin, 10, 11);
        mapa.colocarUnidad(aldeano, 10, 12);

        espadachin.atacar(aldeano);

        Assert.assertEquals(aldeano.getVida(), 25);
    }
    
    @Test
    public void test19EspadachinAtacaPlazaCentralYLeResta15deVida() {

        Oro oro = new Oro(800);
        Espadachin espadachin = new Espadachin(oro);
        PlazaCentral plaza = new PlazaCentral(oro);
        Mapa mapa = new Mapa(20, 20);
        mapa.colocarUnidad(espadachin, 10, 12);
        mapa.colocarEdificio(plaza, 4, 10, 10);
        
        espadachin.atacar(plaza);

        Assert.assertEquals(plaza.getVida(), 435);
    }

    @Test(expected = ColocableFueraDeRangoDeAtaqueException.class)
    public void test20espadachinAtacaUnidadFueraDeRangoLanzaExcepcion() {

        Oro oro = new Oro(800);
        Espadachin espadachin = new Espadachin(oro);
        PlazaCentral plaza = new PlazaCentral(oro);
        Mapa mapa = new Mapa(20, 20);
        mapa.colocarUnidad(espadachin, 10, 10);
        mapa.colocarEdificio(plaza, 4, 12, 12);

        espadachin.atacar(plaza);
    }

    @Test(expected = EspadachinYaFueUtilizadoEsteTurno.class)
    public void test21EspadachinSoloPuedeAtacarUnaVezPorTurnoLanzaExcepcion() {

        Oro oro = new Oro(800);
        Espadachin espadachin = new Espadachin(oro);
        PlazaCentral plaza = new PlazaCentral(oro);
        Mapa mapa = new Mapa(20, 20);
        mapa.colocarUnidad(espadachin, 10, 12);
        mapa.colocarEdificio(plaza, 4, 10, 10);

        espadachin.atacar(plaza);

        espadachin.atacar(plaza);
    }

    @Test(expected = EspadachinYaFueUtilizadoEsteTurno.class)
    public void test22espadachinSoloPuedeMoverseUnaVezPorTurnoLanzaExcepcion() {

        Oro oro = new Oro(800);
        Mapa mapa = new Mapa(20, 20);
        Espadachin espadachin = new Espadachin(oro);
        mapa.colocarUnidad(espadachin, 10, 14);

        espadachin.moverHacia(new Posicion(15, 10), mapa);

        espadachin.moverHacia(new Posicion(16, 10), mapa);
    }

    @Test(expected = EspadachinYaFueUtilizadoEsteTurno.class)
    public void test23espadachinAtacaYSeIntentaMoverEnElMismoTurnoLanzaExcepcion() {

        Oro oro = new Oro(800);
        Mapa mapa = new Mapa(20, 20);
        Espadachin espadachin = new Espadachin(oro);
        PlazaCentral plaza = new PlazaCentral(oro);
        mapa.colocarUnidad(espadachin, 10, 14);
        mapa.colocarEdificio(plaza, 4, 11, 14);

        espadachin.atacar(plaza);

        espadachin.moverHacia(new Posicion(15, 10), mapa);
    }

    @Test
    public void test24EspadachinAtacaPasaElTurnoYPuedeVolverAAtacar() {

        Oro oro = new Oro(800);
        Espadachin espadachin = new Espadachin(oro);
        PlazaCentral plaza = new PlazaCentral(oro);
        Mapa mapa = new Mapa(20, 20);
        mapa.colocarUnidad(espadachin, 10, 12);
        mapa.colocarEdificio(plaza, 4, 10, 10);

        espadachin.atacar(plaza);
        espadachin.avanzarTurno();
        espadachin.atacar(plaza);

        Assert.assertEquals(plaza.getVida(), 420);
    }

    @Test
    public void test25espadachinCalculaDistanciaHaciaOtraPosicionYDevuelveValorCorrecto() {

        Oro oro = new Oro(6000);
        Espadachin espadachin = new Espadachin(oro);
        Mapa mapa = new Mapa(25, 25);
        Posicion posicion = new Posicion(15, 15);

        mapa.colocarUnidad(espadachin, 10, 10);

        Assert.assertEquals(5, espadachin.calcularDistanciaA(posicion));
    }
}
