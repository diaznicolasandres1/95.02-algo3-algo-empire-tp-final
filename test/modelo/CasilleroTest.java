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

    @Test(expected = CasilleroOcupadoException.class)
    public void test02casilleroEsOcupadoPorUnidadYSeIntentaOcuparNuevamentePorOtraUnidadLanzaExcepcion() {

        Casillero casillero = new Casillero();
        Arquero arquero = new Arquero(oro);
        Arquero otroArquero = new Arquero(oro);

        casillero.colocar(arquero);

        casillero.colocar(otroArquero);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test03casilleroOcupadoPorEdificioSeIntentaOcuparPorUnidadLanzaExcepcion() {

        Casillero casillero = new Casillero();
        PlazaCentral plaza = new PlazaCentral(oro);
        Arquero arquero = new Arquero(oro);

        casillero.colocar(plaza);

        casillero.colocar(arquero);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test04casilleroOcupadoPorEdificioSeIntentaOcuparPorEdificioLanzaExcepcion() {

        Casillero casillero = new Casillero();
        PlazaCentral plaza = new PlazaCentral(oro);
        PlazaCentral otraPlaza = new PlazaCentral(oro);

        casillero.colocar(plaza);

        casillero.colocar(otraPlaza);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test05casilleroEsOcupadoYDesocupadoMultiplesVecesYAlFinalLanzaExcepcion() {

        Casillero casillero = new Casillero();
        PlazaCentral plaza = new PlazaCentral(oro);
        PlazaCentral otraPlaza = new PlazaCentral(oro);

        for (int i = 0; i < 1000; i++) {
            casillero.colocar(plaza);
            casillero.desocupar();
        }
        casillero.colocar(otraPlaza);

        casillero.colocar(plaza);
    }
}
