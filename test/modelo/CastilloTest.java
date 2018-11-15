package modelo;
import edificios.Castillo;
import edificios.EdificioTieneVidaMaximaException;
import junit.framework.Assert;

import static org.junit.Assert.*;

import org.junit.Test;



public class CastilloTest {

	@Test
	public void test01crearCastillo() {
		Oro oro = new Oro(1000);
		Castillo castillo = new Castillo(oro);
		Assert.assertEquals(1000, castillo.getVida());
	}
	
	@Test 
	public void test02CastilloRecibeDanio(){
		Oro oro = new Oro(1000);
		Castillo castillo = new Castillo(oro);
		castillo.recibirDanioConValor(500);
		Assert.assertEquals(500, castillo.getVida());
		
	}
	
	@Test
	public void test03CastilloRecibeDanioYSeCuraASiMismo() {
		Oro oro = new Oro(1000);
		Castillo castillo = new Castillo(oro);
		castillo.recibirDanioConValor(50);
		castillo.repararseASimismo();
		Assert.assertEquals(965, castillo.getVida());		
		
	}
	
	@Test(expected = EdificioTieneVidaMaximaException.class)
	public void test04castilloLanzaExcepcionSiSeLoQuiereSeguirReparandoConVidaMaxima() {
		Oro oro = new Oro(1000);
		Castillo castillo = new Castillo(oro);
		castillo.recibirDanioConValor(50);
		castillo.repararseASimismo();
		castillo.repararseASimismo();
		castillo.repararseASimismo();
		castillo.repararseASimismo();
		castillo.repararseASimismo();
		castillo.repararseASimismo();
		castillo.repararseASimismo();
		castillo.repararseASimismo();
		castillo.repararseASimismo();
		castillo.repararseASimismo();
		castillo.repararseASimismo();		
	}

}
