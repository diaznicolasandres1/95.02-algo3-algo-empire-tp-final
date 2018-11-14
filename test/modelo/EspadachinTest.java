package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import edificios.PlazaCentral;
import junit.framework.Assert;

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
	public void test09CrearEspadachinConOroInsuficiente() {
		Oro oro = new Oro(5);
		Espadachin espadachin = new Espadachin(oro);	
	}
	
	

}
