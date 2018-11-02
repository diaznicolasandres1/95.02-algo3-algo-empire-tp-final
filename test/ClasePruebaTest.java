import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class ClasePruebaTest {

	@Test
	public void pruebaOKTest() {
		ClasePrueba instanciaPrueba = new ClasePrueba();
		String resultado = instanciaPrueba.retornoOk();
		Assert.assertEquals("Ok", resultado);
	}
}
