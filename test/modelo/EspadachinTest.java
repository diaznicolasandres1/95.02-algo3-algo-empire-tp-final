package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

import unidades.Espadachin;

public class EspadachinTest {

	@Test
	public void test01CreacionDeEspadachin() {
		Oro oro = new Oro(500);		
		Espadachin espadachin = new Espadachin(oro);
		Assert.assertEquals(espadachin.getVida(), 100);
		
		}
	

}
