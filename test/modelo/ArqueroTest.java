package modelo;

import junit.framework.Assert;
import org.junit.Test;
import unidades.Arquero;

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
    public void test03CrearArqueroConOroInsuficiente() {

		Oro oro = new Oro(5);

        Arquero arquero = new Arquero(oro);
    }

    @Test(expected = PosicionFueraDeRangoException.class)
    public void test04arqueroSeMueveFueraDeRangoYLanzaExcepcion() {

        Oro oro = new Oro(300);
        Arquero arquero = new Arquero(oro);
        Posicion unaPosicion = new Posicion(5, 5);
        Posicion otraPosicion = new Posicion(10, 10);

        arquero.setPosicion(unaPosicion);

        arquero.moverHacia(otraPosicion);
    }
}
