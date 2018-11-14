package modelo;

import edificios.Cuartel;
import edificios.PlazaCentral;
import modelo.mapa.CasilleroOcupadoException;
import modelo.mapa.Mapa;
import modelo.mapa.TamanioInvalidoException;
import org.junit.Assert;
import org.junit.Test;
import unidades.Aldeano;
import unidades.ArmaDeAsedio;
import unidades.Arquero;
import unidades.Espadachin;

import java.util.ArrayList;

public class MapaTest {
	Oro oro = new Oro(10000);

    @Test(expected = TamanioInvalidoException.class)
    public void test01crearMapaConMedidasNegativasLanzaExcepcion() {
        Mapa mapa = new Mapa(-100, -100);
    }

    @Test(expected = TamanioInvalidoException.class)
    public void test02crearMapaConMedidasNulasLanzaExcepcion() {
        Mapa mapa = new Mapa(0, 0);
    }

    @Test(expected = TamanioInvalidoException.class)
    public void test03crearMapaConMedidasLimitesLanzaExcepcion() {
        Mapa mapa = new Mapa(11, 11);
    }

    @Test
    public void test04crearMapaConMedidasLimitesCreaCorrectamente() {
        Mapa mapa = new Mapa(12, 12);

        Assert.assertNotNull(mapa);
    }


    @Test
    public void test03creaMapaConMedidasGrandes() {
        Mapa mapa = new Mapa(500, 200);

        Assert.assertNotNull(mapa);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test04mapaColocaDosUnidadesEnMismaPosicionLanzaExcepcion() {

        Mapa mapa = new Mapa(50, 25);
        Aldeano unAldeano = new Aldeano(oro);
        Aldeano otroAldeano = new Aldeano(oro);

        mapa.colocarUnidad(unAldeano, 4, 5);
        mapa.colocarUnidad(otroAldeano, 4, 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test05mapaColocaUnidadFueraDeRangoLanzaExcepcion() {

        Mapa mapa = new Mapa(61, 15);
        Aldeano unAldeano = new Aldeano(oro);

        mapa.colocarUnidad(unAldeano, 100, 100);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test06mapaColocaUnidadConMapaCompletoLanzaExcepcion() {

        int altura = 20, base = 14, indice = 0;
        Mapa mapa = new Mapa(base, altura);
        ArrayList<Aldeano> aldeanos = new ArrayList<>();
        Aldeano ultimoAldeano = new Aldeano(oro);
        for (int i = 0; i < altura * base; i++) {
            aldeanos.add(new Aldeano(oro));
        }

        for (int i = 1; i <= altura; i++) {
            for (int j = 1; j <= base; j++) {
                mapa.colocarUnidad(aldeanos.get(indice), i, j);
                indice++;
            }
        }
        mapa.colocarUnidad(ultimoAldeano, 6, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test07edificioSeColocaEnMapaYSeIntentaPonerUnidadEnMismoLugarLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        PlazaCentral plaza = new PlazaCentral(oro);
        Aldeano aldeano = new Aldeano(oro);

        plaza.colocarseEn(mapa, 10, 10);

        mapa.colocarUnidad(aldeano, 10, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test08edificioSeColocaEnMapaYSeIntetaPonerUnidadEnLugarOcupadoPorEdificioLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        PlazaCentral plaza = new PlazaCentral(oro);
        Aldeano aldeano = new Aldeano(oro);

        plaza.colocarseEn(mapa, 10, 10);

        mapa.colocarUnidad(aldeano, 11, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test09edificioSeColocaEnMapaYSeIntetaPonerUnidadEnLugarOcupadoPorEdificioLanzaExcepcion() {
        Mapa mapa = new Mapa(20, 20);
        PlazaCentral plaza = new PlazaCentral(oro);
        Aldeano aldeano = new Aldeano(oro);

        plaza.colocarseEn(mapa, 10, 10);

        mapa.colocarUnidad(aldeano, 11, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test10edificioSeColocaEnMapaYSeIntentaPonerUnidadEnLugarOcupadoPorEdificioLanzaExcepcion() {
        Mapa mapa = new Mapa(20, 20);
        PlazaCentral plaza = new PlazaCentral(oro);
        Aldeano aldeano = new Aldeano(oro);

        plaza.colocarseEn(mapa, 10, 10);

        mapa.colocarUnidad(aldeano, 10, 11);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test11edificioSeColocaFueraDelRangoPositivoDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(30, 20);
        PlazaCentral plaza = new PlazaCentral(oro);

        plaza.colocarseEn(mapa, 35, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test12edificioSeColocaFueraDelRangoNegativoDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(30, 20);
        PlazaCentral plaza = new PlazaCentral(oro);

        plaza.colocarseEn(mapa, -1000, -1000);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test13edificioSeColocaFueraDelRangoNuloDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(30, 20);
        PlazaCentral plaza = new PlazaCentral(oro);

        plaza.colocarseEn(mapa, 0, 0);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test14mapaColocaUnidadYSeColocaEdificioEnElMismoLugarLanzaExcepcion() {

        Mapa mapa = new Mapa(50, 40);
        PlazaCentral plaza = new PlazaCentral(oro);
        Espadachin espadachin = new Espadachin(oro);

        mapa.colocarUnidad(espadachin, 23, 22);

        plaza.colocarseEn(mapa, 23, 22);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test15mapaMueveUnidadHaciaOtroLugarYSeIntentaColocarUnidadEnNuevoLugarLanzaExcepcion() {

        Mapa mapa = new Mapa(25, 25);
        Posicion posicion = new Posicion(5, 5);
        Espadachin espadachin = new Espadachin();
        Arquero arquero = new Arquero();
        espadachin.setPosicion(posicion);

        mapa.colocarUnidad(espadachin, 5, 5);
        mapa.moverUnidadDesdeHasta(espadachin, 5, 5, 6, 6);

        mapa.colocarUnidad(arquero, 6, 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test16mapaMueveUnidadFueraDelRangoDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(25, 30);
        Posicion posicion = new Posicion(10, 11);
        Espadachin espadachin = new Espadachin();
        Arquero arquero = new Arquero();
        espadachin.setPosicion(posicion);

        mapa.colocarUnidad(espadachin, 11, 10);

        mapa.moverUnidadDesdeHasta(espadachin, 11, 10, 100, 100);
    }

    @Test(expected = PosicionFueraDeRango.class)
    public void test17mapaMueveUnidadFueraDelRangoDeUnidadLanzaExcepcion() {

        Mapa mapa = new Mapa(25, 30);
        Posicion posicion = new Posicion(8, 9);
        Espadachin espadachin = new Espadachin();
        espadachin.setPosicion(posicion);

        mapa.colocarUnidad(espadachin, 9, 8);

        mapa.moverUnidadDesdeHasta(espadachin, 9, 8, 22, 22);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test18mapaMueveUnidadHaciaLugarOcupadoPorEdificioLanzaExcepcion() {

        Mapa mapa = new Mapa(25, 36);
        Posicion posicion = new Posicion(3, 1);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Cuartel cuartel = new Cuartel();
        armaAsedio.setPosicion(posicion);

        cuartel.colocarseEn(mapa, 1, 1);
        mapa.colocarUnidad(armaAsedio, 1, 3);

        mapa.moverUnidadDesdeHasta(armaAsedio, 1, 3, 1, 2);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test19mapaMueveUnidadHaciaLugarOcupadoPorOtraUnidadLanzaExcepcion() {

        Mapa mapa = new Mapa(25, 36);
        Posicion unaPosicion = new Posicion(3, 1);
        Posicion otraPosicion = new Posicion(2, 2);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Arquero arquero = new Arquero();
        armaAsedio.setPosicion(unaPosicion);
        arquero.setPosicion(otraPosicion);

        mapa.colocarUnidad(arquero, 2, 2);
        mapa.colocarUnidad(armaAsedio, 1, 3);

        mapa.moverUnidadDesdeHasta(armaAsedio, 1, 3, 2, 2);
    }


}
