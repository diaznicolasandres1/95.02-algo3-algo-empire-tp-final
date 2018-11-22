package modelo;

import modelo.Civilizacion;
import modelo.EdificioElegidoNoEsAliadoException;
import modelo.LimiteDePoblacionAlcanzadoException;
import modelo.edificios.plazacentral.PlazaCentralEnConstruccionException;
import modelo.UnidadElegidaNoEsAliadaException;
import modelo.edificios.Castillo;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.mapa.CasilleroOcupadoException;
import modelo.mapa.Mapa;
import modelo.Oro;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.espadachin.Espadachin;;

import org.junit.Assert;
import org.junit.Test;

public class CivilizacionTest {

	/*-----Test inicializacion-----*/
	
	@Test
	public void test01OroInicialEs100() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);

		Assert.assertEquals(100, civilizacion.getOro());
	}

	@Test
	public void test02CantidadDeUnidadesInicialEs3() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);

		Assert.assertEquals(3, civilizacion.getPoblacion());
	}

	@Test
	public void test03CantidadDeEdificiosInicialEs2() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);

		Assert.assertEquals(2, civilizacion.getCantidadDeEdificios());
	}
	
	@Test(expected = CasilleroOcupadoException.class)
	public void test04PlazaInicialSeColocaCorrectamente() {
		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		Aldeano aldeano = new Aldeano(oro);
		
		civilizacion.agregarUnidadEn(aldeano, 1, 1);
	}
	
	@Test(expected = CasilleroOcupadoException.class)
	public void test05CastilloInicialSeColocaCorrectamente() {
		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		Aldeano aldeano = new Aldeano(oro);
		
		civilizacion.agregarUnidadEn(aldeano, 1, 5);
	}

	/*-----Test crear unidades-----*/
	
	@Test(expected = EdificioElegidoNoEsAliadoException.class)
	public void test06CrearAldeanoDesdePlazaNoAliadaLanzaExcepcion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		PlazaCentral plaza = new PlazaCentral(oro);
		
		civilizacion.crearAldeano(plaza);
	}
	
	@Test(expected = UnidadElegidaNoEsAliadaException.class)
	public void test07ContruirPLazaDesdeAldeanoNoAliadoLanzaException() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		Aldeano aldeano = new Aldeano(oro);
		
		civilizacion.construirPlazaCentral(aldeano, 2, 5);
	}
	
	@Test(expected = LimiteDePoblacionAlcanzadoException.class)
	public void test04CrearUnidadConLimiteDePoblacionAlcanzadoLanzaExcepcion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		PlazaCentral plaza = new PlazaCentral(oro);
		civilizacion.agregarEdificioEn(plaza, 5, 1);
		civilizacion.avanzarTurno();
		civilizacion.avanzarTurno();
		civilizacion.avanzarTurno();
		
		for (int i = 0; i < 50; i++) {
			civilizacion.crearAldeano(plaza);
		}
	}
		
	@Test
	public void test04CrearAldeanoDesdePlazaAumentaPoblacion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		PlazaCentral plaza = new PlazaCentral(oro);
		civilizacion.agregarEdificioEn(plaza, 5, 1);
		civilizacion.avanzarTurno();
		civilizacion.avanzarTurno();
		civilizacion.avanzarTurno();

		civilizacion.crearAldeano(plaza);

		Assert.assertEquals(4, civilizacion.getPoblacion());
	}

	@Test
	public void test05CrearEspadachinDesdeCuartelAumentaPoblacion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		Cuartel cuartel = new Cuartel(oro);
		civilizacion.agregarEdificioEn(cuartel, 5, 1);
		civilizacion.avanzarTurno();
		civilizacion.avanzarTurno();
		civilizacion.avanzarTurno();

		civilizacion.crearEspadachin(cuartel);

		Assert.assertEquals(4, civilizacion.getPoblacion());
	}

	@Test
	public void test06CrearArqueroDesdeCuartelAumentaPoblacion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		Cuartel cuartel = new Cuartel(oro);
		civilizacion.agregarEdificioEn(cuartel, 5, 1);
		civilizacion.avanzarTurno();
		civilizacion.avanzarTurno();
		civilizacion.avanzarTurno();

		civilizacion.crearArquero(cuartel);

		Assert.assertEquals(4, civilizacion.getPoblacion());
	}

	@Test
	public void testCrearArmaDeAsedioDesdeCastilloAumentaPoblacion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		Castillo castillo = new Castillo(oro);
		civilizacion.agregarEdificioEn(castillo, 5, 1);

		civilizacion.crearArmaDeAsedio(castillo);

		Assert.assertEquals(4, civilizacion.getPoblacion());

	}
	
	/*-----Test crear Edificios-----*/
	
	@Test(expected = CasilleroOcupadoException.class)
	public void testContruirPlazaLoUbicaCorrectamente() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		Aldeano aldeano = new Aldeano(oro);
		civilizacion.agregarUnidadEn(aldeano, 5, 1);
		civilizacion.construirPlazaCentral(aldeano, 2, 5);
		
		civilizacion.agregarUnidadEn(aldeano, 2, 5);
	}
	
	@Test(expected = CasilleroOcupadoException.class)
	public void testContruirCuartelLoUbicaCorrectamente() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		Aldeano aldeano = new Aldeano(oro);
		civilizacion.agregarUnidadEn(aldeano, 5, 1);
		civilizacion.construirCuartel(aldeano, 2, 5);
		
		civilizacion.agregarUnidadEn(aldeano, 2, 5);
	}
/*
	@Test(expected = EdificioTieneVidaMaximaException.class)
	public void testAldeanoReparaEdificioConVidaLlena() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		Aldeano aldeano = new Aldeano(oro);
		PlazaCentral plaza = new PlazaCentral(oro);
		civilizacion.agregarUnidadEn(aldeano, 5, 1);
		civilizacion.agregarEdificioEn(plaza, 5, 2);
		civilizacion.avanzarTurno();
		civilizacion.avanzarTurno();
		civilizacion.avanzarTurno();
		
		civilizacion.repararEdificio(aldeano, plaza);
	}
*/
	/*-----Test AvanzarTurno-----*/
	
	@Test(expected = PlazaCentralEnConstruccionException.class)
	public void testAvanzarTurnoAvanzaConstruccionDePlaza() {
		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		PlazaCentral plaza = new PlazaCentral(oro);
		civilizacion.agregarEdificioEn(plaza, 5, 1);
		civilizacion.avanzarTurno();
		
		Aldeano aldeano = plaza.crearAldeanoDesdePlaza();	
	}
	
	@Test
	public void testAvanzarTurnoAvanza3VecesTerminaConstruccionDePlaza() {
		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		PlazaCentral plaza = new PlazaCentral(oro);
		civilizacion.agregarEdificioEn(plaza, 5, 1);
		civilizacion.avanzarTurno();
		civilizacion.avanzarTurno();
		civilizacion.avanzarTurno();
		Aldeano aldeano = plaza.crearAldeanoDesdePlaza();
		
		Assert.assertNotNull(aldeano);
	}

	@Test
	public void testAvanzarTurnoAvanza3VecesTerminaConstruccionDe2Plazas() {
		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		PlazaCentral plaza1 = new PlazaCentral(oro);
		PlazaCentral plaza2 = new PlazaCentral(oro);
		civilizacion.agregarEdificioEn(plaza1, 5, 1);
		civilizacion.agregarEdificioEn(plaza2, 10, 1);
		civilizacion.avanzarTurno();
		civilizacion.avanzarTurno();
		civilizacion.avanzarTurno();
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
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		Espadachin espadachin = new Espadachin(oro);
		civilizacion.agregarUnidadEn(espadachin, 10, 1);
		Cuartel cuartel = new Cuartel(oro);
		civilizacion.agregarEdificioEn(cuartel, 10, 2);
		
		civilizacion.atacar(espadachin, cuartel);
	}
	
	@Test(expected = UnidadObjetivoEsAliadaException.class)
	public void testEspadachinAliadoAtacarEspadachinAliadoLanzaExcepcion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		Espadachin espadachin1 = new Espadachin(oro);
		Espadachin espadachin2 = new Espadachin(oro);
		civilizacion.agregarUnidadEn(espadachin1, 5, 1);
		civilizacion.agregarUnidadEn(espadachin2, 5, 2);
		
		civilizacion.atacar(espadachin1, espadachin2);
	}
	
	@Test(expected = UnidadElegidaNoEsAliadaException.class)
	public void testEspadachinEnemigoAtacarLanzaExcepcion() {

		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		Espadachin espadachin1 = new Espadachin(oro);
		Espadachin espadachin2 = new Espadachin(oro);
		
		civilizacion.atacar(espadachin1, espadachin2);
	}
	
	/*-----Test MoverHacia-----*/
	
	@Test(expected = CasilleroOcupadoException.class)
	public void testUnidadSeMueveAOtroCasillero() {
		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		Aldeano aldeano1 = new Aldeano(oro);
		Aldeano aldeano2 = new Aldeano(oro);
		civilizacion.agregarUnidadEn(aldeano1, 1, 5);
		civilizacion.moverUnidadHacia(aldeano1, 2, 5);
		
		civilizacion.agregarUnidadEn(aldeano2, 2, 5);
	}
	
	public void testUnidadSeMueveYDejaCasilleroVacio() {
		Oro oro = new Oro(2000);
		Mapa mapa = new Mapa(15, 15);
		Civilizacion civilizacion = new Civilizacion(mapa, 1, 1, 1, 5);
		Aldeano aldeano1 = new Aldeano(oro);
		Aldeano aldeano2 = new Aldeano(oro);
		civilizacion.agregarUnidadEn(aldeano1, 1, 5);
		civilizacion.moverUnidadHacia(aldeano1, 2, 5);
		
		civilizacion.agregarUnidadEn(aldeano2, 1, 5);
		
	}
	
	
}
