package modelo.unidades;

import junit.framework.Assert;
import modelo.edificios.castillo.Castillo;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.excepciones.*;
import modelo.juego.Oro;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.armadeasedio.ArmaDeAsedio;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;
import org.junit.Test;

public class ArmaAsedioTest {

    @Test
    public void test01CreacionDeArmaAsedio() {

        Oro oro = new Oro(500);
        ArmaDeAsedio arma = new ArmaDeAsedio(oro);

        Assert.assertEquals(arma.getVida(), 150);
    }

    @Test(expected = NoSePuedeMoverArmaAsedioMontadaException.class)
    public void test02MoverArmaMontadaLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(500);
        ArmaDeAsedio arma = new ArmaDeAsedio(oro);
        Posicion posicion = new Posicion(9, 9);

        arma.montarArma();
        arma.avanzarTurno();
        arma.moverHacia(posicion, mapa);
    }

    @Test(expected = NoSePuedeAtacarConArmaAsedioDesmontadaException.class)
    public void test03AtacarConArmaDesmontada() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(1000);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);
        PlazaCentral plaza = new PlazaCentral(oro);
        armaDeAsedio.colocarseEn(mapa, 10, 10);
        plaza.colocarseEn(mapa, 5, 5);

        armaDeAsedio.atacar(plaza);
    }

    @Test
    public void test04CrearArmaDeAsedioCuestaOro() {

        Oro oro = new Oro(500);
        ArmaDeAsedio arma = new ArmaDeAsedio(oro);

        Assert.assertEquals(oro.getOro(), 300);
    }

    @Test(expected = OroInsuficienteException.class)
    public void test05CrearArmaSinOroDisponible() {
        Oro oro = new Oro(5);

        ArmaDeAsedio arma = new ArmaDeAsedio(oro);
    }

    @Test(expected = PosicionFueraDeRangoException.class)
    public void test06armaDeAsedioSeMueveFueraDeRangoLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(500);
        ArmaDeAsedio arma = new ArmaDeAsedio(oro);
        Posicion unaPosicion = new Posicion(5, 5);
        Posicion otraPosicion = new Posicion(9, 9);

        arma.setPosicion(unaPosicion);

        arma.moverHacia(otraPosicion, mapa);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test07armaDeAsedioSeMueveHaciaElNorteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(2000);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(oro);
        ArmaDeAsedio otraArmaDeAsedio = new ArmaDeAsedio(oro);

        unArmaDeAsedio.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArmaDeAsedio, 10, 10, 9, 10);

        otraArmaDeAsedio.colocarseEn(mapa, 9, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test08armaDeAsedioSeMueveHaciaElSurYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(2000);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(oro);
        ArmaDeAsedio otraArmaDeAsedio = new ArmaDeAsedio(oro);

        unArmaDeAsedio.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArmaDeAsedio, 10, 10, 11, 10);

        otraArmaDeAsedio.colocarseEn(mapa, 11, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test09armaDeAsedioSeMueveHaciaElEsteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(2000);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(oro);
        ArmaDeAsedio otraArmaDeAsedio = new ArmaDeAsedio(oro);

        unArmaDeAsedio.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArmaDeAsedio, 10, 10, 10, 11);

        otraArmaDeAsedio.colocarseEn(mapa, 10, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test10armaDeAsedioSeMueveHaciaElOesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(2000);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(oro);
        ArmaDeAsedio otraArmaDeAsedio = new ArmaDeAsedio(oro);

        unArmaDeAsedio.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArmaDeAsedio, 10, 10, 10, 9);

        otraArmaDeAsedio.colocarseEn(mapa, 10, 9);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test11armaDeAsedioSeMueveHaciaElNoresteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(2000);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(oro);
        ArmaDeAsedio otraArmaDeAsedio = new ArmaDeAsedio(oro);

        unArmaDeAsedio.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArmaDeAsedio, 10, 10, 9, 11);

        otraArmaDeAsedio.colocarseEn(mapa, 9, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test12armaDeAsedioSeMueveHaciaElSuresteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(2000);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(oro);
        ArmaDeAsedio otraArmaDeAsedio = new ArmaDeAsedio(oro);

        unArmaDeAsedio.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArmaDeAsedio, 10, 10, 11, 11);

        otraArmaDeAsedio.colocarseEn(mapa, 11, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test13armaDeAsedioSeMueveHaciaElSuroesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(2000);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(oro);
        ArmaDeAsedio otraArmaDeAsedio = new ArmaDeAsedio(oro);

        unArmaDeAsedio.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArmaDeAsedio, 10, 10, 11, 9);

        otraArmaDeAsedio.colocarseEn(mapa, 11, 9);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test14armaDeAsedioSeMueveHaciaElNoroesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(2000);
        ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(oro);
        ArmaDeAsedio otraArmaDeAsedio = new ArmaDeAsedio(oro);

        unArmaDeAsedio.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArmaDeAsedio, 10, 10, 9, 9);

        otraArmaDeAsedio.colocarseEn(mapa, 9, 9);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test15armaDeAsedioIntentaColocarseFueraDelRangoPositivoDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);

        armaDeAsedio.colocarseEn(mapa, 100, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test16armaDeAsedioIntentaColocarseFueraDelRangoNegativoDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);

        armaDeAsedio.colocarseEn(mapa, -1000, -1000);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test17armaDeAsedioIntentaColocarseEnLimiteDelRangoNuloDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);

        armaDeAsedio.colocarseEn(mapa, 0, 0);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test18armaDeAsedioSeColocaEnMapaYSeDescolocaYSeColocanDosUnidadesEnElMismoLugarLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(1000);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);

        armaDeAsedio.colocarseEn(mapa, 10, 10);
        armaDeAsedio.descolocarseDe(mapa);
        mapa.colocarUnidad(new ArmaDeAsedio(oro), 10, 10);
        mapa.colocarUnidad(new ArmaDeAsedio(oro), 10, 10);
    }

    @Test
    public void test19ArmaAsedioMontadaAtacaEdificio() {

        Oro oro = new Oro(1000);
        Mapa mapa = new Mapa(20, 20);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);
        PlazaCentral plaza = new PlazaCentral(oro);
        armaDeAsedio.colocarseEn(mapa, 10, 10);
        plaza.colocarseEn(mapa, 11, 11);

        armaDeAsedio.montarArma();
        armaDeAsedio.avanzarTurno();

        armaDeAsedio.atacar(plaza);

        Assert.assertEquals(plaza.getVida(), 375);
    }

    @Test(expected = NoSePuedeAtacarConArmaDeAsedioEnPausaException.class)
    public void test20ArmaDeAsedioTrataDeAtacarApenasMontaArmaYLanzaExcepcion() {

        Oro oro = new Oro(1000);
        Mapa mapa = new Mapa(20, 20);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);
        PlazaCentral plaza = new PlazaCentral(oro);
        armaDeAsedio.colocarseEn(mapa, 10, 10);
        plaza.colocarseEn(mapa, 11, 11);
        armaDeAsedio.montarArma();
        armaDeAsedio.atacar(plaza);
    }

    @Test(expected = UnidadNoPuedeSerAtacadaPorArmaDeAsedioException.class)
    public void test21ArmaDeAsedioNoPuedeAtacarAldeanoLanzaExcepcion() {

        Oro oro = new Oro(1000);
        Mapa mapa = new Mapa(20, 20);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);
        Aldeano aldeano = new Aldeano(oro);
        armaDeAsedio.colocarseEn(mapa, 10, 10);
        aldeano.colocarseEn(mapa, 12, 12);

        armaDeAsedio.montarArma();
        armaDeAsedio.avanzarTurno();

        armaDeAsedio.atacar(aldeano);
    }

    @Test(expected = UnidadNoPuedeSerAtacadaPorArmaDeAsedioException.class)
    public void test22armaDeAsedioNoPuedeAtacarEspadachinLanzaExcepcion() {

        Oro oro = new Oro(1000);
        Mapa mapa = new Mapa(20, 20);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);
        Espadachin espadachin = new Espadachin(oro);
        armaDeAsedio.colocarseEn(mapa, 10, 10);
        espadachin.colocarseEn(mapa, 12, 12);

        armaDeAsedio.montarArma();
        armaDeAsedio.avanzarTurno();

        armaDeAsedio.atacar(espadachin);
    }

    @Test(expected = UnidadNoPuedeSerAtacadaPorArmaDeAsedioException.class)
    public void test23armaDeAsedioNoPuedeAtacarEspadachinLanzaExcepcion() {

        Oro oro = new Oro(1000);
        Mapa mapa = new Mapa(20, 20);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);
        Arquero arquero = new Arquero(oro);
        armaDeAsedio.colocarseEn(mapa, 10, 10);
        arquero.colocarseEn(mapa, 12, 12);

        armaDeAsedio.montarArma();
        armaDeAsedio.avanzarTurno();

        armaDeAsedio.atacar(arquero);
    }

    @Test(expected = NoSePuedeMoverArmaDeAsedioEnPausaException.class)
    public void test24AlDesmontarElArmaHayQueEsperarUnTurnoParaMoverArmaDespuesDeDesmontarLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(500);
        ArmaDeAsedio arma = new ArmaDeAsedio(oro);
        Posicion posicion = new Posicion(9, 9);

        arma.colocarseEn(mapa, 8, 8);
        arma.montarArma();
        arma.avanzarTurno();
        arma.desmontarArma();

        arma.moverHacia(posicion, mapa);
    }

    @Test(expected = ColocableFueraDeRangoDeAtaqueException.class)
    public void test25armaDeAsedioAtacaCastilloFueraDelRangoDeAtaqueLanzaExcepcion() {

        Oro oro = new Oro(1000);
        Mapa mapa = new Mapa(30, 30);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);
        Castillo castillo = new Castillo(oro);
        armaDeAsedio.colocarseEn(mapa, 10, 10);
        castillo.colocarseEn(mapa, 20, 20);

        armaDeAsedio.montarArma();
        armaDeAsedio.avanzarTurno();

        armaDeAsedio.atacar(castillo);
    }

    @Test
    public void test26armaDeAsedioAtacaCastilloConSoloUnCasilleroEnRango() {

        Oro oro = new Oro(1000);
        Mapa mapa = new Mapa(20, 20);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);
        Castillo castillo = new Castillo(oro);
        armaDeAsedio.colocarseEn(mapa, 1, 1);
        castillo.colocarseEn(mapa, 6, 6);

        armaDeAsedio.montarArma();
        armaDeAsedio.avanzarTurno();

        armaDeAsedio.atacar(castillo);

        Assert.assertEquals(925, castillo.getVida());
    }


    @Test(expected = NoSePuedeDesmontarArmaDeAsedioEnPausaException.class)
    public void test27NoSePuedeMontarYDesmontarEnElMismoTurnoLanzaExcepcion() {
        Oro oro = new Oro(1000);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);

        armaDeAsedio.montarArma();

        armaDeAsedio.desmontarArma();
    }

    @Test(expected = ArmaDeAsedioYaSeEncuentraDesmontadaException.class)
    public void test28NoSePuedeDesmontarArmaDesmontadaLanzaExcepcion() {
        Oro oro = new Oro(1000);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);

        armaDeAsedio.desmontarArma();
    }

    @Test(expected = NoSePuedeMontarArmaDeAsedioEnPausaException.class)
    public void test29NoSePuedeDesmontarYMontarEnElMismoTurnoLanzaExcepcion() {
        Oro oro = new Oro(1000);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);

        armaDeAsedio.montarArma();
        armaDeAsedio.avanzarTurno();
        armaDeAsedio.desmontarArma();

        armaDeAsedio.montarArma();
    }

    @Test
    public void test30armaSeDesmontaYMontaVariasVecesPasandoTurnoAtacaYSeVerificaVida() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(1000);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);
        PlazaCentral plaza = new PlazaCentral(oro);
        armaDeAsedio.colocarseEn(mapa, 10, 10);
        plaza.colocarseEn(mapa, 5, 5);

        armaDeAsedio.montarArma();
        armaDeAsedio.avanzarTurno();
        armaDeAsedio.desmontarArma();
        armaDeAsedio.avanzarTurno();
        armaDeAsedio.montarArma();
        armaDeAsedio.avanzarTurno();
        armaDeAsedio.desmontarArma();
        armaDeAsedio.avanzarTurno();
        armaDeAsedio.montarArma();
        armaDeAsedio.avanzarTurno();

        armaDeAsedio.atacar(plaza);

        Assert.assertEquals(plaza.getVida(), 375);
    }

    @Test(expected = NoSePuedeAtacarConArmaAsedioDesmontadaException.class)
    public void test31MontoYDesmontoVariasVecesArmaDesmontadaSeIntentaAtacarLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(1000);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);
        PlazaCentral plaza = new PlazaCentral(oro);
        armaDeAsedio.colocarseEn(mapa, 10, 10);
        plaza.colocarseEn(mapa, 5, 5);

        armaDeAsedio.montarArma();
        armaDeAsedio.avanzarTurno();
        armaDeAsedio.desmontarArma();
        armaDeAsedio.avanzarTurno();
        armaDeAsedio.montarArma();
        armaDeAsedio.avanzarTurno();
        armaDeAsedio.desmontarArma();
        armaDeAsedio.avanzarTurno();
        armaDeAsedio.montarArma();
        armaDeAsedio.avanzarTurno();
        armaDeAsedio.desmontarArma();
        armaDeAsedio.avanzarTurno();

        armaDeAsedio.atacar(plaza);
    }

    @Test(expected = NoSePuedeAtacarConArmaDeAsedioEnPausaException.class)
    public void test32SoloPuedeRealizarUnAtaquePorTurno() {

        Oro oro = new Oro(1000);
        Mapa mapa = new Mapa(20, 20);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);
        Castillo castillo = new Castillo(oro);
        armaDeAsedio.colocarseEn(mapa, 1, 1);
        castillo.colocarseEn(mapa, 6, 6);

        armaDeAsedio.montarArma();
        armaDeAsedio.avanzarTurno();

        armaDeAsedio.atacar(castillo);
        armaDeAsedio.atacar(castillo);
    }

    @Test
    public void test33armaDeAsedioCalculaDistanciaHaciaOtraPosicionYDevuelveValorCorrecto() {

        Oro oro = new Oro(6000);
        ArmaDeAsedio arma = new ArmaDeAsedio(oro);
        Mapa mapa = new Mapa(25, 25);
        Posicion posicion = new Posicion(15, 15);

        mapa.colocarUnidad(arma, 10, 10);

        Assert.assertEquals(5, arma.calcularDistanciaA(posicion));
    }
}



