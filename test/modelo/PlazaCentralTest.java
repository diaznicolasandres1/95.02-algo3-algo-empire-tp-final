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
	public void test02PlazaCentralRecibirDanio() {
		PlazaCentral plaza = new PlazaCentral();
		plaza.recibirDanio(50);
		Assert.assertEquals(plaza.getVida(), 400);
		
		
	}
	
	@Test
	public void test03PlazaCentralRecibirDanioYRepararse() {
		PlazaCentral plaza = new PlazaCentral();
		plaza.recibirDanio(50);
		plaza.repararse();
		Assert.assertEquals(plaza.getVida(), 425);
		
		
	}
	
	@Test
	public void test04PlazaCentralRecibirDanioYRepararseVariasVecesNoSuperaVidaMaxima() {
		PlazaCentral plaza = new PlazaCentral();
		plaza.recibirDanio(50);
		plaza.repararse();
		plaza.repararse();
		plaza.repararse();
		plaza.repararse();
		plaza.repararse();
		Assert.assertEquals(plaza.getVida(), 450);	
		
	}
	
	@Test
	public void test05CrearAldeanoDesdePlazaCentral() {
		PlazaCentral plaza = new PlazaCentral();
		Aldeano aldeano = plaza.crearAldeanoDesdePlaza();
		Assert.assertEquals(aldeano.getVida(), 50);
		
	}
	
	

}
