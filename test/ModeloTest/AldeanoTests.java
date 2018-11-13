package ModeloTest;


import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Oro;
import Unidades.Aldeano;
import junit.framework.Assert;

public class AldeanoTests {

	@Test
	public void test01CreacionDeAldeano() {
		Aldeano aldeano = new Aldeano();		
		Assert.assertEquals(aldeano.getVida(), 50);
		
		}
	
		
		@Test
		public void test02AldeeanoDisponibleSumaOro() {
			Aldeano aldeano = new Aldeano();
			Oro oro = new Oro(100);
			aldeano.recolectarOro(oro);
			int cantidadOro = oro.getOro();
			Assert.assertEquals(125, cantidadOro);
			
			
		}
		
		public void test03AldeanoOcupadoNoSumaOro() {
			Aldeano aldeano = new Aldeano();
			Oro oro = new Oro(100);
			aldeano.estarOcupado();
			aldeano.recolectarOro(oro);
			int cantidadOro = oro.getOro();
			Assert.assertEquals(100, cantidadOro);
			
		}
	

}
