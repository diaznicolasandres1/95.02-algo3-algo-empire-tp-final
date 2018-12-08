package modelo.unidades;

import junit.framework.Assert;
import modelo.excepciones.*;
import modelo.juego.Oro;
import modelo.mapa.Posicion;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.mapa.Mapa;
import modelo.unidades.aldeano.Aldeano;

import org.junit.Test;

public class AldeanoTest {

    @Test
    public void test01CreacionDeAldeano() {
        Oro oro = new Oro(125);
        Aldeano aldeano = new Aldeano(oro);
        Assert.assertEquals(aldeano.getVida(), 50);
    }

    @Test
    public void test02AldeanoDisponibleSumaOro() {

        Oro oro = new Oro(125);
        Aldeano aldeano = new Aldeano(oro);

        aldeano.finalizarTurno();

        Assert.assertEquals(120, oro.getOro());
    }

    @Test
    public void test03AldeanoOcupadoNoSumaOro() {

        Oro oro = new Oro(125);
        Aldeano aldeano = new Aldeano(oro);

        aldeano.estarOcupado(1);
        aldeano.finalizarTurno();

        Assert.assertEquals(100, oro.getOro());
    }
    
    @Test(expected = AldeanoEstaOcupadoException.class)
    public void test04AldeanoOcupadoNoCreaCuartel() {

        Oro oro = new Oro(125);
        Aldeano aldeano = new Aldeano(oro);

        aldeano.estarOcupado(2);

        aldeano.construirCuartel();
    }

    @Test
    public void test05AldeanoNoDisponiblePorVariosTurnosNoSumaOro() {

        Oro oro = new Oro(125);
        Aldeano aldeano = new Aldeano(oro);
        aldeano.estarOcupado(3);

        aldeano.finalizarTurno();
        aldeano.finalizarTurno();

        Assert.assertEquals(100, oro.getOro());
    }

    @Test
    public void test06AldeanoPor3TurnosConstruyendoNoSumaOro() {
        Oro oro = new Oro(125);
        Aldeano aldeano = new Aldeano(oro);  // Resta 25 Oro

        aldeano.construirCuartel(); // Primer turno ocupado, comienza a construir resta 50 Oro
        aldeano.finalizarTurno();// Segundo turno ocupado
        aldeano.finalizarTurno();// Tercer turno ocupado
        aldeano.finalizarTurno(); // Ya esta libre, en el proximo turno suma oro
        aldeano.finalizarTurno(); // Suma 20 oro

        Assert.assertEquals(70, oro.getOro());
    }
    
    @Test
    public void test07CrearAldeanoRestaOro() {
        Oro oro = new Oro(100);

        Aldeano aldeano = new Aldeano(oro);

        Assert.assertEquals(75, oro.getOro());
    }

    @Test(expected = OroInsuficienteException.class)
    public void test08CrearAldeanoConOroInsuficiente() {
        Oro oro = new Oro(5);
        Aldeano aldeano = new Aldeano(oro);
    }

    @Test
    public void test09aldeanoReparandoCuartelDebeEstarOcupado() {
        Oro oro = new Oro(500);
        Mapa mapa = new Mapa(25, 25);
        Aldeano aldeano = new Aldeano(oro);  //25 oro
        aldeano.colocarseEn(mapa, 10, 10);
        Cuartel cuartel = aldeano.construirCuartel(); //50 Oro
        cuartel.colocarseEn(mapa, 11, 10);
        aldeano.finalizarTurno(); // Primer turno ocupado
        cuartel.finalizarTurno(); // Primer turno ocupado

        aldeano.finalizarTurno(); // Segundo turno ocupado
        cuartel.finalizarTurno(); // Segundo turno ocupado

        aldeano.finalizarTurno(); // Tercer turno ocupado
        cuartel.finalizarTurno(); // Tercer turno ocupado

        cuartel.reducirVida(100); // Ya se termino de construir, se le puede hacer daño
        aldeano.repararEdificio(cuartel);
        aldeano.finalizarTurno(); // No genera oro en este turno

        Assert.assertEquals(425, oro.getOro());
    }

    @Test(expected = ConstruccionFueraDeRangoException.class)
    public void test10aldeanoIntentaRepararEdificioFueraDeSuAlcanceLanzaExcepcion() {

        Mapa mapa = new Mapa(25, 25);
        Oro oro = new Oro(1000);
        PlazaCentral plaza = new PlazaCentral(oro);
        Aldeano aldeano = new Aldeano(oro);
        plaza.finalizarTurno();
        plaza.finalizarTurno();
        plaza.finalizarTurno();
        plaza.colocarseEn(mapa, 10, 10);
        aldeano.colocarseEn(mapa, 8, 10);

        aldeano.repararEdificio(plaza);
    }

    @Test(expected = AldeanoEstaOcupadoException.class)
    public void test11aldeanoIntentaMoverseMientrasEstaReparandoLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(500);
        Aldeano aldeano = new Aldeano(oro);
        Posicion unaPosicion = new Posicion(50, 50);
        Posicion otraPosicion = new Posicion(51, 51);

        aldeano.setPosicion(unaPosicion);
        aldeano.estarEnReparacion();

        aldeano.moverHacia(otraPosicion, mapa);
    }

    @Test(expected = AldeanoEstaOcupadoException.class)
    public void test12aldeanoIntentaMoverseMientrasEstaOcupadoLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(500);
        Aldeano aldeano = new Aldeano(oro);
        Posicion unaPosicion = new Posicion(50, 50);
        Posicion otraPosicion = new Posicion(51, 51);

        aldeano.setPosicion(unaPosicion);
        aldeano.estarOcupado(10);

        aldeano.moverHacia(otraPosicion, mapa);
    }

    @Test(expected = PosicionFueraDeRangoException.class)
    public void test13aldeanoDisponibleIntentaMoverseFueraDeRangoLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(500);
        Aldeano aldeano = new Aldeano(oro);
        Posicion unaPosicion = new Posicion(1, 5);
        Posicion otraPosicion = new Posicion(0, 0);

        aldeano.setPosicion(unaPosicion);

        aldeano.moverHacia(otraPosicion, mapa);
    }

    @Test(expected = AldeanoEstaOcupadoException.class)
    public void test14aldeanoIntentaMoverse2VecesEnUnTurnoLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(500);
        Aldeano aldeano = new Aldeano(oro);
        mapa.colocarUnidad(aldeano, 10, 10);

        aldeano.moverHacia(new Posicion(11, 11), mapa);

        aldeano.moverHacia(new Posicion(12, 11), mapa);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test15aldeanoSeMueveHaciaElNorteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        unAldeano.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 9, 10);

        mapa.colocarUnidad(otroAldeano, 9, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test16aldeanoSeMueveHaciaElSurYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        unAldeano.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 11, 10);

        otroAldeano.colocarseEn(mapa, 11, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test17aldeanoSeMueveHaciaElEsteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        unAldeano.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 10, 11);

        otroAldeano.colocarseEn(mapa, 10, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test18aldeanoSeMueveHaciaElOesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        unAldeano.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 10, 9);

        otroAldeano.colocarseEn(mapa, 10, 9);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test19aldeanoSeMueveHaciaElNoresteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        unAldeano.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 9, 11);

        otroAldeano.colocarseEn(mapa, 9, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test20aldeanoSeMueveHaciaElSuresteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        unAldeano.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 11, 11);

        otroAldeano.colocarseEn(mapa, 11, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test21aldeanoSeMueveHaciaElSuroesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        unAldeano.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 11, 9);

        otroAldeano.colocarseEn(mapa, 11, 9);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test22aldeanoSeMueveHaciaElNoroesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        unAldeano.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 9, 9);

        otroAldeano.colocarseEn(mapa, 9, 9);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test23aldeanoIntentaColocarseFueraDelRangoPositivoDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano aldeano = new Aldeano(oro);

        aldeano.colocarseEn(mapa, 100, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test24aldeanoIntentaColocarseFueraDelRangoNegativoDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano aldeano = new Aldeano(oro);

        aldeano.colocarseEn(mapa, -1000, -1000);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test25aldeanoIntentaColocarseEnLimiteDelRangoNuloDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano aldeano = new Aldeano(oro);

        aldeano.colocarseEn(mapa, 0, 0);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test26aldeanoSeColocaEnMapaYSeDescolocaYSeColocanDosUnidadesEnElMismoLugarLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano aldeano = new Aldeano(oro);

        aldeano.colocarseEn(mapa, 10, 10);
        aldeano.descolocarseDe(mapa);
        mapa.colocarUnidad(new Aldeano(oro), 10, 10);

        mapa.colocarUnidad(new Aldeano(oro), 10, 10);
    }

    @Test
    public void test27aldeanoReparandoDebeEstarOcupadoYTerminaCuandoSeReparaElEdificio() {

        Mapa mapa = new Mapa(25, 25);
        Oro oro = new Oro(500);
        Aldeano aldeano = new Aldeano(oro);  //25 oro
        PlazaCentral plaza =  aldeano.construirPlazaCentral(); //100 Oro
        plaza.colocarseEn(mapa, 10, 10);
        aldeano.colocarseEn(mapa, 12, 10);


        aldeano.finalizarTurno();// Segundo turno ocupado
        plaza.finalizarTurno();// Segundo turno ocupado
        aldeano.finalizarTurno();// tercer turno ocupado
        plaza.finalizarTurno();// tercer turno ocupado
        aldeano.finalizarTurno();// Aldeano libre
        plaza.finalizarTurno();// Edificio construido

        plaza.reducirVida(100); //Ya se construyo se le puede hacer daño
        aldeano.repararEdificio(plaza);
        aldeano.finalizarTurno();
        aldeano.finalizarTurno();
        aldeano.finalizarTurno();

        Assert.assertEquals(375, oro.getOro()); // No genero oro por estar ocupado
        Assert.assertEquals(450, plaza.getVida()); // La plaza vuelve a tener toda su vida
    }

    @Test(expected = EdificioSiendoReparadoException.class)
    public void test28dosAldeanosDiferentesIntentanRepararMismoEdificioYElSegundoAldeanoNoQuedaOcupado() {

        Oro oro = new Oro(1000);
        Mapa mapa = new Mapa(25, 25);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);
        PlazaCentral plaza = new PlazaCentral(oro);
        plaza.colocarseEn(mapa, 10, 10);
        unAldeano.colocarseEn(mapa, 12, 10);
        otroAldeano.colocarseEn(mapa, 10, 12);

        plaza.finalizarTurno();
        plaza.finalizarTurno();
        plaza.finalizarTurno();
        plaza.reducirVida(100);
        unAldeano.repararEdificio(plaza);

        otroAldeano.repararEdificio(plaza);
    }

    @Test
    public void test29aldeanoMuereMientrasReparaEdificioYOtroAldeanoTerminaDeRepararEdificio() {

        Oro oro = new Oro(1000);
        Mapa mapa = new Mapa(25, 25);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);
        PlazaCentral plaza = new PlazaCentral(oro);
        plaza.colocarseEn(mapa, 10, 10);
        unAldeano.colocarseEn(mapa, 12, 10);
        otroAldeano.colocarseEn(mapa, 10, 12);

        plaza.finalizarTurno();
        plaza.finalizarTurno();
        plaza.finalizarTurno();
        plaza.reducirVida(100); // 350 de vida
        unAldeano.repararEdificio(plaza); // 375 de vida

        try {
            unAldeano.reducirVida(100);
        } catch (UnidadFueDestruidaException e) {
            otroAldeano.repararEdificio(plaza); // 400 de vida
            otroAldeano.finalizarTurno(); // 425 de vida
            otroAldeano.finalizarTurno(); // 450 de vida
        }

        Assert.assertEquals(450, plaza.getVida());
    }

    @Test
    public void test30aldeanoCalculaDistanciaHaciaOtraPosicionYDevuelveValorCorrecto() {

        Oro oro = new Oro(6000);
        Aldeano aldeano = new Aldeano(oro);
        Mapa mapa = new Mapa(25, 25);
        Posicion posicion = new Posicion(15, 15);

        mapa.colocarUnidad(aldeano, 10, 10);

        Assert.assertEquals(5, aldeano.calcularDistanciaA(posicion));
    }

    @Test(expected = ConstruccionFueraDeRangoException.class)
    public void test31aldeanoIntentaContruirPlazaFueraDeSuRangoLanzaException() {

        Oro oro = new Oro(6000);
        Aldeano aldeano = new Aldeano(oro);
        Mapa mapa = new Mapa(25, 25);
        mapa.colocarUnidad(aldeano, 10, 10);
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        
        aldeano.colocarEdificio(plaza, mapa, 20, 20);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test32aldeanoIntentaContruirPlazaFueraDeSuRangoVuelveAEstarDisponibleSeMueveYSeColocaUnidadEnEsaPosicionLanzaExcepcion() {

        Oro oro = new Oro(6000);
        Aldeano aldeano = new Aldeano(oro);
        Mapa mapa = new Mapa(25, 25);
        mapa.colocarUnidad(aldeano, 10, 10);
        PlazaCentral plaza = aldeano.construirPlazaCentral();

        try {
            aldeano.colocarEdificio(plaza, mapa, 20, 20);
        } catch (ConstruccionFueraDeRangoException e) {
            aldeano.moverHacia(new Posicion(11, 11), mapa);
        }

        mapa.colocarUnidad(new Aldeano(oro), 11, 11);
    }
}
