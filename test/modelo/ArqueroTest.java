package modelo;

import org.junit.Test;

import junit.framework.Assert;
import unidades.Arquero;
import unidades.Espadachin;

public class ArqueroTest {
	
	@Test
	public void test01CreacionDeEspadachin() {
		Arquero arquero = new Arquero();		
		Assert.assertEquals(arquero.getVida(), 75);
		
		}

}
