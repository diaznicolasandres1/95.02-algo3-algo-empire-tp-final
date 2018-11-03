import junit.framework.Assert;
import org.junit.Test;

public class ClasePruebaTest {

	@Test
	public void pruebaOKTest() {

		ClasePrueba instanciaPrueba = new ClasePrueba();
		String resultado = instanciaPrueba.retornoOk();
        Assert.assertEquals("Ok", resultado);

	}
}
