package modelo.mapa;

import modelo.Oro;
import modelo.Posicion;
import modelo.PosicionFueraDeRangoException;
import modelo.edificios.Castillo;
import modelo.edificios.Cuartel;
import modelo.edificios.PlazaCentral;
import modelo.unidades.Aldeano;
import modelo.unidades.ArmaDeAsedio;
import modelo.unidades.Espadachin;
import modelo.unidades.arquero.Arquero;

import org.junit.Assert;
import org.junit.Test;

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

        mapa.colocarEdificio(plaza, 4, 10, 10);

        mapa.colocarUnidad(aldeano, 10, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test08edificioSeColocaEnMapaYSeIntentaPonerUnidadEnLugarOcupadoPorEdificioLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 20);
        PlazaCentral plaza = new PlazaCentral(oro);
        Aldeano aldeano = new Aldeano(oro);

        mapa.colocarEdificio(plaza, 4, 10, 10);

        mapa.colocarUnidad(aldeano, 11, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test09edificioSeColocaEnMapaYSeIntentaPonerUnidadEnLugarOcupadoPorEdificioLanzaExcepcion() {
        Mapa mapa = new Mapa(20, 20);
        PlazaCentral plaza = new PlazaCentral(oro);
        Aldeano aldeano = new Aldeano(oro);

        mapa.colocarEdificio(plaza, 4, 10, 10);

        mapa.colocarUnidad(aldeano, 11, 11);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test10edificioSeColocaEnMapaYSeIntentaPonerUnidadEnLugarOcupadoPorEdificioLanzaExcepcion() {
        Mapa mapa = new Mapa(20, 20);
        PlazaCentral plaza = new PlazaCentral(oro);
        Aldeano aldeano = new Aldeano(oro);

        mapa.colocarEdificio(plaza, 4, 10, 10);

        mapa.colocarUnidad(aldeano, 10, 11);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test11edificioSeColocaFueraDelRangoPositivoDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(30, 20);
        PlazaCentral plaza = new PlazaCentral(oro);

        mapa.colocarEdificio(plaza, 4, 35, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test12edificioSeColocaFueraDelRangoNegativoDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(30, 20);
        PlazaCentral plaza = new PlazaCentral(oro);

        mapa.colocarEdificio(plaza, 4, -1000, -1000);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test13edificioSeColocaFueraDelRangoNuloDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(30, 20);
        PlazaCentral plaza = new PlazaCentral(oro);

        mapa.colocarEdificio(plaza, 4, 0, 0);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test14mapaColocaUnidadYSeColocaEdificioEnElMismoLugarLanzaExcepcion() {

        Mapa mapa = new Mapa(50, 40);
        PlazaCentral plaza = new PlazaCentral(oro);
        Espadachin espadachin = new Espadachin(oro);

        mapa.colocarUnidad(espadachin, 23, 22);

        mapa.colocarEdificio(plaza, 4, 23, 22);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test15mapaMueveUnidadHaciaOtroLugarYSeIntentaColocarUnidadEnNuevoLugarLanzaExcepcion() {

        Mapa mapa = new Mapa(25, 25);
        Posicion posicion = new Posicion(5, 5);
        Espadachin espadachin = new Espadachin(oro);
        Arquero arquero = new Arquero(oro);
        espadachin.setPosicion(posicion);

        mapa.colocarUnidad(espadachin, 5, 5);
        mapa.moverUnidadDesdeHasta(espadachin, 5, 5, 6, 6);

        mapa.colocarUnidad(arquero, 6, 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test16mapaMueveUnidadFueraDelRangoDelMapaLanzaExcepcion() {

        Mapa mapa = new Mapa(25, 30);
        Posicion posicion = new Posicion(10, 11);
        Espadachin espadachin = new Espadachin(oro);
        espadachin.setPosicion(posicion);

        mapa.colocarUnidad(espadachin, 11, 10);

        mapa.moverUnidadDesdeHasta(espadachin, 11, 10, 100, 100);
    }

    @Test(expected = PosicionFueraDeRangoException.class)
    public void test17mapaMueveUnidadFueraDelRangoDeUnidadLanzaExcepcion() {

        Mapa mapa = new Mapa(25, 30);
        Posicion posicion = new Posicion(8, 9);
        Espadachin espadachin = new Espadachin(oro);
        espadachin.setPosicion(posicion);

        mapa.colocarUnidad(espadachin, 9, 8);

        mapa.moverUnidadDesdeHasta(espadachin, 9, 8, 22, 22);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test18mapaMueveUnidadHaciaLugarOcupadoPorEdificioLanzaExcepcion() {

        Mapa mapa = new Mapa(25, 36);
        Posicion posicion = new Posicion(3, 1);
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(oro);
        Cuartel cuartel = new Cuartel(oro);
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
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio(oro);
        Arquero arquero = new Arquero(oro);
        armaAsedio.setPosicion(unaPosicion);
        arquero.setPosicion(otraPosicion);

        mapa.colocarUnidad(arquero, 2, 2);
        mapa.colocarUnidad(armaAsedio, 1, 3);

        mapa.moverUnidadDesdeHasta(armaAsedio, 1, 3, 2, 2);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test20mapaColocaYDescolocaUnidadYLuegoColocaUnidadDosVecesEnMismoLugarLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 40);
        Arquero arquero = new Arquero(oro);
        Aldeano aldeano = new Aldeano(oro);

        mapa.colocarUnidad(arquero, 10, 10);
        mapa.descolocarUnidad(10, 10);
        mapa.colocarUnidad(aldeano, 10, 10);

        mapa.colocarUnidad(arquero, 10, 10);
    }

    @Test(expected = CasilleroOcupadoException.class)
    public void test21mapaColocaYDescolocaEdificioYLuegoColocaUnidadDosVecesEnMismoLugarLanzaExcepcion() {

        Mapa mapa = new Mapa(20, 40);
        Castillo castillo = new Castillo(oro);

        mapa.colocarEdificio(castillo, 16, 10, 10);
        mapa.descolocarEdificio(16, 10, 10);
        for (int i = 0; i < 8; i++) {
            mapa.colocarUnidad(new Arquero(oro), 10 + i, 10);
            mapa.colocarUnidad(new Arquero(oro), 10 + i, 11);
        }

        mapa.colocarUnidad(new Aldeano(oro), 15, 10);
    }
}
