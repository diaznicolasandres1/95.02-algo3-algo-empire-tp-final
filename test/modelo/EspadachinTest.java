package modelo;

import junit.framework.Assert;
import modelo.mapa.CasilleroOcupadoException;
import modelo.mapa.Mapa;
import org.junit.Test;
import unidades.Espadachin;

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

		Oro oro = new Oro(300);
		Espadachin espadachin = new Espadachin(oro);
		Posicion unaPosicion = new Posicion(5, 5);
		Posicion otraPosicion = new Posicion(10, 10);

		espadachin.setPosicion(unaPosicion);

		espadachin.moverHacia(otraPosicion);
	}

	@Test(expected = CasilleroOcupadoException.class)
	public void test05espadachinSeMueveHaciaElNorteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

		Mapa mapa = new Mapa(20, 20);
		Oro oro = new Oro(200);
		Espadachin unEspadachin = new Espadachin(oro);
		Espadachin otroEspadachin = new Espadachin(oro);

		mapa.colocarUnidad(unEspadachin, 10, 10);
		mapa.moverUnidadDesdeHasta(unEspadachin, 10, 10, 9, 10);

		mapa.colocarUnidad(otroEspadachin, 9, 10);
	}

	@Test(expected = CasilleroOcupadoException.class)
	public void test06espadachinSeMueveHaciaElSurYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

		Mapa mapa = new Mapa(20, 20);
		Oro oro = new Oro(200);
		Espadachin unEspadachin = new Espadachin(oro);
		Espadachin otroEspadachin = new Espadachin(oro);

		mapa.colocarUnidad(unEspadachin, 10, 10);
		mapa.moverUnidadDesdeHasta(unEspadachin, 10, 10, 11, 10);

		mapa.colocarUnidad(otroEspadachin, 11, 10);
	}

	@Test(expected = CasilleroOcupadoException.class)
	public void test07espadachinSeMueveHaciaElEsteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

		Mapa mapa = new Mapa(20, 20);
		Oro oro = new Oro(200);
		Espadachin unEspadachin = new Espadachin(oro);
		Espadachin otroEspadachin = new Espadachin(oro);

		mapa.colocarUnidad(unEspadachin, 10, 10);
		mapa.moverUnidadDesdeHasta(unEspadachin, 10, 10, 10, 11);

		mapa.colocarUnidad(otroEspadachin, 10, 11);
	}

	@Test(expected = CasilleroOcupadoException.class)
	public void test08espadachinSeMueveHaciaElOesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

		Mapa mapa = new Mapa(20, 20);
		Oro oro = new Oro(200);
		Espadachin unEspadachin = new Espadachin(oro);
		Espadachin otroEspadachin = new Espadachin(oro);

		mapa.colocarUnidad(unEspadachin, 10, 10);
		mapa.moverUnidadDesdeHasta(unEspadachin, 10, 10, 10, 9);

		mapa.colocarUnidad(otroEspadachin, 10, 9);
	}

	@Test(expected = CasilleroOcupadoException.class)
	public void test09espadachinSeMueveHaciaElNoresteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

		Mapa mapa = new Mapa(20, 20);
		Oro oro = new Oro(200);
		Espadachin unEspadachin = new Espadachin(oro);
		Espadachin otroEspadachin = new Espadachin(oro);

		mapa.colocarUnidad(unEspadachin, 10, 10);
		mapa.moverUnidadDesdeHasta(unEspadachin, 10, 10, 9, 11);

		mapa.colocarUnidad(otroEspadachin, 9, 11);
	}

	@Test(expected = CasilleroOcupadoException.class)
	public void test10espadachinSeMueveHaciaElSuresteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

		Mapa mapa = new Mapa(20, 20);
		Oro oro = new Oro(200);
		Espadachin unEspadachin = new Espadachin(oro);
		Espadachin otroEspadachin = new Espadachin(oro);

		mapa.colocarUnidad(unEspadachin, 10, 10);
		mapa.moverUnidadDesdeHasta(unEspadachin, 10, 10, 11, 11);

		mapa.colocarUnidad(otroEspadachin, 11, 11);
	}

	@Test(expected = CasilleroOcupadoException.class)
	public void test11espadachinSeMueveHaciaElSuroesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

		Mapa mapa = new Mapa(20, 20);
		Oro oro = new Oro(200);
		Espadachin unEspadachin = new Espadachin(oro);
		Espadachin otroEspadachin = new Espadachin(oro);

		mapa.colocarUnidad(unEspadachin, 10, 10);
		mapa.moverUnidadDesdeHasta(unEspadachin, 10, 10, 11, 9);

		mapa.colocarUnidad(otroEspadachin, 11, 9);
	}

	@Test(expected = CasilleroOcupadoException.class)
	public void test12espadachinSeMueveHaciaElNoroesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

		Mapa mapa = new Mapa(20, 20);
		Oro oro = new Oro(200);
		Espadachin unEspadachin = new Espadachin(oro);
		Espadachin otroEspadachin = new Espadachin(oro);

		mapa.colocarUnidad(unEspadachin, 10, 10);
		mapa.moverUnidadDesdeHasta(unEspadachin, 10, 10, 9, 9);

		mapa.colocarUnidad(otroEspadachin, 9, 9);
	}
	
	

}
