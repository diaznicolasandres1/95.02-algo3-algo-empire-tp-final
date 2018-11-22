package modelo.unidades;

import junit.framework.Assert;
import modelo.NoTenesOroSuficienteException;
import modelo.Oro;
import modelo.Posicion;
import modelo.PosicionFueraDeRangoException;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.mapa.CasilleroOcupadoException;
import modelo.mapa.Mapa;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.arquero.ArqueroYaAtacoEnEsteTurnoException;
import modelo.unidades.espadachin.Espadachin;
import modelo.unidades.espadachin.EspadachinYaAtacoEnEsteTurnoException;

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

	@Test(expected = NoTenesOroSuficienteException.class)
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
      	Aldeano aldeano  = new Aldeano(oro);
      	Mapa mapa = new Mapa(20, 20);
      	mapa.colocarUnidad(espadachin, 10, 11);
      	mapa.colocarUnidad(aldeano, 10, 12);

        espadachin.atacar(aldeano);
		Assert.assertEquals(aldeano.getVida(), 25);
    
    }
    
    @Test 
    public void test19ArqueroAtacaPlazaCentralYLeResta15deVida() {
		Oro oro = new Oro(800);
		Espadachin espadachin = new Espadachin(oro);
		PlazaCentral plaza = new PlazaCentral(oro);
		Mapa mapa = new Mapa(20, 20);
      	mapa.colocarUnidad(espadachin, 10, 12);
      	mapa.colocarEdificio(plaza, 4, 10, 10);
		
        
        espadachin.atacar(plaza);
		Assert.assertEquals(plaza.getVida(), 435);
    
    }
    
    @Test(expected = EspadachinYaAtacoEnEsteTurnoException.class)
    public void test20ArqueroSoloPuedeAtacarUnaVezPorTurno() {
		Oro oro = new Oro(800);
		Espadachin espadachin = new Espadachin(oro);
		PlazaCentral plaza = new PlazaCentral(oro);
		Mapa mapa = new Mapa(20, 20);
      	mapa.colocarUnidad(espadachin, 10, 12);
      	mapa.colocarEdificio(plaza, 4, 10, 10);
       
       espadachin.atacar(plaza);
       espadachin.atacar(plaza);
    }
    @Test
    public void test21EspadachinAtacaPasaElTurnoYPuedeVolverAAtacar() {
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
    
    
}
