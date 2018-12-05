package modelo.juego;

import modelo.excepciones.*;
import modelo.edificios.castillo.Castillo;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.mapa.Mapa;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.espadachin.Espadachin;

import org.junit.Assert;
import org.junit.Test;

public class JugadorTest {

	/*-----Test inicializacion-----*/
	
	@Test
	public void test01OroInicialEs100() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador("Alfa", mapa, 1, 1, 1, 5);

		Assert.assertEquals(100, jugador.getOro());
	}

	@Test
	public void test02CantidadDeUnidadesInicialEs3() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador("Alfa", mapa, 1, 1, 1, 5);

		Assert.assertEquals(3, jugador.getPoblacion());
	}

	@Test
	public void test03CantidadDeEdificiosInicialEs2() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador("Alfa", mapa, 1, 1, 1, 5);

		Assert.assertEquals(2, jugador.getCantidadDeEdificios());
	}
	
	@Test(expected = CasilleroOcupadoException.class)
	public void test04PlazaInicialSeColocaCorrectamente() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador("Alfa", mapa, 1, 1, 1, 5);
		Aldeano aldeano = new Aldeano(oro);
		
		jugador.agregarUnidadEn(aldeano, 1, 1);
	}
	
	@Test(expected = CasilleroOcupadoException.class)
	public void test05CastilloInicialSeColocaCorrectamente() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador("Alfa", mapa, 1, 1, 1, 5);
		Aldeano aldeano = new Aldeano(oro);
		
		jugador.agregarUnidadEn(aldeano, 1, 5);
	}

	/*-----Test crear unidades-----*/

	@Test(expected = EdificioSeleccionadoNoPerteneceAJugadorException.class)
	public void test06CrearAldeanoDesdePlazaNoAliadaLanzaExcepcion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador("Alfa", mapa, 1, 1, 1, 5);
		PlazaCentral plaza = new PlazaCentral(oro);
		
		jugador.crearAldeano(plaza);
	}

	@Test(expected = UnidadSeleccionadaNoPerteneceAJugadorException.class)
	public void test07ContruirPLazaDesdeAldeanoNoAliadoLanzaException() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador("Alfa", mapa, 1, 1, 1, 5);
		Aldeano aldeano = new Aldeano(oro);
		
		jugador.construirPlazaCentral(aldeano, 2, 5);
	}
	
	@Test(expected = LimiteDePoblacionAlcanzadoException.class)
	public void test08CrearUnidadConLimiteDePoblacionAlcanzadoLanzaExcepcion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador("Alfa", mapa, 1, 1, 1, 5);
		PlazaCentral plaza = new PlazaCentral(oro);
		jugador.agregarEdificioEn(plaza, 5, 1);
		jugador.finalizarTurno();
		jugador.finalizarTurno();
		jugador.finalizarTurno();
		
		for (int i = 0; i < 50; i++) {
			jugador.crearAldeano(plaza);
		}
	}
		
	@Test
	public void test09CrearAldeanoDesdePlazaAumentaPoblacion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador("Alfa", mapa, 1, 1, 1, 5);
		PlazaCentral plaza = new PlazaCentral(oro);
		jugador.agregarEdificioEn(plaza, 5, 1);
		jugador.finalizarTurno();
		jugador.finalizarTurno();
		jugador.finalizarTurno();

		jugador.crearAldeano(plaza);

		Assert.assertEquals(4, jugador.getPoblacion());
	}

	@Test
	public void test10CrearEspadachinDesdeCuartelAumentaPoblacion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador("Alfa", mapa, 1, 1, 1, 5);
		Cuartel cuartel = new Cuartel(oro);
		jugador.agregarEdificioEn(cuartel, 5, 1);
		jugador.finalizarTurno();
		jugador.finalizarTurno();
		jugador.finalizarTurno();

		jugador.crearEspadachin(cuartel);

		Assert.assertEquals(4, jugador.getPoblacion());
	}

	@Test
	public void test11CrearArqueroDesdeCuartelAumentaPoblacion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador("Alfa", mapa, 1, 1, 1, 5);
		Cuartel cuartel = new Cuartel(oro);
		jugador.agregarEdificioEn(cuartel, 5, 1);
		jugador.finalizarTurno();
		jugador.finalizarTurno();
		jugador.finalizarTurno();

		jugador.crearArquero(cuartel);

		Assert.assertEquals(4, jugador.getPoblacion());
	}

	@Test
	public void test12CrearArmaDeAsedioDesdeCastilloAumentaPoblacion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador("Alfa", mapa, 1, 1, 1, 5);
		Castillo castillo = new Castillo(oro);
		jugador.agregarEdificioEn(castillo, 5, 1);

		jugador.crearArmaDeAsedio(castillo);

		Assert.assertEquals(4, jugador.getPoblacion());
	}
	
	/*-----Test crear Edificios-----*/
	
	@Test(expected = CasilleroOcupadoException.class)
	public void test13ContruirPlazaLoUbicaCorrectamente() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador("Alfa", mapa, 1, 1, 1, 5);
		Aldeano aldeano = new Aldeano(oro);

		jugador.agregarUnidadEn(aldeano, 5, 1);
		jugador.construirPlazaCentral(aldeano, 6, 1);
		
		jugador.agregarUnidadEn(aldeano, 6, 1);
	}
	
	@Test(expected = CasilleroOcupadoException.class)
	public void test14ContruirCuartelLoUbicaCorrectamente() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador("Alfa", mapa, 1, 1, 1, 5);
		Aldeano aldeano = new Aldeano(oro);

		jugador.agregarUnidadEn(aldeano, 5, 1);
		jugador.construirCuartel(aldeano, 6, 1);
		
		jugador.agregarUnidadEn(aldeano, 6, 1);
	}

	/*-----Test AvanzarTurno-----*/

	@Test(expected = PlazaCentralEnConstruccionException.class)
	public void test16AvanzarTurnoAvanzaConstruccionDePlaza() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador("Alfa", mapa, 1, 1, 1, 5);
		PlazaCentral plaza = new PlazaCentral(oro);

		jugador.agregarEdificioEn(plaza, 5, 1);
		jugador.finalizarTurno();
		
		Aldeano aldeano = plaza.crearAldeanoDesdePlaza();	
	}
	
	@Test
	public void test17AvanzarTurnoAvanza3VecesTerminaConstruccionDePlaza() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador("Alfa", mapa, 1, 1, 1, 5);
		PlazaCentral plaza = new PlazaCentral(oro);

		jugador.agregarEdificioEn(plaza, 5, 1);
		jugador.finalizarTurno();
		jugador.finalizarTurno();
		jugador.finalizarTurno();
		Aldeano aldeano = plaza.crearAldeanoDesdePlaza();

		Assert.assertNotNull(aldeano);
	}

	@Test
	public void test18AvanzarTurnoAvanza3VecesTerminaConstruccionDe2Plazas() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador("Alfa", mapa, 1, 1, 1, 5);
		PlazaCentral unaPlaza = new PlazaCentral(oro);
		PlazaCentral otraPlaza = new PlazaCentral(oro);

		jugador.agregarEdificioEn(unaPlaza, 5, 1);
		jugador.agregarEdificioEn(otraPlaza, 10, 1);
		jugador.finalizarTurno();
		jugador.finalizarTurno();
		jugador.finalizarTurno();
		Aldeano aldeano1 = unaPlaza.crearAldeanoDesdePlaza();
		Aldeano aldeano2 = otraPlaza.crearAldeanoDesdePlaza();
		
		Assert.assertNotNull(aldeano1);
		Assert.assertNotNull(aldeano2);
	}
	
	/*-----Test Atacar------*/

	@Test(expected = EdificioObjetivoEsPropioException.class)
	public void test19EspadachinAliadoAtacarEdificioAliadoLanzaExcepcion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador("Alfa", mapa, 1, 1, 1, 5);
		Espadachin espadachin = new Espadachin(oro);
		jugador.agregarUnidadEn(espadachin, 10, 1);
		Cuartel cuartel = new Cuartel(oro);
		jugador.agregarEdificioEn(cuartel, 10, 2);
		
		jugador.atacar(espadachin, cuartel);
	}

	@Test(expected = UnidadObjetivoEsPropiaException.class)
	public void test20EspadachinAliadoAtacarEspadachinAliadoLanzaExcepcion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador("Alfa", mapa, 1, 1, 1, 5);
		Espadachin espadachin1 = new Espadachin(oro);
		Espadachin espadachin2 = new Espadachin(oro);

		jugador.agregarUnidadEn(espadachin1, 5, 1);
		jugador.agregarUnidadEn(espadachin2, 5, 2);
		
		jugador.atacar(espadachin1, espadachin2);
	}

	@Test(expected = UnidadSeleccionadaNoPerteneceAJugadorException.class)
	public void test21EspadachinEnemigoAtacarLanzaExcepcion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador("Alfa", mapa, 1, 1, 1, 5);
		Espadachin espadachin1 = new Espadachin(oro);
		Espadachin espadachin2 = new Espadachin(oro);
		
		jugador.atacar(espadachin1, espadachin2);
	}

	@Test
	public void test22EspadachinAsesinadoSeBorraDePoblacionEnemigo() {
		
		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(30, 30);
		Jugador unJugador = new Jugador("Alfa", mapa, 1, 1, 1, 6);
		Jugador otroJugador = new Jugador("Alfa", mapa, 27, 27, 24, 29);
		unJugador.setOponente(otroJugador);
		otroJugador.setOponente(unJugador);
		Espadachin unEspadachin = new Espadachin(oro);
		Espadachin otroEspadachin = new Espadachin(oro);
		unJugador.agregarUnidadEn(unEspadachin, 15, 15);
		otroJugador.agregarUnidadEn(otroEspadachin, 15, 16);

		for (int i = 0; i < 4; i++) {
			unJugador.atacar(unEspadachin, otroEspadachin);
			unJugador.finalizarTurno();
		}

		Assert.assertEquals(3, otroJugador.getPoblacion());
	}

	/*-----Test MoverHacia-----*/
	
	@Test(expected = CasilleroOcupadoException.class)
	public void test23UnidadSeMueveAOtroCasillero() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador("Alfa", mapa, 1, 1, 1, 5);
		Aldeano unAldeano = new Aldeano(oro);
		Aldeano otroAldeano = new Aldeano(oro);

		jugador.agregarUnidadEn(unAldeano, 1, 5);
		jugador.moverUnidadHacia(unAldeano, 2, 5);

		jugador.agregarUnidadEn(otroAldeano, 2, 5);
	}

	@Test(expected = CasilleroOcupadoException.class)
	public void test24UnidadSeMueveDejaCasilleroVacioYSeAgreganDosUnidadesEnEseCasilleroLanzaExcepcion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador("Alfa", mapa, 1, 1, 1, 5);
		Aldeano unAldeano = new Aldeano(oro);
		Aldeano otroAldeano = new Aldeano(oro);

		jugador.agregarUnidadEn(unAldeano, 10, 5);
		jugador.moverUnidadHacia(unAldeano, 11, 5);

		jugador.agregarUnidadEn(otroAldeano, 10, 5);

		jugador.agregarUnidadEn(new Aldeano(oro), 10, 5);
	}

}
