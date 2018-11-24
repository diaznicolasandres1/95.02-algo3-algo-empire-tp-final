package modelo.juego;

import modelo.excepciones.*;
import modelo.edificios.plazacentral.PlazaCentralEnConstruccionException;
import modelo.edificios.castillo.Castillo;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.excepciones.CasilleroOcupadoException;
import modelo.juego.Jugador;
import modelo.juego.Oro;
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
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);

		Assert.assertEquals(100, jugador.getOro());
	}

	@Test
	public void test02CantidadDeUnidadesInicialEs3() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);

		Assert.assertEquals(3, jugador.getPoblacion());
	}

	@Test
	public void test03CantidadDeEdificiosInicialEs2() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);

		Assert.assertEquals(2, jugador.getCantidadDeEdificios());
	}
	
	@Test(expected = CasilleroOcupadoException.class)
	public void test04PlazaInicialSeColocaCorrectamente() {
		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);
		Aldeano aldeano = new Aldeano(oro);
		
		jugador.agregarUnidadEn(aldeano, 1, 1);
	}
	
	@Test(expected = CasilleroOcupadoException.class)
	public void test05CastilloInicialSeColocaCorrectamente() {
		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);
		Aldeano aldeano = new Aldeano(oro);
		
		jugador.agregarUnidadEn(aldeano, 1, 5);
	}

	/*-----Test crear unidades-----*/
	
	@Test(expected = EdificioElegidoNoEsAliadoException.class)
	public void test06CrearAldeanoDesdePlazaNoAliadaLanzaExcepcion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);
		PlazaCentral plaza = new PlazaCentral(oro);
		
		jugador.crearAldeano(plaza);
	}
	
	@Test(expected = UnidadElegidaNoEsAliadaException.class)
	public void test07ContruirPLazaDesdeAldeanoNoAliadoLanzaException() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);
		Aldeano aldeano = new Aldeano(oro);
		
		jugador.construirPlazaCentral(aldeano, 2, 5);
	}
	
	@Test(expected = LimiteDePoblacionAlcanzadoException.class)
	public void test04CrearUnidadConLimiteDePoblacionAlcanzadoLanzaExcepcion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);
		PlazaCentral plaza = new PlazaCentral(oro);
		jugador.agregarEdificioEn(plaza, 5, 1);
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		
		for (int i = 0; i < 50; i++) {
			jugador.crearAldeano(plaza);
		}
	}
		
	@Test
	public void test04CrearAldeanoDesdePlazaAumentaPoblacion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);
		PlazaCentral plaza = new PlazaCentral(oro);
		jugador.agregarEdificioEn(plaza, 5, 1);
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		jugador.avanzarTurno();

		jugador.crearAldeano(plaza);

		Assert.assertEquals(4, jugador.getPoblacion());
	}

	@Test
	public void test05CrearEspadachinDesdeCuartelAumentaPoblacion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);
		Cuartel cuartel = new Cuartel(oro);
		jugador.agregarEdificioEn(cuartel, 5, 1);
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		jugador.avanzarTurno();

		jugador.crearEspadachin(cuartel);

		Assert.assertEquals(4, jugador.getPoblacion());
	}

	@Test
	public void test06CrearArqueroDesdeCuartelAumentaPoblacion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);
		Cuartel cuartel = new Cuartel(oro);
		jugador.agregarEdificioEn(cuartel, 5, 1);
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		jugador.avanzarTurno();

		jugador.crearArquero(cuartel);

		Assert.assertEquals(4, jugador.getPoblacion());
	}

	@Test
	public void testCrearArmaDeAsedioDesdeCastilloAumentaPoblacion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);
		Castillo castillo = new Castillo(oro);
		jugador.agregarEdificioEn(castillo, 5, 1);

		jugador.crearArmaDeAsedio(castillo);

		Assert.assertEquals(4, jugador.getPoblacion());

	}
	
	/*-----Test crear Edificios-----*/
	
	@Test(expected = CasilleroOcupadoException.class)
	public void testContruirPlazaLoUbicaCorrectamente() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);
		Aldeano aldeano = new Aldeano(oro);
		jugador.agregarUnidadEn(aldeano, 5, 1);
		jugador.construirPlazaCentral(aldeano, 2, 5);
		
		jugador.agregarUnidadEn(aldeano, 2, 5);
	}
	
	@Test(expected = CasilleroOcupadoException.class)
	public void testContruirCuartelLoUbicaCorrectamente() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);
		Aldeano aldeano = new Aldeano(oro);
		jugador.agregarUnidadEn(aldeano, 5, 1);
		jugador.construirCuartel(aldeano, 2, 5);
		
		jugador.agregarUnidadEn(aldeano, 2, 5);
	}
/*
	@Test(expected = EdificioTieneVidaMaximaException.class)
	public void testAldeanoReparaEdificioConVidaLlena() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);
		Aldeano aldeano = new Aldeano(oro);
		PlazaCentral plaza = new PlazaCentral(oro);
		jugador.agregarUnidadEn(aldeano, 5, 1);
		jugador.agregarEdificioEn(plaza, 5, 2);
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		
		jugador.repararEdificio(aldeano, plaza);
	}
*/
	/*-----Test AvanzarTurno-----*/
	
	@Test(expected = PlazaCentralEnConstruccionException.class)
	public void testAvanzarTurnoAvanzaConstruccionDePlaza() {
		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);
		PlazaCentral plaza = new PlazaCentral(oro);
		jugador.agregarEdificioEn(plaza, 5, 1);
		jugador.avanzarTurno();
		
		Aldeano aldeano = plaza.crearAldeanoDesdePlaza();	
	}
	
	@Test
	public void testAvanzarTurnoAvanza3VecesTerminaConstruccionDePlaza() {
		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);
		PlazaCentral plaza = new PlazaCentral(oro);
		jugador.agregarEdificioEn(plaza, 5, 1);
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		Aldeano aldeano = plaza.crearAldeanoDesdePlaza();
		
		Assert.assertNotNull(aldeano);
	}

	@Test
	public void testAvanzarTurnoAvanza3VecesTerminaConstruccionDe2Plazas() {
		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);
		PlazaCentral plaza1 = new PlazaCentral(oro);
		PlazaCentral plaza2 = new PlazaCentral(oro);
		jugador.agregarEdificioEn(plaza1, 5, 1);
		jugador.agregarEdificioEn(plaza2, 10, 1);
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		Aldeano aldeano1 = plaza1.crearAldeanoDesdePlaza();
		Aldeano aldeano2 = plaza2.crearAldeanoDesdePlaza();
		
		Assert.assertNotNull(aldeano1);
		Assert.assertNotNull(aldeano2);
	}
	
	/*-----Test Atacar------*/

	@Test(expected = EdificioObjetivoEsAliadoException.class)
	public void testEspadachinAliadoAtacarEdificioAliadoLanzaExcepcion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);
		Espadachin espadachin = new Espadachin(oro);
		jugador.agregarUnidadEn(espadachin, 10, 1);
		Cuartel cuartel = new Cuartel(oro);
		jugador.agregarEdificioEn(cuartel, 10, 2);
		
		jugador.atacar(espadachin, cuartel);
	}
	
	@Test(expected = UnidadObjetivoEsAliadaException.class)
	public void testEspadachinAliadoAtacarEspadachinAliadoLanzaExcepcion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);
		Espadachin espadachin1 = new Espadachin(oro);
		Espadachin espadachin2 = new Espadachin(oro);
		jugador.agregarUnidadEn(espadachin1, 5, 1);
		jugador.agregarUnidadEn(espadachin2, 5, 2);
		
		jugador.atacar(espadachin1, espadachin2);
	}
	
	@Test(expected = UnidadElegidaNoEsAliadaException.class)
	public void testEspadachinEnemigoAtacarLanzaExcepcion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);
		Espadachin espadachin1 = new Espadachin(oro);
		Espadachin espadachin2 = new Espadachin(oro);
		
		jugador.atacar(espadachin1, espadachin2);
	}
	
	/*-----Test MoverHacia-----*/
	
	@Test(expected = CasilleroOcupadoException.class)
	public void testUnidadSeMueveAOtroCasillero() {
		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);
		Aldeano aldeano1 = new Aldeano(oro);
		Aldeano aldeano2 = new Aldeano(oro);
		jugador.agregarUnidadEn(aldeano1, 1, 5);
		jugador.moverUnidadHacia(aldeano1, 2, 5);
		
		jugador.agregarUnidadEn(aldeano2, 2, 5);
	}
	
	public void testUnidadSeMueveYDejaCasilleroVacio() {
		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Jugador jugador = new Jugador(mapa, 1, 1, 1, 5);
		Aldeano aldeano1 = new Aldeano(oro);
		Aldeano aldeano2 = new Aldeano(oro);
		jugador.agregarUnidadEn(aldeano1, 1, 5);
		jugador.moverUnidadHacia(aldeano1, 2, 5);
		
		jugador.agregarUnidadEn(aldeano2, 1, 5);
		
	}
	
	
}
