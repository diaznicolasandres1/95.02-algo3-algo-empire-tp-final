package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import edificios.PlazaCentral;
import junit.framework.Assert;
import unidades.Aldeano;

public class PlazaCentralTest {

	@Test
	public void test01CreacionDePlazaCentral() {
		PlazaCentral plaza = new PlazaCentral();
		Assert.assertEquals(plaza.getVida(), 450);
		
		
	}
	
	@Test
	public void test02PlazaCentralEnConstruccionNoRecibeDanio() {
		PlazaCentral plaza = new PlazaCentral();
		plaza.recibirDanio(50);
		Assert.assertEquals(plaza.getVida(), 450);
		
		
	}
	
	@Test
	public void test03PlazaCentralConstruidaRecibeDanio() {
		PlazaCentral plaza = new PlazaCentral();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		/*Avanzo 3 turnos y como esta creada recibe daño*/
		plaza.recibirDanio(50);
		Assert.assertEquals(plaza.getVida(), 400);
		
		
	}



	@Test
	public void test04PlazaCentralRecibirDanioYRepararse() {
		PlazaCentral plaza = new PlazaCentral();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		
		plaza.recibirDanio(50);
		plaza.repararse();
		Assert.assertEquals(plaza.getVida(), 425);
		
		
	}
	
	@Test
	public void test05PlazaCentralRecibirDanioYRepararseVariasVecesNoSuperaVidaMaxima() {
		PlazaCentral plaza = new PlazaCentral();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.recibirDanio(50);
		plaza.repararse();
		plaza.repararse();
		plaza.repararse();
		plaza.repararse();
		plaza.repararse();
		Assert.assertEquals(plaza.getVida(), 450);	
		
	}
	
	@Test
	public void test06CrearAldeanoDesdePlazaCentral() {
		PlazaCentral plaza = new PlazaCentral();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		Aldeano aldeano = plaza.crearAldeanoDesdePlaza();
		Assert.assertEquals(aldeano.getVida(), 50);
		
	}
	
	

}
