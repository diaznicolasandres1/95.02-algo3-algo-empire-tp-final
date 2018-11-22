package modelo.unidades;

import junit.framework.Assert;
import modelo.NoTenesOroSuficienteException;
import modelo.Oro;
import modelo.Posicion;
import modelo.PosicionFueraDeRangoException;
import modelo.edificios.PlazaCentral;
import modelo.edificios.cuartel.Cuartel;
import modelo.mapa.CasilleroOcupadoException;
import modelo.mapa.Mapa;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.aldeano.AldeanoEstaOcupadoException;

import org.junit.Test;

public class AldeanoTest {
	
	/*----PRUEBAS DE CREACION-----*/

	@Test
	public void test01CreacionDeAldeano() {
        Oro oro = new Oro(125);
        Aldeano aldeano = new Aldeano(oro);
        Assert.assertEquals(aldeano.getVida(), 50);
	}

    @Test
    public void test02AldeeanoDisponibleSumaOro() {

        Oro oro = new Oro(125);
        Aldeano aldeano = new Aldeano(oro);
        aldeano.avanzarTurno();
        int cantidadOro = oro.getOro();
        Assert.assertEquals(125, cantidadOro);
    }

    @Test
    public void test03AldeanoOcupadoNoSumaOro() {

        Oro oro = new Oro(125);
        Aldeano aldeano = new Aldeano(oro);
        aldeano.estarOcupado(1);
        aldeano.avanzarTurno();
        int cantidadOro = oro.getOro();
        Assert.assertEquals(100, cantidadOro);

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
        aldeano.avanzarTurno();
        aldeano.avanzarTurno();        
        
        int cantidadOro = oro.getOro();
        Assert.assertEquals(100, cantidadOro);
    }

    @Test
    public void test06AldeanoPor3TurnosConstruyendoNoSumaOro() {
        Oro oro = new Oro(125);
        Aldeano aldeano = new Aldeano(oro);  //Rest 25 Oro
        aldeano.construirCuartel(); //Primer turno ocupado, comienza a construir Resta 50 Oro
        aldeano.avanzarTurno();//Segundo turno ocupado
        aldeano.avanzarTurno();//Tercer turno ocupado  
        aldeano.avanzarTurno(); //Ya esta libre al proximo avance sumara oro 
        aldeano.avanzarTurno(); //Suma 25 oro
        
        int cantidadOro = oro.getOro();
        Assert.assertEquals(75, cantidadOro);
    }
    
    @Test
    public void test07CrearAldeanoRestaOro() {
    	Oro oro = new Oro(100);
    	Aldeano aldeano = new Aldeano(oro);
    	Assert.assertEquals(75, oro.getOro());
    }
    

	@Test(expected = NoTenesOroSuficienteException.class)
    public void test08CrearAldeanoConOroInsuficiente() {
		Oro oro = new Oro(5);
		Aldeano aldeano = new Aldeano(oro);
	}
	
	@Test
    public void test09aldeanoReparandoCuartelDebeEstarOcupado() {

		Oro oro = new Oro(500);
    	Aldeano aldeano = new Aldeano(oro);  //25 oro   
        Cuartel cuartel =  aldeano.construirCuartel(); //50 Oro       
        aldeano.avanzarTurno();//Segundo turno ocupado
        cuartel.avanzarTurno();//Segundo turno ocupado
        
        aldeano.avanzarTurno();//tercer turno ocupado
        cuartel.avanzarTurno();//tercer turno ocupado
        
        aldeano.avanzarTurno();
        cuartel.avanzarTurno();

        cuartel.recibirDanioCuartel(100); //Ya se construyo se le puede hacer daño
        aldeano.aldeanoRepararEdificio(cuartel); //No Genera oro en este turno
        aldeano.avanzarTurno();

        int cantidadOro = oro.getOro();
        Assert.assertEquals(425, cantidadOro);
	}

    @Test(expected = AldeanoEstaOcupadoException.class)
    public void test10aldeanoIntentaMoverseMientrasEstaReparandoLanzaExcepcion() {

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
    public void test11aldeanoIntentaMoverseMientrasEstaOcupadoLanzaExcepcion() {

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
    public void test12aldeanoDisponibleIntentaMoverseFueraDeRangoLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(500);
        Aldeano aldeano = new Aldeano(oro);
        Posicion unaPosicion = new Posicion(1, 5);
        Posicion otraPosicion = new Posicion(0, 0);

        aldeano.setPosicion(unaPosicion);

        aldeano.moverHacia(otraPosicion, mapa);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test13aldeanoSeMueveHaciaElNorteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        unAldeano.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 9, 10);

        mapa.colocarUnidad(otroAldeano, 9, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test14aldeanoSeMueveHaciaElSurYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        unAldeano.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 11, 10);

        otroAldeano.colocarseEn(mapa, 11, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test15aldeanoSeMueveHaciaElEsteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        unAldeano.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 10, 11);

        otroAldeano.colocarseEn(mapa, 10, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test16aldeanoSeMueveHaciaElOesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        unAldeano.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 10, 9);

        otroAldeano.colocarseEn(mapa, 10, 9);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test17aldeanoSeMueveHaciaElNoresteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        unAldeano.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 9, 11);

        otroAldeano.colocarseEn(mapa, 9, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test18aldeanoSeMueveHaciaElSuresteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        unAldeano.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 11, 11);

        otroAldeano.colocarseEn(mapa, 11, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test19aldeanoSeMueveHaciaElSuroesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        unAldeano.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 11, 9);

        otroAldeano.colocarseEn(mapa, 11, 9);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test20aldeanoSeMueveHaciaElNoroesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        unAldeano.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 9, 9);

        otroAldeano.colocarseEn(mapa, 9, 9);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test21aldeanoIntentaColocarseFueraDelRangoPositivoDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano aldeano = new Aldeano(oro);

        aldeano.colocarseEn(mapa, 100, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test22aldeanoIntentaColocarseFueraDelRangoNegativoDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano aldeano = new Aldeano(oro);

        aldeano.colocarseEn(mapa, -1000, -1000);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test23aldeanoIntentaColocarseEnLimiteDelRangoNuloDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano aldeano = new Aldeano(oro);

        aldeano.colocarseEn(mapa, 0, 0);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test24aldeanoSeColocaEnMapaYSeDescolocaYSeColocanDosUnidadesEnElMismoLugarLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano aldeano = new Aldeano(oro);

        aldeano.colocarseEn(mapa, 10, 10);
        aldeano.descolocarseDe(mapa);
        mapa.colocarUnidad(new Aldeano(oro), 10, 10);

        mapa.colocarUnidad(new Aldeano(oro), 10, 10);
    }

	@Test
    public void test25aldeanoReparandoDebeEstarOcupadoYTerminaCuandoSeReparaElEdificio() {
		Oro oro = new Oro(500);
    	Aldeano aldeano = new Aldeano(oro);  //25 oro   
        PlazaCentral plaza =  aldeano.construirPlazaCentral(); //100 Oro
        
        aldeano.avanzarTurno();//Segundo turno ocupado
        plaza.avanzarTurno();//Segundo turno ocupado
        aldeano.avanzarTurno();//tercer turno ocupado
        plaza.avanzarTurno();//tercer turno ocupado
        aldeano.avanzarTurno();// Aldeano libre 
        plaza.avanzarTurno();// Edificio construido

        plaza.recibirDanioPlazaCentral(100); //Ya se construyo se le puede hacer daño
        aldeano.aldeanoRepararEdificio(plaza);
        aldeano.avanzarTurno();       
        aldeano.avanzarTurno();
        aldeano.avanzarTurno();
        
        int cantidadOro = oro.getOro();
        Assert.assertEquals(375, cantidadOro); //No genero oro por estar ocupado
        Assert.assertEquals(plaza.getVida(),450); //La plaza vuelve a tener toda su vida
	}
}
