package modelo.juego;

import modelo.excepciones.OroInsuficienteException;
import org.junit.Test;

import junit.framework.Assert;

public class OroTest {

	@Test
	public void test01crearOroCon100Disponible() {
		Oro oro = new Oro(100);
		Assert.assertEquals(oro.getOro(),100);
	}
	
	@Test
	public void test02CrearOroYAniadirOro() {
		Oro oro = new Oro(100);
		oro.sumarOro(100);
		Assert.assertEquals(oro.getOro(),200);
	}
	
	@Test
	public void test03CrearOroYRestarrOro() {
		Oro oro = new Oro(100);
		oro.restarOro(50);
		Assert.assertEquals(oro.getOro(),50);
	}

	@Test(expected = OroInsuficienteException.class)
	public void test03RestarMasOroDelQueTengo() {
		Oro oro = new Oro(100);
		oro.restarOro(150);
		
	}

}
