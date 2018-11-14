package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import edificios.Cuartel;
import edificios.CuartelCreandoseException;
import edificios.PlazaCentral;
import junit.framework.Assert;
import unidades.Arquero;
import unidades.Espadachin;
import unidades.NoSePuedeAtacarArmaAsedioDesmontadaException;

public class CuartelTest {

	@Test
	public void test01CrearCuartel() {
		Cuartel cuartel = new Cuartel();
		Assert.assertEquals(cuartel.getVida(), 250);
	}
	
	@Test(	expected = CuartelCreandoseException.class)
	public void test02CuartelEnConstruccionNoRecibeDanio() {
		Cuartel cuartel = new Cuartel();
		cuartel.recibirDanio(50);		
		
	}
	
	@Test
	public void test03CuartelConstruidoRecibeDanio() {
		Cuartel cuartel = new Cuartel();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		/*Avanzo 3 turnos y como esta creada recibe daño*/
		cuartel.recibirDanio(50);
		Assert.assertEquals(cuartel.getVida(), 200);		
		
	}
	

	@Test
	public void test04CuartelRecibirDanioYRepararse() {
		Cuartel cuartel = new Cuartel();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
		;
		cuartel.recibirDanio(50);
		cuartel.repararse();
		Assert.assertEquals(cuartel.getVida(), 250);
	}
	
	
	@Test
	public void test05CuartelRecibirDanioYRepararseVariasVecesNoSuperaVidaMaxima() {
		Cuartel cuartel = new Cuartel();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
		
		cuartel.recibirDanio(50);
		
		cuartel.repararse();
		cuartel.repararse();
		cuartel.repararse();
		cuartel.repararse();
		Assert.assertEquals(cuartel.getVida(), 250);	
	}
	
	@Test
	public void test06CrearArqueroDesdeCuartel() {
		Cuartel cuartel = new Cuartel();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
		Arquero arquero = cuartel.crearArqueroDesdeCuartel();
		Assert.assertEquals(75, arquero.getVida());
		
	}
	
	@Test
	public void test07CrearEspadachinDesdeCuartel() {
		Cuartel cuartel = new Cuartel();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
		Espadachin espadachin = cuartel.crearEspadachinDesdeCuartel();
		Assert.assertEquals(100, espadachin.getVida());
		
	}
	


}
