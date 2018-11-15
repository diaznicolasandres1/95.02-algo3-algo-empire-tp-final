package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import edificios.EdificioTieneVidaMaximaException;
import edificios.PlazaCentral;
import junit.framework.Assert;
import unidades.Aldeano;

public class PlazaCentralTest {
	

	@Test
	public void test01CreacionDePlazaCentral() {
		Oro oro = new Oro(500);
		PlazaCentral plaza = new PlazaCentral(oro);
		Assert.assertEquals(plaza.getVida(), 450);
		
		
	}
	
	@Test
	public void test02PlazaCentralEnConstruccionNoRecibeDanio() {
		Oro oro = new Oro(500);
		PlazaCentral plaza = new PlazaCentral(oro);
		try {
			plaza.recibirDanio(50);
		}
		
		catch(Exception e){
			Assert.assertEquals(plaza.getVida(), 450);
		}
		
		
	}
	
	@Test
	public void test03PlazaCentralConstruidaRecibeDanio() {
		Oro oro = new Oro(500);
		PlazaCentral plaza = new PlazaCentral(oro);
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		/*Avanzo 3 turnos y como esta creada recibe daño*/
		plaza.recibirDanio(50);
		Assert.assertEquals(plaza.getVida(), 400);
		
		
	}



	@Test
	public void test04PlazaCentralRecibirDanioYRepararse() {
		Oro oro = new Oro(500);
		PlazaCentral plaza = new PlazaCentral(oro);
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		
		plaza.recibirDanio(50);
		plaza.repararse();
		Assert.assertEquals(plaza.getVida(), 425);
		
		
	}
	
	@Test(expected = EdificioTieneVidaMaximaException.class)
	public void test05PlazaCentralRecibirDanioYRepararseVariasVecesNoSuperaVidaMaxima() {
		Oro oro = new Oro(500);
		PlazaCentral plaza = new PlazaCentral(oro);
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.recibirDanio(50);
		plaza.repararse();
		plaza.repararse();
		plaza.repararse();
		plaza.repararse();
		plaza.repararse();
			
		
	}
	
	@Test
	public void test06CrearAldeanoDesdePlazaCentral() {
		Oro oro = new Oro(500);
		PlazaCentral plaza = new PlazaCentral(oro);
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		Aldeano aldeano = plaza.crearAldeanoDesdePlaza();
		Assert.assertEquals(aldeano.getVida(), 50);
		
	}
	
	@Test
	public void test07CrearPlazaRestaOro() {
		Oro oro = new Oro(500);
		PlazaCentral plaza = new PlazaCentral(oro);
		Assert.assertEquals(oro.getOro(), 400); //Cuesta 100 crearse
		
	}
	@Test(expected = NoTenesOroSuficienteException.class)
	public void test08CrearPlazaConOroInsuficiente() {
		Oro oro = new Oro(50);
		PlazaCentral plaza = new PlazaCentral(oro);		
	}
	
}

