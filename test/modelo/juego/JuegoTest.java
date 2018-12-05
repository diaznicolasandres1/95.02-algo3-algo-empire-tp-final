package modelo.juego;

import org.junit.Test;
import junit.framework.Assert;

import modelo.edificios.castillo.Castillo;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;
import modelo.unidades.armadeasedio.ArmaDeAsedio;
import modelo.excepciones.EdificioObjetivoEsPropioException;
import modelo.excepciones.UnidadObjetivoEsPropiaException;

public class JuegoTest {

    @Test
    public void test01juegoAsignaNombresCorrectamente() {

        Juego juego = new Juego("Rojo", "Azul");

        String nombre = juego.getNombreJugadorActual();

        Assert.assertTrue(nombre.equals("Rojo") || nombre.equals("Azul"));
    }

    @Test
    public void test02juegoCambiarTurnoAlternaAlOponente() {

        Juego juego = new Juego("Rojo", "Azul");
        String unNombre = juego.getNombreJugadorActual();
        juego.finalizarTurno();
        String otroNombre = juego.getNombreJugadorActual();

        if (unNombre.equals("Rojo"))
            Assert.assertEquals("Azul", otroNombre);
        else
            Assert.assertEquals("Rojo", otroNombre);
    }

    @Test
    public void test03juegoCastilloCreadoCorrectamente() {

        Juego juego = new Juego("Rojo", "Azul");
        if (juego.getNombreJugadorActual().equals("Azul"))
            juego.finalizarTurno();

        Castillo castillo1 = (Castillo) juego.getColocable(1, 1);
        Castillo castillo2 = (Castillo) juego.getColocable(1, 4);
        Castillo castillo3 = (Castillo) juego.getColocable(4, 1);
        Castillo castillo4 = (Castillo) juego.getColocable(4, 4);

        Assert.assertNotNull(castillo1);
        Assert.assertEquals(castillo1, castillo2);
        Assert.assertEquals(castillo2, castillo3);
        Assert.assertEquals(castillo3, castillo4);
        Assert.assertEquals(castillo4, castillo1);
    }

    @Test
    public void test04juegoAldeanosCreadosCorrectamente() {

        Juego juego = new Juego("Rojo", "Azul");
        if (juego.getNombreJugadorActual().equals("Azul"))
            juego.finalizarTurno();

        Aldeano aldeano1 = (Aldeano) juego.getColocable(1, 5);
        Aldeano aldeano2 = (Aldeano) juego.getColocable(1, 8);
        Aldeano aldeano3 = (Aldeano) juego.getColocable(2, 5);
        Aldeano aldeano4 = (Aldeano) juego.getColocable(2, 8);

        Assert.assertNotNull(aldeano1);
        Assert.assertNotNull(aldeano2);
        Assert.assertNotNull(aldeano3);
        Assert.assertNull(aldeano4);
    }

    @Test
    public void test05juegoAldeanoNuevoCreadoCorrectamente() {

        Juego juego = new Juego("Rojo", "Azul");
        if (juego.getNombreJugadorActual().equals("Azul"))
            juego.finalizarTurno();

        PlazaCentral plaza = (PlazaCentral) juego.getColocable(1, 6);
        juego.crearAldeano(plaza);
        Aldeano aldeano = (Aldeano) juego.getColocable(2, 8);

        Assert.assertNotNull(aldeano);
    }

    @Test
    public void test06juegoPlazaNuevaCreadaCorrectamente() {

        Juego juego = new Juego("Rojo", "Azul");
        if (juego.getNombreJugadorActual().equals("Azul"))
            juego.finalizarTurno();

        Aldeano aldeano = (Aldeano) juego.getColocable(1, 8);
        juego.construirPlazaCentral(aldeano, 1, 9);

        PlazaCentral plaza1 = (PlazaCentral) juego.getColocable(1, 9);
        PlazaCentral plaza2 = (PlazaCentral) juego.getColocable(1, 10);
        PlazaCentral plaza3 = (PlazaCentral) juego.getColocable(2, 9);
        PlazaCentral plaza4 = (PlazaCentral) juego.getColocable(2, 10);

        Assert.assertNotNull(plaza1);
        Assert.assertEquals(plaza1, plaza2);
        Assert.assertEquals(plaza2, plaza3);
        Assert.assertEquals(plaza3, plaza4);
        Assert.assertEquals(plaza4, plaza1);
    }

    @Test
    public void test07juegoCuartelNuevoCreadoCorrectamente() {

        Juego juego = new Juego("Rojo", "Azul");
        if (juego.getNombreJugadorActual().equals("Azul"))
            juego.finalizarTurno();

        Aldeano aldeano = (Aldeano) juego.getColocable(1, 8);
        juego.construirCuartel(aldeano, 1, 9);

        Cuartel cuartel1 = (Cuartel) juego.getColocable(1, 9);
        Cuartel cuartel2 = (Cuartel) juego.getColocable(1, 10);
        Cuartel cuartel3 = (Cuartel) juego.getColocable(2, 9);
        Cuartel cuartel4 = (Cuartel) juego.getColocable(2, 10);

        Assert.assertNotNull(cuartel1);
        Assert.assertEquals(cuartel1, cuartel2);
        Assert.assertEquals(cuartel2, cuartel3);
        Assert.assertEquals(cuartel3, cuartel4);
        Assert.assertEquals(cuartel4, cuartel1);
    }

    @Test
    public void test08juegoEspadachinNuevoCreadoCorrectamente() {

        Juego juego = new Juego("Rojo", "Azul");
        if (juego.getNombreJugadorActual().equals("Azul"))
            juego.finalizarTurno();

        Aldeano aldeano = (Aldeano) juego.getColocable(1, 8);
        juego.construirCuartel(aldeano, 1, 9);
        Cuartel cuartel = (Cuartel) juego.getColocable(1, 9);
        for (int i = 0; i < 6; i++) {
            juego.finalizarTurno();
        }
        juego.crearEspadachin(cuartel);

        Espadachin espadachin = (Espadachin) juego.getColocable(1, 11);

        Assert.assertNotNull(espadachin);
    }

    @Test
    public void test09juegoArqueroNuevoCreadoCorrectamente() {

        Juego juego = new Juego("Rojo", "Azul");
        if (juego.getNombreJugadorActual().equals("Azul"))
            juego.finalizarTurno();
        Aldeano aldeano = (Aldeano) juego.getColocable(1, 8);
        juego.construirCuartel(aldeano, 1, 9);
        for (int i = 0; i < 6; i++) {
            juego.finalizarTurno();
        }

        Cuartel cuartel = (Cuartel) juego.getColocable(1, 9);
        juego.crearArquero(cuartel);

        Arquero arquero = (Arquero) juego.getColocable(1, 11);

        Assert.assertNotNull(arquero);
    }

    @Test
    public void test10juegoArmaDeAsedioNuevaCreadaCorrectamente() {

        Juego juego = new Juego("Rojo", "Azul");
        if (juego.getNombreJugadorActual().equals("Azul"))
            juego.finalizarTurno();
        Castillo castillo = (Castillo) juego.getColocable(1, 1);
        for (int i = 0; i < 6; i++) {
            juego.finalizarTurno();
        }

        juego.crearArmaDeAsedio(castillo);
        ArmaDeAsedio arma = (ArmaDeAsedio) juego.getColocable(3, 5);

        Assert.assertNotNull(arma);
    }


    @Test(expected = UnidadObjetivoEsPropiaException.class)
    public void test11juegoEspadachinAtacaEspadachinAliadoLanzaExcepcion() {

        Juego juego = new Juego("Rojo", "Azul");
        if (juego.getNombreJugadorActual().equals("Azul"))
            juego.finalizarTurno();
        Aldeano aldeano = (Aldeano) juego.getColocable(1, 8);
        juego.construirCuartel(aldeano, 1, 9);
        for (int i = 0; i < 6; i++) {
            juego.finalizarTurno();
        }

        Cuartel cuartel = (Cuartel) juego.getColocable(1, 9);
        juego.crearEspadachin(cuartel);
        juego.finalizarTurno();
        juego.finalizarTurno();
        juego.crearEspadachin(cuartel);
        Espadachin unEspadachin = (Espadachin) juego.getColocable(1, 11);
        Espadachin otroEspadachin = (Espadachin) juego.getColocable(2, 8);

        juego.atacar(unEspadachin, otroEspadachin);
    }

    @Test(expected = EdificioObjetivoEsPropioException.class)
    public void test12juegoEspadachinAtacaEdificioAliadoLanzaExcepcion() {

        Juego juego = new Juego("Rojo", "Azul");
        if (juego.getNombreJugadorActual().equals("Azul"))
            juego.finalizarTurno();
        Aldeano aldeano = (Aldeano) juego.getColocable(1, 8);
        juego.construirCuartel(aldeano, 1, 9);
        for (int i = 0; i < 6; i++) {
            juego.finalizarTurno();
        }

        Cuartel cuartel = (Cuartel) juego.getColocable(1, 9);
        juego.crearEspadachin(cuartel);
        Espadachin espadachin = (Espadachin) juego.getColocable(1, 11);

        juego.atacar(espadachin, cuartel);
    }

    @Test(expected = UnidadObjetivoEsPropiaException.class)
    public void test13juegoArqueroAtacaEspadachinAliadoLanzaExcepcion() {

        Juego juego = new Juego("Rojo", "Azul");
        if (juego.getNombreJugadorActual().equals("Azul"))
            juego.finalizarTurno();
        Aldeano aldeano = (Aldeano) juego.getColocable(1, 8);
        juego.construirCuartel(aldeano, 1, 9);
        for (int i = 0; i < 6; i++) {
            juego.finalizarTurno();
        }

        Cuartel cuartel = (Cuartel) juego.getColocable(1, 9);
        juego.crearArquero(cuartel);
        juego.finalizarTurno();
        juego.finalizarTurno();
        juego.crearEspadachin(cuartel);
        Arquero unArquero = (Arquero) juego.getColocable(1, 11);
        Espadachin otroEspadachin = (Espadachin) juego.getColocable(2, 8);

        juego.atacar(unArquero, otroEspadachin);
    }
    
    @Test
    public void test13juegoMoverHaciarCambiaUbicacionCorrectamente() {

        Juego juego = new Juego("Rojo", "Azul");
        if (juego.getNombreJugadorActual().equals("Azul")) {
            juego.finalizarTurno();
        }

        Aldeano aldeano1 = (Aldeano) juego.getColocable(1, 8);
        juego.moverUnidadHacia(aldeano1, 1, 9);
        Aldeano aldeano2 = (Aldeano) juego.getColocable(1, 9);

        Assert.assertNull(juego.getColocable(1, 8));
        Assert.assertEquals(aldeano1, aldeano2);
    }
}
