package modelo;

import edificios.PlazaCentral;
import modelo.mapa.CasilleroOcupadoException;
import modelo.mapa.Mapa;
import modelo.mapa.TamanioInvalidoException;
import org.junit.Assert;
import org.junit.Test;
import unidades.Aldeano;
import unidades.Espadachin;

import java.util.ArrayList;

public class MapaTest {

    @Test(expected = TamanioInvalidoException.class)
    public void test01crearMapaConMedidasNegativasLanzaExcepcion() {
        Mapa mapa = new Mapa(-100, -100);
    }

    @Test(expected = TamanioInvalidoException.class)
    public void test02crearMapaConMedidasNulasLanzaExcepcion() {
        Mapa mapa = new Mapa(0, 0);
    }

    @Test
    public void test03creaMapaConMedidasGrandes() {
        Mapa mapa = new Mapa(500, 200);

        Assert.assertNotNull(mapa);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test04mapaColocaDosUnidadesEnMismaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(50, 25);
        Aldeano unAldeano = new Aldeano();
        Aldeano otroAldeano = new Aldeano();

        mapa.colocarUnidad(unAldeano, 4, 5);
        mapa.colocarUnidad(otroAldeano, 4, 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test05mapaColocaUnidadFueraDeRangoLanzaExcepcion() {

        Mapa mapa = new Mapa(61, 15);
        Aldeano unAldeano = new Aldeano();

        mapa.colocarUnidad(unAldeano, 100, 100);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test06mapaColocaUnidadConMapaCompletoLanzaExcepcion() {

        int altura = 20, base = 14, indice = 0;
        Mapa mapa = new Mapa(altura, base);
        ArrayList<Aldeano> aldeanos = new ArrayList<>();
        Aldeano ultimoAldeano = new Aldeano();
        for (int i = 0; i < altura * base; i++) {
            aldeanos.add(new Aldeano());
        }

        for (int i = 1; i <= altura; i++) {
            for (int j = 1; j <= base; j++) {
                mapa.colocarUnidad(aldeanos.get(indice), i, j);
            }
        }
        mapa.colocarUnidad(ultimoAldeano, 6, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test07edificioSeColocaEnMapaYSeIntentaPonerUnidadEnMismoLugarLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        PlazaCentral plaza = new PlazaCentral();
        Aldeano aldeano = new Aldeano();

        plaza.colocarseEn(mapa, 10, 10);

        mapa.colocarUnidad(aldeano, 10, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test08edificioSeColocaEnMapaYSeIntetaPonerUnidadEnLugarOcupadoPorEdificioLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        PlazaCentral plaza = new PlazaCentral();
        Aldeano aldeano = new Aldeano();

        plaza.colocarseEn(mapa, 10, 10);

        mapa.colocarUnidad(aldeano, 11, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test09edificioSeColocaEnMapaYSeIntetaPonerUnidadEnLugarOcupadoPorEdificioLanzaExcepcion() {
        Mapa mapa = new Mapa(20, 20);
        PlazaCentral plaza = new PlazaCentral();
        Aldeano aldeano = new Aldeano();

        plaza.colocarseEn(mapa, 10, 10);

        mapa.colocarUnidad(aldeano, 11, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test10edificioSeColocaEnMapaYSeIntentaPonerUnidadEnLugarOcupadoPorEdificioLanzaExcepcion() {
        Mapa mapa = new Mapa(20, 20);
        PlazaCentral plaza = new PlazaCentral();
        Aldeano aldeano = new Aldeano();

        plaza.colocarseEn(mapa, 10, 10);

        mapa.colocarUnidad(aldeano, 10, 11);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test11edificioSeColocaFueraDelRangoPositivoDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(30, 20);
        PlazaCentral plaza = new PlazaCentral();

        plaza.colocarseEn(mapa, 35, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test12edificioSeColocaFueraDelRangoNegativoDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(30, 20);
        PlazaCentral plaza = new PlazaCentral();

        plaza.colocarseEn(mapa, -1000, -1000);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test13edificioSeColocaFueraDelRangoNuloDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(30, 20);
        PlazaCentral plaza = new PlazaCentral();

        plaza.colocarseEn(mapa, 0, 0);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test14mapaColocaUnidadYSeColocaEdificioEnElMismoLugarLanzaExcepcion() {

        Mapa mapa = new Mapa(50, 40);
        PlazaCentral plaza = new PlazaCentral();
        Espadachin espadachin = new Espadachin();

        mapa.colocarUnidad(espadachin, 23, 22);

        plaza.colocarseEn(mapa, 23, 22);
    }

}
