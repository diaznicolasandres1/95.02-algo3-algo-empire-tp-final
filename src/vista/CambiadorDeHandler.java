package vista;

import controlador.BotonMoverUnidadHaciaFinEventHandler;
import controlador.botonesaldeano.BotonConstruirCuartelFinEventHandler;
import controlador.botonesaldeano.BotonConstruirPlazaCentralFinEventHandler;
import controlador.botonesaldeano.BotonRepararEdificioFinEventHandler;
import controlador.botonesataque.BotonAtacarFinEventHandler;
import javafx.scene.layout.GridPane;
import modelo.juego.Juego;
import modelo.mapa.Mapa;
import modelo.unidades.Atacante;
import modelo.unidades.Colocable;
import modelo.unidades.Unidad;
import modelo.unidades.aldeano.Aldeano;

public class CambiadorDeHandler {

    private Juego juego;
    private GridPane tablero;
    private ContenedorPrincipal contenedorPrincipal;
    private DibujadorDeMapa dibujador;
    private Mapa mapa;
    private int base;
    private int altura;

    public CambiadorDeHandler(Juego juego, ContenedorPrincipal contenedorPrincipal, GridPane tablero){
        this.juego = juego;
        this.tablero = tablero;
        this.contenedorPrincipal = contenedorPrincipal;
        this.dibujador = new DibujadorDeMapa(juego,tablero);
        this.mapa = juego.getMapa();
        this.base = mapa.getBase();
        this.altura = mapa.getAltura();
    }

    // TRATAR DE REFACTORIZAR ESTO POR EL CODIGO REPETIDO
    public void cambiadorAConstruirCuartelFin(Aldeano aldeano){
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                Colocable colocable = juego.getColocable(i + 1, j + 1);
                Boton botonCasillero = new Boton("", new BotonConstruirCuartelFinEventHandler(juego, aldeano, i + 1, j + 1, contenedorPrincipal));
                dibujador.dibujarColocable(colocable, botonCasillero);
                this.tablero.add(botonCasillero, j, i, 1, 1);
            }
        }
    }

    public void cambiadorAConstruirPlazaCentralFin(Aldeano aldeano){
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                Colocable colocable = juego.getColocable(i + 1, j + 1);
                Boton botonCasillero = new Boton("", new BotonConstruirPlazaCentralFinEventHandler(juego, aldeano, i + 1, j + 1, contenedorPrincipal));
                dibujador.dibujarColocable(colocable, botonCasillero);
                this.tablero.add(botonCasillero, j, i, 1, 1);
            }
        }
    }

    public void cambiadorRepararEdificio(Aldeano aldeano) {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                Colocable colocable = juego.getColocable(i + 1, j + 1);
                Boton botonCasillero = new Boton("", new BotonRepararEdificioFinEventHandler(juego, aldeano, i + 1, j + 1, contenedorPrincipal));
                dibujador.dibujarColocable(colocable, botonCasillero);
                this.tablero.add(botonCasillero, j, i, 1, 1);
            }
        }

    }

    public void cambiadorMoverUnidad(Unidad unidad) {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                Colocable colocable = juego.getColocable(i + 1, j + 1);
                Boton botonCasillero = new Boton("", new BotonMoverUnidadHaciaFinEventHandler(juego, unidad, i + 1, j + 1, contenedorPrincipal));
                dibujador.dibujarColocable(colocable, botonCasillero);
                this.tablero.add(botonCasillero, j, i, 1, 1);
            }
        }
    }

    public void cambiarHandlerAtaque(Atacante atacante) {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                Colocable colocable = juego.getColocable(i + 1, j + 1);
                Boton botonCasillero = new Boton("", new BotonAtacarFinEventHandler(juego, atacante, i + 1, j + 1, contenedorPrincipal));
                dibujador.dibujarColocable(colocable, botonCasillero);
                this.tablero.add(botonCasillero, j, i, 1, 1);
            }
        }
    }
}
