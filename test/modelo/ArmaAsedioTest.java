package modelo;

import junit.framework.Assert;
import org.junit.Test;
import unidades.ArmaDeAsedio;
import unidades.NoSePuedeAtacarArmaAsedioDesmontadaException;
import unidades.NoSePuedeMoverArmaAsedioMontadaException;

public class ArmaAsedioTest {

	@Test
	public void test01CreacionDeArmaAsedio() {

		Oro oro = new Oro(500);
		ArmaDeAsedio arma = new ArmaDeAsedio(oro);

		Assert.assertEquals(arma.getVida(), 150);

	}
	
	@Test(expected = NoSePuedeMoverArmaAsedioMontadaException.class)
	public void test02MoverArmaMontadaLanzaExcepcion() {

		Oro oro = new Oro(500);
		ArmaDeAsedio arma = new ArmaDeAsedio(oro);
		Posicion posicion = new Posicion(9, 9);

		arma.montarArma();

		arma.moverHacia(posicion);
		
	}
	
	@Test(expected = NoSePuedeAtacarArmaAsedioDesmontadaException.class)
	public void test03AtacarConArmaDesmontada() {

		Oro oro = new Oro(500);
		ArmaDeAsedio arma = new ArmaDeAsedio(oro);

		arma.atacar();
	}
	
	@Test
	public void test04CrearArmaDeAsedioCuestaOro() {

		Oro oro = new Oro(500);
		ArmaDeAsedio arma = new ArmaDeAsedio(oro);

		Assert.assertEquals(oro.getOro(), 300);
	}
	
	@Test(expected = NoTenesOroSuficienteException.class)
	public void test05CrearArmaSinOroDisponible() {
		Oro oro = new Oro(5);

		ArmaDeAsedio arma = new ArmaDeAsedio(oro);
	}

	@Test(expected = PosicionFueraDeRangoException.class)
	public void test06armaDeAsedioSeMueveFueraDeRangoLanzaExcepcion() {

		Oro oro = new Oro(500);
		ArmaDeAsedio arma = new ArmaDeAsedio(oro);
		Posicion unaPosicion = new Posicion(5, 5);
		Posicion otraPosicion = new Posicion(9, 9);

		arma.setPosicion(unaPosicion);

		arma.moverHacia(otraPosicion);
	}
	
}

	

	

