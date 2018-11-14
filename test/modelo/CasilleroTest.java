package modelo;

import edificios.PlazaCentral;
import modelo.mapa.Casillero;
import modelo.mapa.CasilleroOcupadoException;
import org.junit.Assert;
import org.junit.Test;
import unidades.Arquero;

public class CasilleroTest {

    Oro oro = new Oro(5000);

    @Test
    public void test01crearCasillero() {

        Assert.assertNotNull(new Casillero());
    }

    @Test
    public void test02casilleroSeCreaDesocupado() {

        Casillero casillero = new Casillero();

        Assert.assertTrue(!casillero.estaOcupado());
    }

    @Test
    public void test03casilleroEsOcupadoPorUnidadYSeVerificaQueEstaOcupado() {

        Casillero casillero = new Casillero();
        Arquero arquero = new Arquero(oro);

        casillero.colocarUnidad(arquero);

        Assert.assertTrue(casillero.estaOcupado());

    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test04casilleroEsOcupadoPorUnidadYSeIntentaOcuparNuevamenteLanzaExcepcion() {

        Casillero casillero = new Casillero();
        Arquero arquero = new Arquero(oro);
        Arquero otroArquero = new Arquero(oro);

        casillero.colocarUnidad(arquero);

        casillero.colocarUnidad(otroArquero);
    }

    @Test
    public void test04casilleroOcupadoPorUnidadEsDesocupadoYSeVerificaQueNoEsteOcupado() {

        Casillero casillero = new Casillero();
        Arquero arquero = new Arquero(oro);

        casillero.colocarUnidad(arquero);
        casillero.desocupar();

        Assert.assertTrue(!casillero.estaOcupado());
    }

    @Test
    public void test05casilleroEsOcupadoPorEdificioYSeVerificaQueEsteOcupado() {

        Casillero casillero = new Casillero();
        PlazaCentral plaza = new PlazaCentral(oro);

        casillero.colocarEdificio(plaza);

        Assert.assertTrue(casillero.estaOcupado());
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test06casilleroOcupadoPorEdificioSeIntentaOcuparPorUnidadLanzaExcepcion() {

        Casillero casillero = new Casillero();
        PlazaCentral plaza = new PlazaCentral(oro);
        Arquero arquero = new Arquero(oro);

        casillero.colocarEdificio(plaza);

        casillero.colocarUnidad(arquero);
    }

    @Test
    public void test07casilleroOcupadoPorEdificioEsDesocupadoYSeVerificaQueNoEsteOcupado() {

        Casillero casillero = new Casillero();
        PlazaCentral plaza = new PlazaCentral(oro);

        casillero.colocarEdificio(plaza);
        casillero.desocupar();

        Assert.assertTrue(!casillero.estaOcupado());
    }

    @Test
    public void test08casilleroEsOcupadoPorEdificioYDesocupadoMultiplesVecesYSeVerificaQueNoEsteOcupado() {

        Casillero casillero = new Casillero();
        PlazaCentral plaza = new PlazaCentral(oro);

        for (int i = 0; i < 1000; i++) {
            casillero.colocarEdificio(plaza);
            casillero.desocupar();
        }

        Assert.assertTrue(!casillero.estaOcupado());
    }

    @Test
    public void test09casilleroEsOcupadoPorUnidadYDesocupadoMultiplesVecesYSeVerificaQueNoEsteOcupado() {

        Casillero casillero = new Casillero();
        Arquero arquero = new Arquero(oro);

        for (int i = 0; i < 1000; i++) {
            casillero.colocarUnidad(arquero);
            casillero.desocupar();
        }

        Assert.assertTrue(!casillero.estaOcupado());
    }
}
