package modelo.unidades;

import junit.framework.Assert;
import modelo.NoTenesOroSuficienteException;
import modelo.Oro;
import modelo.Posicion;
import modelo.PosicionFueraDeRangoException;
import modelo.edificios.PlazaCentral;
import modelo.mapa.CasilleroOcupadoException;
import modelo.mapa.Mapa;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.armadeasedio.ArmaDeAsedio;
import modelo.unidades.armadeasedio.excepciones.ArmaDeAsedioNoPuedeAtacarUnidadesException;
import modelo.unidades.armadeasedio.excepciones.ElArmaYaEstaDesmontadaException;
import modelo.unidades.armadeasedio.excepciones.NoSePuedeAtacarArmaAsedioDesmontadaException;
import modelo.unidades.armadeasedio.excepciones.NoSePuedeMoverArmaAsedioMontadaException;
import modelo.unidades.armadeasedio.excepciones.TenesQueEsperarAlProximoTurnoParaAtacarException;
import modelo.unidades.armadeasedio.excepciones.TenesQueEsperarAlProximoTurnoParaDesmontarArmaException;
import modelo.unidades.armadeasedio.excepciones.TenesQueEsperarAlProximoTurnoParaMontarArmaException;
import modelo.unidades.armadeasedio.excepciones.TenesQueEsperarAlProximoTurnoParaMoverElArmaException;

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
	
	@Test(expected = NoSePuedeAtacarArmaAsedioDesmontadaException.class)
	public void test03AtacarConArmaDesmontada() {

		Oro oro = new Oro(500);
		ArmaDeAsedio arma = new ArmaDeAsedio(oro);
		PlazaCentral plaza = new PlazaCentral(oro);

		arma.atacar(plaza);
	}
	
	@Test
	public void test04CrearArmaDeAsedioCuestaOro() {

		Oro oro = new Oro(500);
		ArmaDeAsedio arma = new ArmaDeAsedio(oro);

		Assert.assertEquals(oro.getOro(), 300);
	}
	
	@Test(expected = NoTenesOroSuficienteException.class)
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
	     ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);
	     PlazaCentral plaza = new PlazaCentral(oro);
	     armaDeAsedio.montarArma();
	     armaDeAsedio.avanzarTurno();
	     armaDeAsedio.atacar(plaza);
	     
	     Assert.assertEquals(plaza.getVida(), 375);
		
	}
	
	@Test(expected=TenesQueEsperarAlProximoTurnoParaAtacarException.class)
	public void test20ArmaDeAsedioTrataDeAtacarApenasMontaArmaYLanzaExcepcion() {
		 Oro oro = new Oro(1000);
	     ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);
	     PlazaCentral plaza = new PlazaCentral(oro);
	     armaDeAsedio.montarArma();
	     
	     armaDeAsedio.atacar(plaza);
	     
	    
		
	}
	
	@Test(expected=ArmaDeAsedioNoPuedeAtacarUnidadesException.class)
	public void test21ArmaDeAsedioNoPuedeAtacarUnidades() {
		 Oro oro = new Oro(1000);
	     ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);
	     Aldeano aldeano = new Aldeano(oro);
	     armaDeAsedio.montarArma();
	     armaDeAsedio.avanzarTurno();
	     armaDeAsedio.atacar(aldeano);	     
	}
	
	@Test(expected = TenesQueEsperarAlProximoTurnoParaMoverElArmaException.class)
	public void test22AlDesmontarElArmaHayQueEsperarUnTurnoParaMoverArmaDespuesDeDesmontar() {
		Mapa mapa = new Mapa(20, 20);
		Oro oro = new Oro(500);
		ArmaDeAsedio arma = new ArmaDeAsedio(oro);
		Posicion posicion = new Posicion(9, 9);

		arma.montarArma();
		arma.avanzarTurno();
		arma.desmontarArma();
		arma.moverHacia(posicion, mapa);
		
	}
	
	@Test(expected=TenesQueEsperarAlProximoTurnoParaDesmontarArmaException.class)
	public void test23NoSePuedeMontarYDesmontarEnElMismoTurno() {
		 Oro oro = new Oro(1000);
	     ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);	     
	     armaDeAsedio.montarArma();
	     armaDeAsedio.desmontarArma();		
	}
	
	
	@Test(expected=ElArmaYaEstaDesmontadaException.class)
	public void test24NoSePuedeDesmontarArmaDesmontada() {
		 Oro oro = new Oro(1000);
	     ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);	  
	     armaDeAsedio.desmontarArma();     
	       
	}
	
	@Test(expected=TenesQueEsperarAlProximoTurnoParaMontarArmaException.class)
	public void test25NoSePuedeDesmontarYMonsmontarEnElMismoTurno() {
		 Oro oro = new Oro(1000);
	     ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro);	     
	     armaDeAsedio.montarArma();
	     armaDeAsedio.avanzarTurno();
	     armaDeAsedio.desmontarArma();		
	     armaDeAsedio.montarArma();
	}
	
	
	
	
	
	
	
}

	

