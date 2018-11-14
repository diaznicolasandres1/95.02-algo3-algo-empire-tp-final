package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

import unidades.Espadachin;

public class EspadachinTest {

	@Test
	public void test01CreacionDeEspadachin() {
		Espadachin espadachin = new Espadachin();		
		Assert.assertEquals(espadachin.getVida(), 100);
		
		}
	

}
