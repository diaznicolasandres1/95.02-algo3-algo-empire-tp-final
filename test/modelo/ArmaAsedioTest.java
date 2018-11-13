package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import unidades.Aldeano;
import unidades.ArmaDeAsedio;

public class ArmaAsedioTest {

	@Test
	public void test01CreacionDeArmaAsedio() {
		ArmaDeAsedio arma = new ArmaDeAsedio();		
		Assert.assertEquals(arma.getVida(),150);
		
	}
	
}

	

	

