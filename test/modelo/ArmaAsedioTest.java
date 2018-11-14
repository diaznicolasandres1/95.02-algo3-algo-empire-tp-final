package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import unidades.Aldeano;
import unidades.ArmaDeAsedio;
import unidades.NoSePuedeAtacarArmaAsedioDesmontadaException;
import unidades.NoSePuedeMoverArmaAsedioMontadaException;

public class ArmaAsedioTest {

	@Test
	public void test01CreacionDeArmaAsedio() {
		Oro oro = new Oro(500);
		ArmaDeAsedio arma = new ArmaDeAsedio(oro);		
		Assert.assertEquals(arma.getVida(),150);		
	}
	
	@Test(expected = NoSePuedeMoverArmaAsedioMontadaException.class)
	public void test02MoverArmaMontadaLanzaExcepcion() {
		Oro oro = new Oro(500);
		ArmaDeAsedio arma = new ArmaDeAsedio(oro);	
		arma.montarArma();
		arma.moverse();
		
	}
	
	@Test(expected = NoSePuedeAtacarArmaAsedioDesmontadaException.class)
	public void test03AtacarConArmaDesmontada() {
		Oro oro = new Oro(500);
		ArmaDeAsedio arma = new ArmaDeAsedio(oro);			
		arma.atacar();		
	}
	
	@Test 
	public void test04CrearArmaSedioCuestaOro() {
		Oro oro = new Oro(500);
		ArmaDeAsedio arma = new ArmaDeAsedio(oro);
		Assert.assertEquals(oro.getOro(), 300);
	}
	
	@Test(expected = NoTenesOroSuficienteException.class)
	public void test05CrearArmaSinOroDisponible() {
		Oro oro = new Oro(5);
		ArmaDeAsedio arma = new ArmaDeAsedio(oro);
		
	}
	
}

	

	

