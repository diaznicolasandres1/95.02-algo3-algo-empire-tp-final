import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClasePruebaTest {

	@Test
	public void pruebaOKTest() {
		ClasePrueba instanciaPrueba = new ClasePrueba();
		String resultado = instanciaPrueba.retornoOk();
        assertEquals("Ok", resultado);
	}
}
