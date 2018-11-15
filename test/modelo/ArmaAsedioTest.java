package modelo;

import junit.framework.Assert;
import modelo.mapa.CasilleroOcupadoException;
import modelo.mapa.Mapa;
import org.junit.Test;
import unidades.ArmaDeAsedio;
import unidades.NoSePuedeAtacarArmaAsedioDesmontadaException;
import unidades.NoSePuedeMoverArmaAsedioMontadaException;

public class ArmaAsedioTest {

	@Test
	public void test01CreacionDeArmaAsedio() {

		Oro oro = new Oro(500);
		ArmaDeAsedio arma = new ArmaDeAsedio(oro);

		Assert.assertEquals(arma.getVida(), 150);

	}
	
	@Test(expected = NoSePuedeMoverArmaAsedioMontadaException.class)
	public void test02MoverArmaMontadaLanzaExcepcion() {

		Oro oro = new Oro(500);
		ArmaDeAsedio arma = new ArmaDeAsedio(oro);
		Posicion posicion = new Posicion(9, 9);

		arma.montarArma();

		arma.moverHacia(posicion);
		
	}
	
	@Test(expected = NoSePuedeAtacarArmaAsedioDesmontadaException.class)
	public void test03AtacarConArmaDesmontada() {

		Oro oro = new Oro(500);
		ArmaDeAsedio arma = new ArmaDeAsedio(oro);

		arma.atacar();
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

		Oro oro = new Oro(500);
		ArmaDeAsedio arma = new ArmaDeAsedio(oro);
		Posicion unaPosicion = new Posicion(5, 5);
		Posicion otraPosicion = new Posicion(9, 9);

		arma.setPosicion(unaPosicion);

		arma.moverHacia(otraPosicion);
	}

	@Test(expected = CasilleroOcupadoException.class)
	public void test07armaDeAsedioSeMueveHaciaElNorteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

		Mapa mapa = new Mapa(20, 20);
		Oro oro = new Oro(2000);
		ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(oro);
		ArmaDeAsedio otraArmaDeAsedio = new ArmaDeAsedio(oro);

		mapa.colocarUnidad(unArmaDeAsedio, 10, 10);
		mapa.moverUnidadDesdeHasta(unArmaDeAsedio, 10, 10, 9, 10);

		mapa.colocarUnidad(otraArmaDeAsedio, 9, 10);
	}

	@Test(expected = CasilleroOcupadoException.class)
	public void test08armaDeAsedioSeMueveHaciaElSurYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

		Mapa mapa = new Mapa(20, 20);
		Oro oro = new Oro(2000);
		ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(oro);
		ArmaDeAsedio otraArmaDeAsedio = new ArmaDeAsedio(oro);

		mapa.colocarUnidad(unArmaDeAsedio, 10, 10);
		mapa.moverUnidadDesdeHasta(unArmaDeAsedio, 10, 10, 11, 10);

		mapa.colocarUnidad(otraArmaDeAsedio, 11, 10);
	}

	@Test(expected = CasilleroOcupadoException.class)
	public void test09armaDeAsedioSeMueveHaciaElEsteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

		Mapa mapa = new Mapa(20, 20);
		Oro oro = new Oro(2000);
		ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(oro);
		ArmaDeAsedio otraArmaDeAsedio = new ArmaDeAsedio(oro);

		mapa.colocarUnidad(unArmaDeAsedio, 10, 10);
		mapa.moverUnidadDesdeHasta(unArmaDeAsedio, 10, 10, 10, 11);

		mapa.colocarUnidad(otraArmaDeAsedio, 10, 11);
	}

	@Test(expected = CasilleroOcupadoException.class)
	public void test10armaDeAsedioSeMueveHaciaElOesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

		Mapa mapa = new Mapa(20, 20);
		Oro oro = new Oro(2000);
		ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(oro);
		ArmaDeAsedio otraArmaDeAsedio = new ArmaDeAsedio(oro);

		mapa.colocarUnidad(unArmaDeAsedio, 10, 10);
		mapa.moverUnidadDesdeHasta(unArmaDeAsedio, 10, 10, 10, 9);

		mapa.colocarUnidad(otraArmaDeAsedio, 10, 9);
	}

	@Test(expected = CasilleroOcupadoException.class)
	public void test11armaDeAsedioSeMueveHaciaElNoresteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

		Mapa mapa = new Mapa(20, 20);
		Oro oro = new Oro(2000);
		ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(oro);
		ArmaDeAsedio otraArmaDeAsedio = new ArmaDeAsedio(oro);

		mapa.colocarUnidad(unArmaDeAsedio, 10, 10);
		mapa.moverUnidadDesdeHasta(unArmaDeAsedio, 10, 10, 9, 11);

		mapa.colocarUnidad(otraArmaDeAsedio, 9, 11);
	}

	@Test(expected = CasilleroOcupadoException.class)
	public void test12armaDeAsedioSeMueveHaciaElSuresteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

		Mapa mapa = new Mapa(20, 20);
		Oro oro = new Oro(2000);
		ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(oro);
		ArmaDeAsedio otraArmaDeAsedio = new ArmaDeAsedio(oro);

		mapa.colocarUnidad(unArmaDeAsedio, 10, 10);
		mapa.moverUnidadDesdeHasta(unArmaDeAsedio, 10, 10, 11, 11);

		mapa.colocarUnidad(otraArmaDeAsedio, 11, 11);
	}

	@Test(expected = CasilleroOcupadoException.class)
	public void test13armaDeAsedioSeMueveHaciaElSuroesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

		Mapa mapa = new Mapa(20, 20);
		Oro oro = new Oro(2000);
		ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(oro);
		ArmaDeAsedio otraArmaDeAsedio = new ArmaDeAsedio(oro);

		mapa.colocarUnidad(unArmaDeAsedio, 10, 10);
		mapa.moverUnidadDesdeHasta(unArmaDeAsedio, 10, 10, 11, 9);

		mapa.colocarUnidad(otraArmaDeAsedio, 11, 9);
	}

	@Test(expected = CasilleroOcupadoException.class)
	public void test14armaDeAsedioSeMueveHaciaElNoroesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

		Mapa mapa = new Mapa(20, 20);
		Oro oro = new Oro(2000);
		ArmaDeAsedio unArmaDeAsedio = new ArmaDeAsedio(oro);
		ArmaDeAsedio otraArmaDeAsedio = new ArmaDeAsedio(oro);

		mapa.colocarUnidad(unArmaDeAsedio, 10, 10);
		mapa.moverUnidadDesdeHasta(unArmaDeAsedio, 10, 10, 9, 9);

		mapa.colocarUnidad(otraArmaDeAsedio, 9, 9);
	}
	
}

	

	

