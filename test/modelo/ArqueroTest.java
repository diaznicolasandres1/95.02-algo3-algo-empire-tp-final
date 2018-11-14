package modelo;

import org.junit.Test;

import junit.framework.Assert;
import unidades.Arquero;
import unidades.Espadachin;

public class ArqueroTest {
	
	@Test
	public void test01CreacionDeArquero() {
		Oro oro = new Oro(300);
		Arquero arquero = new Arquero(oro);		
		Assert.assertEquals(arquero.getVida(), 75);
		
		}

}
