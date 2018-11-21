package modelo;

import modelo.Estructuras;
import modelo.edificios.Edificio;
import modelo.edificios.PlazaCentral;
import modelo.edificios.PlazaCentralEnConstruccionException;
import modelo.unidades.aldeano.Aldeano;
import modelo.Oro;
import modelo.Poblacion;

import org.junit.Assert;
import org.junit.Test;

public class EstructurasTest {

	@Test
	public void test01EstructurasSeCreaSinEdificios() {
		Estructuras estructuras = new Estructuras();
		
		Assert.assertEquals(0, estructuras.getCantidad());
	}

	@Test
	public void test02AgregarEdificioAumentaCantidadDeEdificios() {
		Estructuras estructuras = new Estructuras();
		Oro oro = new Oro(100);
		PlazaCentral plaza = new PlazaCentral(oro);
		estructuras.agregarEdificio(plaza);
		
		Assert.assertEquals(1, estructuras.getCantidad());
	}
	
	@Test
	public void test03AgregarEdificioPerteneceAEstructuras() {
		Estructuras estructuras = new Estructuras();
		Oro oro = new Oro(100);
		PlazaCentral plaza = new PlazaCentral(oro);
		estructuras.agregarEdificio(plaza);
		
		Assert.assertTrue(estructuras.perteneceEdificio(plaza));
	}
	

	@Test(expected = PlazaCentralEnConstruccionException.class)
	public void test04AvanzarTurnoConEdificioSigueEnContruccion() {
		Estructuras estructuras = new Estructuras();
		Oro oro = new Oro(100);
		PlazaCentral plaza = new PlazaCentral(oro);
		estructuras.agregarEdificio(plaza);
		estructuras.avanzarTurno();
		Aldeano aldeano = plaza.crearAldeanoDesdePlaza();	
	}

	@Test
	public void test05AvanzarTurnoConEdificioCambiaACreado() {
		Estructuras estructuras = new Estructuras();
		Oro oro = new Oro(125);
		PlazaCentral plaza = new PlazaCentral(oro);
		estructuras.agregarEdificio(plaza);
		for(int i=0; i<5; i++) {
			estructuras.avanzarTurno();
		}
		Aldeano aldeano = plaza.crearAldeanoDesdePlaza();
		
		Assert.assertNotNull(aldeano);
	}
	
	@Test
	public void test06AvanzarTurnoBorraEdificiosDestruidos() {
		Estructuras estructuras = new Estructuras();
		Oro oro = new Oro(100);
		PlazaCentral plaza = new PlazaCentral(oro);
		estructuras.agregarEdificio(plaza);
		estructuras.avanzarTurno();
		estructuras.avanzarTurno();
		estructuras.avanzarTurno();
		plaza.recibirDanioPlazaCentral(450);
		estructuras.avanzarTurno();
		
		Assert.assertEquals(0, estructuras.getCantidad());
	}
	
	@Test
	public void test08AvanzarTurnoBorraSoloEdificiosDestruidos() {
		Estructuras estructuras = new Estructuras();
		Oro oro = new Oro(200);
		PlazaCentral plaza1 = new PlazaCentral(oro);
		PlazaCentral plaza2 = new PlazaCentral(oro);
		estructuras.agregarEdificio(plaza1);
		estructuras.agregarEdificio(plaza2);
		estructuras.avanzarTurno();
		estructuras.avanzarTurno();
		estructuras.avanzarTurno();
		plaza2.recibirDanioPlazaCentral(450);
		estructuras.avanzarTurno();
		
		Assert.assertEquals(1, estructuras.getCantidad());
	}


}