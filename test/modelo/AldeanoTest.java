package modelo;

import junit.framework.Assert;
import org.junit.Test;
import unidades.Aldeano;
import unidades.AldeanoEstaOcupadoException;
import unidades.NoSePuedeMoverArmaAsedioMontadaException;

public class AldeanoTest {

	@Test
	public void test01CreacionDeAldeano() {
		
		 Oro oro = new Oro(100);
	     Aldeano aldeano = new Aldeano(oro);		
		Assert.assertEquals(aldeano.getVida(), 50);
	}

    @Test
    public void test02AldeeanoDisponibleSumaOro() {
        
        Oro oro = new Oro(100);
        Aldeano aldeano = new Aldeano(oro);
        aldeano.avanzarTurno();
        int cantidadOro = oro.getOro();
        Assert.assertEquals(125, cantidadOro);
    }
    

    @Test
    public void test03AldeanoOcupadoNoSumaOro() {
    	 Oro oro = new Oro(100);
         Aldeano aldeano = new Aldeano(oro);
        aldeano.estarOcupado(1);
        aldeano.avanzarTurno();
        int cantidadOro = oro.getOro();
        Assert.assertEquals(100, cantidadOro);
		}
    
    @Test(expected = AldeanoEstaOcupadoException.class)
    public void test04AldeanoOcupadoNoCreaCuartel() {
    	 Oro oro = new Oro(100);
         Aldeano aldeano = new Aldeano(oro);

         aldeano.estarOcupado(2);
    	 aldeano.construirCuartel();   	
    	
    }
    @Test
    public void test05AldeanoNoDisponibleNoSumaOro() {
    	 Oro oro = new Oro(100);
         Aldeano aldeano = new Aldeano(oro);
        aldeano.estarOcupado(1);
        aldeano.avanzarTurno();
        
        int cantidadOro = oro.getOro();
        Assert.assertEquals(100, cantidadOro);
    }
    @Test
    public void test06AldeanoNoDisponiblePorVariosTurnosNoSumaOro() {
    	 Oro oro = new Oro(100);
         Aldeano aldeano = new Aldeano(oro);
        aldeano.estarOcupado(3);
        aldeano.avanzarTurno();
        aldeano.avanzarTurno();        
        
        int cantidadOro = oro.getOro();
        Assert.assertEquals(100, cantidadOro);
    }
    @Test
    public void test07AldeanoPor3TurnosConstruyendoNoSumaOro() {
    	 Oro oro = new Oro(100);
         Aldeano aldeano = new Aldeano(oro);
        aldeano.construirCuartel(); //Primer turno ocupado, comienza a construir
        aldeano.avanzarTurno();//Segundo turno ocupado
        aldeano.avanzarTurno();//Tercer turno ocupado  
        aldeano.avanzarTurno(); //Ya esta libre al proximo avance sumara oro
        aldeano.avanzarTurno();
        
        int cantidadOro = oro.getOro();
        Assert.assertEquals(125, cantidadOro);
    }
}
