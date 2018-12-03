package modelo.mapa;

import modelo.juego.Oro;
import modelo.excepciones.CasilleroOcupadoException;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;

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
        Arquero arquero = new Arquero(this.oro);
        Espadachin espadachin = new Espadachin(this.oro);
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
        Arquero arquero = new Arquero(this.oro);
        Espadachin espadachin = new Espadachin(this.oro);
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
        Arquero arquero = new Arquero(this.oro);
        Espadachin espadachin = new Espadachin(this.oro);
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
        Arquero arquero = new Arquero(this.oro);
        Espadachin espadachin = new Espadachin(this.oro);
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
        Arquero arquero = new Arquero(this.oro);
        Espadachin espadachin = new Espadachin(this.oro);
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

    @Test
    public void test07filaBuscaColocableEnColumnaConCasilleroVacioDevuelveNull() {

        Fila fila = new Fila();
        ArrayList<Casillero> casilleros = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            casilleros.add(new Casillero());
        }

        fila.agregarCasilleros(casilleros);

        for (int i = 1; i <= 50; i++) {
            Assert.assertNull(fila.buscarColocableEn(i));
        }
    }

    @Test
    public void test08filaBuscaColocableEnColumnaDevuelveColocableCorrecto() {

        Fila fila = new Fila();
        ArrayList<Casillero> casilleros = new ArrayList<>();
        Aldeano aldeano = new Aldeano(this.oro);
        for (int i = 0; i < 50; i++) {
            Casillero casillero = new Casillero();
            casillero.colocar(aldeano);
            casilleros.add(casillero);
        }
        fila.agregarCasilleros(casilleros);

        for (int i = 1; i <= 50; i++) {
            Assert.assertSame(aldeano, fila.buscarColocableEn(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test09filaBuscaColocableEnColumnaFueraDeRangoLanzaExcepcion() {

        Fila fila = new Fila();
        ArrayList<Casillero> casilleros = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            casilleros.add(new Casillero());
        }

        fila.buscarColocableEn(100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test10filaBuscaColocableEnColumnaFueraDeRangoLanzaExcepcion() {

        Fila fila = new Fila();
        ArrayList<Casillero> casilleros = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            casilleros.add(new Casillero());
        }

        fila.buscarColocableEn(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test11filaBuscaColocableEnColumnaFueraDeRangoLanzaExcepcion() {

        Fila fila = new Fila();
        ArrayList<Casillero> casilleros = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            casilleros.add(new Casillero());
        }

        fila.buscarColocableEn(-1000);
    }
}
