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
		Oro oro = new Oro(500);
		Cuartel cuartel = new Cuartel(oro);
		Assert.assertEquals(cuartel.getVida(), 250);
	}
	
	@Test(	expected = CuartelCreandoseException.class)
	public void test02CuartelEnConstruccionNoRecibeDanio() {
		Oro oro = new Oro(500);
		Cuartel cuartel = new Cuartel(oro);
		cuartel.recibirDanio(50);		
		
	}
	
	@Test
	public void test03CuartelConstruidoRecibeDanio() {
		Oro oro = new Oro(500);
		Cuartel cuartel = new Cuartel(oro);
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		/*Avanzo 3 turnos y como esta creada recibe daño*/
		cuartel.recibirDanio(50);
		Assert.assertEquals(cuartel.getVida(), 200);		
		
	}
	

	@Test
	public void test04CuartelRecibirDanioYRepararse() {
		Oro oro = new Oro(500);
		Cuartel cuartel = new Cuartel(oro);
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
		Oro oro = new Oro(500);
		Cuartel cuartel = new Cuartel(oro);
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
		Oro oro = new Oro(1000);
		Cuartel cuartel = new Cuartel(oro);
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
		Arquero arquero = cuartel.crearArqueroDesdeCuartel();
		Assert.assertEquals(75, arquero.getVida());
		
	}
	
	@Test
	public void test07CrearEspadachinDesdeCuartel() {
		Oro oro = new Oro(500);
		Cuartel cuartel = new Cuartel(oro);
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
		Espadachin espadachin = cuartel.crearEspadachinDesdeCuartel();
		Assert.assertEquals(100, espadachin.getVida());
		
	}
	
	@Test
	public void test08CrearCuartelRestaOro() {
		Oro oro = new Oro(500);
		Cuartel cuartel = new Cuartel(oro);
		Assert.assertEquals(oro.getOro(), 450);
		
	}
	

	
	@Test(expected = NoTenesOroSuficienteException.class)
	public void test09CrearCuartelConOroInsuficiente() {
		Oro oro = new Oro(5);
		PlazaCentral plaza = new PlazaCentral(oro);		
	}
	
	


}
