package modelo.mapa;

import modelo.Oro;
import modelo.unidades.Espadachin;
import modelo.unidades.arquero.Arquero;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class FilaTest {

    Oro oro = new Oro(1000);

    @Test
    public void test01creacionDeFila() {

        Fila fila = new Fila();

        Assert.assertNotNull(fila);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test02filaColocaUnidadEIntentaColocarNuevamenteEnMismoLugarLanzaExcepcion() {

        Fila fila = new Fila();
        Arquero arquero = new Arquero(oro);
        Espadachin espadachin = new Espadachin(oro);
        ArrayList<Casillero> casilleros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            casilleros.add(new Casillero());
        }

        fila.agregarCasilleros(casilleros);
        fila.colocar(arquero, 1);

        fila.colocar(espadachin, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test03filaColocaUnidadFueraDeRangoYLanzaExcepcion() {

        Fila fila = new Fila();
        Arquero arquero = new Arquero(oro);
        Espadachin espadachin = new Espadachin(oro);
        ArrayList<Casillero> casilleros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            casilleros.add(new Casillero());
        }

        fila.agregarCasilleros(casilleros);
        fila.colocar(arquero, 1);

        fila.colocar(espadachin, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test04filaColocaUnidadFueraDeRangoYLanzaExcepcion() {

        Fila fila = new Fila();
        Arquero arquero = new Arquero(oro);
        Espadachin espadachin = new Espadachin(oro);
        ArrayList<Casillero> casilleros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            casilleros.add(new Casillero());
        }

        fila.agregarCasilleros(casilleros);
        fila.colocar(arquero, 1);

        fila.colocar(espadachin, 500);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test05filaColocaUnidadFueraDeRangoNegativoYLanzaExcepcion() {

        Fila fila = new Fila();
        Arquero arquero = new Arquero(oro);
        Espadachin espadachin = new Espadachin(oro);
        ArrayList<Casillero> casilleros = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            casilleros.add(new Casillero());
        }

        fila.agregarCasilleros(casilleros);
        fila.colocar(arquero, 1);

        fila.colocar(espadachin, -500);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test06filaColocaYDescolocaUnidadYLuegoColocaUnidadDosVecesEnMismoLugarLanzaExcepcion() {

        Fila fila = new Fila();
        Arquero arquero = new Arquero(oro);
        Espadachin espadachin = new Espadachin(oro);
        ArrayList<Casillero> casilleros = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            casilleros.add(new Casillero());
        }

        fila.agregarCasilleros(casilleros);
        fila.colocar(arquero, 10);
        fila.descolocar(10);
        fila.colocar(espadachin, 10);

        fila.colocar(arquero, 10);
    }
}
