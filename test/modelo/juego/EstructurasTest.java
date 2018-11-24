package modelo.juego;

import modelo.juego.Estructuras;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.edificios.plazacentral.PlazaCentralEnConstruccionException;
import modelo.unidades.aldeano.Aldeano;
import modelo.juego.Oro;

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
	public void test06EdificioRemovidoYaNoPertenece() {
		Estructuras estructuras = new Estructuras();
		Oro oro = new Oro(100);
		PlazaCentral plaza = new PlazaCentral(oro);
		estructuras.agregarEdificio(plaza);
		estructuras.removerEdificio(plaza);
		
		Assert.assertFalse(estructuras.perteneceEdificio(plaza));
	}
	
	

}