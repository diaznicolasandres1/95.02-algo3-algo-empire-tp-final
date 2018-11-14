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

	
	@Test 
	public void test02CreacionDeArqueroCuestaOro() {
		Oro oro = new Oro(300);
		Arquero arquero = new Arquero(oro);	
		Assert.assertEquals(oro.getOro(), 225);
		
	}

	@Test(expected = NoTenesOroSuficienteException.class)
	public void test09CrearEspadachinConOroInsuficiente() {
		Oro oro = new Oro(5);
		Espadachin espadachin = new Espadachin(oro);	
	}
	
	
	
}
