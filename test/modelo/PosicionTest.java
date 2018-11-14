package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import static junit.framework.Assert;

import modelo.Posicion;

public class PosicionTest {

	@Test
	public void testDentroRangoDevuelveTrue() {
		Posicion pos1 = new Posicion(1,1);
		Posicion pos2 = new Posicion(1,2);
		Asssert.assertTrue(pos1.dentroRango(pos2, 3));
	}
		
	@Test
	public void testDentroRangoLimiteDevuelveTrue() {
		Posicion pos1 = new Posicion(1,1);
		Posicion pos2 = new Posicion(1,6);
		Assert.assertTrue(pos1.dentroRango(pos2, 5));
	}
	
	@Test
	public void testFueraRangoDevuelveFalse() {
		Posicion pos1 = new Posicion(1,1);
		Posicion pos2 = new Posicion(1,7);
		Assert.assertFalse(pos1.dentroRango(pos2, 5));
	}
	
	@Test
	public void testDentroRangoMenorDevuelveFalse() {
		Posicion pos1 = new Posicion(1,1);
		Posicion pos2 = new Posicion(1,6);
		Assert.assertFalse(pos1.dentroRango(pos2, 4));
	}
	
	@Test
	public void testDentroRangoDiagonalDevuelveTrue() {
		Posicion pos1 = new Posicion(1,1);
		Posicion pos2 = new Posicion(6,6);
		Assert.assertTrue(pos1.dentroRango(pos2, 5));
	}
	
	@Test
	public void testFueraRangoDiagonalDevuelveFalse() {
		Posicion pos1 = new Posicion(1,1);
		Posicion pos2 = new Posicion(7,7);
		Assert.assertFalse(pos1.dentroRango(pos2, 5));
	}


}
