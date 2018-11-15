package modelo;

import edificios.Cuartel;
import edificios.PlazaCentral;
import junit.framework.Assert;
import modelo.mapa.CasilleroOcupadoException;
import modelo.mapa.Mapa;
import org.junit.Test;
import unidades.Aldeano;
import unidades.AldeanoEstaOcupadoException;

public class AldeanoTest {

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
    public void test05AldeanoNoDisponibleNoSumaOro() {
    	 Oro oro = new Oro(125);
         Aldeano aldeano = new Aldeano(oro);
        aldeano.estarOcupado(1);
        aldeano.avanzarTurno();
        
        int cantidadOro = oro.getOro();
        Assert.assertEquals(100, cantidadOro);
    }
    @Test
    public void test06AldeanoNoDisponiblePorVariosTurnosNoSumaOro() {
    	 Oro oro = new Oro(125);
         Aldeano aldeano = new Aldeano(oro);
        aldeano.estarOcupado(3);
        aldeano.avanzarTurno();
        aldeano.avanzarTurno();        
        
        int cantidadOro = oro.getOro();
        Assert.assertEquals(100, cantidadOro);
    }
    @Test
    public void test07AldeanoPor3TurnosConstruyendoNoSumaOro() {
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
    public void test08CrearAldeanoRestaOro() {
    	Oro oro = new Oro(100);
    	Aldeano aldeano = new Aldeano(oro);
    	Assert.assertEquals(75, oro.getOro());
    }
    

	@Test(expected = NoTenesOroSuficienteException.class)
	public void test09CrearAldeanoConOroInsuficiente() {
		Oro oro = new Oro(5);
		Aldeano aldeano = new Aldeano(oro);
	}
	
	@Test
	public void test10aldeanoReparandoCuartelDebeEstarOcupado() {
		Oro oro = new Oro(500);
    	Aldeano aldeano = new Aldeano(oro);  //25 oro   
        Cuartel cuartel =  aldeano.construirCuartel(); //50 Oro       
        aldeano.avanzarTurno();//Segundo turno ocupado
        cuartel.avanzarTurno();//Segundo turno ocupado
        aldeano.avanzarTurno();//tercer turno ocupado
        cuartel.avanzarTurno();//tercer turno ocupado
        aldeano.avanzarTurno();//tercer turno ocupado
        cuartel.avanzarTurno();//tercer turno ocupado
      
        cuartel.recibirDanio(100); //Ya se construyo se le puede hacer daño
        aldeano.aldeanoRepararEdificio(cuartel); //No Genera oro en este turno
        aldeano.avanzarTurno();//Tercer turno ocupado 
       
       
        
        
        int cantidadOro = oro.getOro();
        Assert.assertEquals(425, cantidadOro);
		
	}

    @Test(expected = AldeanoEstaOcupadoException.class)
    public void test11aldeanoIntentaMoverseMientrasEstaReparandoLanzaExcepcion() {

        Oro oro = new Oro(500);
        Aldeano aldeano = new Aldeano(oro);
        Posicion unaPosicion = new Posicion(50, 50);
        Posicion otraPosicion = new Posicion(51, 51);

        aldeano.setPosicion(unaPosicion);
        aldeano.estarEnReparacion();

        aldeano.moverHacia(otraPosicion);
    }

    @Test(expected = AldeanoEstaOcupadoException.class)
    public void test12aldeanoIntentaMoverseMientrasEstaOcupadoLanzaExcepcion() {

        Oro oro = new Oro(500);
        Aldeano aldeano = new Aldeano(oro);
        Posicion unaPosicion = new Posicion(50, 50);
        Posicion otraPosicion = new Posicion(51, 51);

        aldeano.setPosicion(unaPosicion);
        aldeano.estarOcupado(10);

        aldeano.moverHacia(otraPosicion);
    }

    @Test(expected = PosicionFueraDeRangoException.class)
    public void test13aldeanoDisponibleIntentaMoverseFueraDeRangoLanzaExcepcion() {

        Oro oro = new Oro(500);
        Aldeano aldeano = new Aldeano(oro);
        Posicion unaPosicion = new Posicion(1, 5);
        Posicion otraPosicion = new Posicion(0, 0);

        aldeano.setPosicion(unaPosicion);

        aldeano.moverHacia(otraPosicion);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test14aldeanoSeMueveHaciaElNorteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        mapa.colocarUnidad(unAldeano, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 9, 10);

        mapa.colocarUnidad(otroAldeano, 9, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test15aldeanoSeMueveHaciaElSurYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        mapa.colocarUnidad(unAldeano, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 11, 10);

        mapa.colocarUnidad(otroAldeano, 11, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test16aldeanoSeMueveHaciaElEsteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        mapa.colocarUnidad(unAldeano, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 10, 11);

        mapa.colocarUnidad(otroAldeano, 10, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test17aldeanoSeMueveHaciaElOesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        mapa.colocarUnidad(unAldeano, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 10, 9);

        mapa.colocarUnidad(otroAldeano, 10, 9);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test18aldeanoSeMueveHaciaElNoresteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        mapa.colocarUnidad(unAldeano, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 9, 11);

        mapa.colocarUnidad(otroAldeano, 9, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test19aldeanoSeMueveHaciaElSuresteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        mapa.colocarUnidad(unAldeano, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 11, 11);

        mapa.colocarUnidad(otroAldeano, 11, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test20aldeanoSeMueveHaciaElSuroesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        mapa.colocarUnidad(unAldeano, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 11, 9);

        mapa.colocarUnidad(otroAldeano, 11, 9);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test21aldeanoSeMueveHaciaElNoroesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        mapa.colocarUnidad(unAldeano, 10, 10);
        mapa.moverUnidadDesdeHasta(unAldeano, 10, 10, 9, 9);

        mapa.colocarUnidad(otroAldeano, 9, 9);
    }

	@Test
	public void aldeanoReparandoDebeEstarOcupadoYTerminaCuandoSeReparaElEdificio() {
		Oro oro = new Oro(500);
    	Aldeano aldeano = new Aldeano(oro);  //25 oro   
        PlazaCentral plaza =  aldeano.construirPlazaCentral(); //100 Oro
        
        aldeano.avanzarTurno();//Segundo turno ocupado
        plaza.avanzarTurno();//Segundo turno ocupado
        aldeano.avanzarTurno();//tercer turno ocupado
        plaza.avanzarTurno();//tercer turno ocupado
        aldeano.avanzarTurno();// Aldeano libre 
        plaza.avanzarTurno();// Edificio construido
        
      
        plaza.recibirDanio(100); //Ya se construyo se le puede hacer daño
        aldeano.aldeanoRepararEdificio(plaza);
        aldeano.avanzarTurno();       
        aldeano.avanzarTurno();
        aldeano.avanzarTurno();
       
         
       
        
        
        int cantidadOro = oro.getOro();
        Assert.assertEquals(375, cantidadOro); //No genero oro por estar ocupado
        Assert.assertEquals(plaza.getVida(),450); //La plaza vuelve a tener toda su vida
		
	}
}
