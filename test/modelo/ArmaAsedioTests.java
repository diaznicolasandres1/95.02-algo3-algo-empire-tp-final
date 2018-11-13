package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import unidades.Aldeano;
import unidades.ArmaDeAsedio;

public class ArmaAsedioTests {

	@Test
	public void test01CreacionDeArmaAsedio() {
		ArmaDeAsedio arma = new ArmaDeAsedio();		
		Assert.assertEquals(arma.getVida(),150);
		
	}
	
	@Test
	public void test02ArmaSeCreaDesmontadaYSePuedeMover() {
		ArmaDeAsedio arma = new ArmaDeAsedio();	
		boolean mePuedoMover = arma.mePuedoMover();
		Assert.assertEquals(true,mePuedoMover);
		
	}
	
	@Test
	public void test03ArmaDesmontadaNoSePuedeMover() {
		ArmaDeAsedio arma = new ArmaDeAsedio();	
		arma.montarArma();
		boolean mePuedoMover = arma.mePuedoMover();
		Assert.assertEquals(false,mePuedoMover);	
		
	}
	
	@Test
	public void test04ArmaDesmontadaYLuegoMontadaSePuedeMover() {
		ArmaDeAsedio arma = new ArmaDeAsedio();	
		arma.montarArma();
		boolean mePuedoMover = arma.mePuedoMover();		
		Assert.assertEquals(false,mePuedoMover);	
		arma.desmontarArma();
		Assert.assertEquals(arma.mePuedoMover(), true);
		
	}
	

	

}
