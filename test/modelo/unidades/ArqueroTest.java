package modelo.unidades;

import junit.framework.Assert;
import modelo.NoTenesOroSuficienteException;
import modelo.Oro;
import modelo.Posicion;
import modelo.PosicionFueraDeRangoException;
import modelo.mapa.CasilleroOcupadoException;
import modelo.mapa.Mapa;
import org.junit.Test;

public class ArqueroTest {
	
	@Test
	public void test01CreacionDeArquero() {

		Oro oro = new Oro(300);
        Arquero arquero = new Arquero(oro);

		Assert.assertEquals(arquero.getVida(), 75);
    }
	
	@Test 
	public void test02CreacionDeArqueroCuestaOro() {

		Oro oro = new Oro(300);
        Arquero arquero = new Arquero(oro);

		Assert.assertEquals(oro.getOro(), 225);
	}

	@Test(expected = NoTenesOroSuficienteException.class)
    public void test03CrearArqueroConOroInsuficiente() {

		Oro oro = new Oro(5);

        Arquero arquero = new Arquero(oro);
    }

    @Test(expected = PosicionFueraDeRangoException.class)
    public void test04arqueroSeMueveFueraDeRangoYLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(300);
        Arquero arquero = new Arquero(oro);
        Posicion unaPosicion = new Posicion(5, 5);
        Posicion otraPosicion = new Posicion(10, 10);

        arquero.setPosicion(unaPosicion);

        arquero.moverHacia(otraPosicion, mapa);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test05arqueroSeMueveHaciaElNorteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Arquero unArquero = new Arquero(oro);
        Arquero otroArquero = new Arquero(oro);

        unArquero.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArquero, 10, 10, 9, 10);

        otroArquero.colocarseEn(mapa, 9, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test06arqueroSeMueveHaciaElSurYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Arquero unArquero = new Arquero(oro);
        Arquero otroArquero = new Arquero(oro);

        unArquero.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArquero, 10, 10, 11, 10);

        otroArquero.colocarseEn(mapa, 11, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test07arqueroSeMueveHaciaElEsteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Arquero unArquero = new Arquero(oro);
        Arquero otroArquero = new Arquero(oro);

        unArquero.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArquero, 10, 10, 10, 11);

        otroArquero.colocarseEn(mapa, 10, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test08arqueroSeMueveHaciaElOesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Arquero unArquero = new Arquero(oro);
        Arquero otroArquero = new Arquero(oro);

        unArquero.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArquero, 10, 10, 10, 9);

        otroArquero.colocarseEn(mapa, 10, 9);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test09arqueroSeMueveHaciaElNoresteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Arquero unArquero = new Arquero(oro);
        Arquero otroArquero = new Arquero(oro);

        unArquero.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArquero, 10, 10, 9, 11);

        otroArquero.colocarseEn(mapa, 9, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test10arqueroSeMueveHaciaElSuresteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Arquero unArquero = new Arquero(oro);
        Arquero otroArquero = new Arquero(oro);

        unArquero.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArquero, 10, 10, 11, 11);

        otroArquero.colocarseEn(mapa, 11, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test11arqueroSeMueveHaciaElSuroesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Arquero unArquero = new Arquero(oro);
        Arquero otroArquero = new Arquero(oro);

        unArquero.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArquero, 10, 10, 11, 9);

        otroArquero.colocarseEn(mapa, 11, 9);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test12arqueroSeMueveHaciaElNoroesteYSeColocaUnaUnidadEnEsaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Arquero unArquero = new Arquero(oro);
        Arquero otroArquero = new Arquero(oro);

        unArquero.colocarseEn(mapa, 10, 10);
        mapa.moverUnidadDesdeHasta(unArquero, 10, 10, 9, 9);

        otroArquero.colocarseEn(mapa, 9, 9);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test13arqueroIntentaColocarseFueraDelRangoPositivoDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Arquero arquero = new Arquero(oro);

        arquero.colocarseEn(mapa, 100, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test14arqueroIntentaColocarseFueraDelRangoNegativoDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Arquero arquero = new Arquero(oro);

        arquero.colocarseEn(mapa, -1000, -1000);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test15arqueroIntentaColocarseEnLimiteDelRangoNuloDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(200);
        Arquero arquero = new Arquero(oro);

        arquero.colocarseEn(mapa, 0, 0);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test16arqueroSeColocaEnMapaYSeDescolocaYSeColocanDosUnidadesEnElMismoLugarLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        Oro oro = new Oro(500);
        Arquero arquero = new Arquero(oro);

        arquero.colocarseEn(mapa, 10, 10);
        arquero.descolocarseDe(mapa);
        mapa.colocarUnidad(new Arquero(oro), 10, 10);

        mapa.colocarUnidad(new Arquero(oro), 10, 10);
    }
}
