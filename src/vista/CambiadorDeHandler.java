package vista;

import controlador.FinalizarMoverUnidadEventHandler;
import controlador.botonesaldeano.FinalizarConstruccionCuartelEventHandler;
import controlador.botonesaldeano.FinalizarConstruccionPlazaCentralEventHandler;
import controlador.botonesaldeano.FinalizarReparacionEdificioEventHandler;
import controlador.botonesataque.FinalizarAtaqueEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import modelo.juego.Juego;
import modelo.mapa.Mapa;
import modelo.unidades.Atacante;
import modelo.unidades.Colocable;
import modelo.unidades.Unidad;
import modelo.unidades.aldeano.Aldeano;

public class CambiadorDeHandler {

    private final Juego juego;
    private final GridPane tablero;
    private final ContenedorPrincipal contenedorPrincipal;
    private final DibujadorDeMapa dibujador;
    private final int base;
    private final int altura;

    public CambiadorDeHandler(Juego juego, ContenedorPrincipal contenedorPrincipal, GridPane tablero, String jugadorUno, String jugadorDos) {
        this.juego = juego;
        this.tablero = tablero;
        this.contenedorPrincipal = contenedorPrincipal;
        this.dibujador = new DibujadorDeMapa(juego, tablero, jugadorUno, jugadorDos);
        Mapa mapa = juego.getMapa();
        this.base = mapa.getBase();
        this.altura = mapa.getAltura();
    }

    public void cambiadorAConstruirCuartelFin(Aldeano aldeano) {
        for (int i = 0; i < this.altura; i++) {
            for (int j = 0; j < this.base; j++) {
                Colocable colocable = this.juego.getColocable(i + 1, j + 1);
                Button botonCasillero = new Button("");
                botonCasillero.setOnAction(new FinalizarConstruccionCuartelEventHandler(this.juego, aldeano, i + 1, j + 1, this.contenedorPrincipal));
                this.dibujador.dibujarColocable(colocable, botonCasillero);
                this.tablero.add(botonCasillero, j, i, 1, 1);
            }
        }
    }

    public void cambiadorAConstruirPlazaCentralFin(Aldeano aldeano) {
        for (int i = 0; i < this.altura; i++) {
            for (int j = 0; j < this.base; j++) {
                Colocable colocable = this.juego.getColocable(i + 1, j + 1);
                Button botonCasillero = new Button("");
                botonCasillero.setOnAction(new FinalizarConstruccionPlazaCentralEventHandler(this.juego, aldeano, i + 1, j + 1, this.contenedorPrincipal));
                this.dibujador.dibujarColocable(colocable, botonCasillero);
                this.tablero.add(botonCasillero, j, i, 1, 1);
            }
        }
    }

    public void cambiadorRepararEdificio(Aldeano aldeano) {
        for (int i = 0; i < this.altura; i++) {
            for (int j = 0; j < this.base; j++) {
                Colocable colocable = this.juego.getColocable(i + 1, j + 1);
                Button botonCasillero = new Button("");
                botonCasillero.setOnAction(new FinalizarReparacionEdificioEventHandler(this.juego, aldeano, i + 1, j + 1, this.contenedorPrincipal));
                this.dibujador.dibujarColocable(colocable, botonCasillero);
                this.tablero.add(botonCasillero, j, i, 1, 1);
            }
        }

    }

    public void cambiadorMoverUnidad(Unidad unidad) {
        for (int i = 0; i < this.altura; i++) {
            for (int j = 0; j < this.base; j++) {
                Colocable colocable = this.juego.getColocable(i + 1, j + 1);
                Button botonCasillero = new Button("");
                botonCasillero.setOnAction(new FinalizarMoverUnidadEventHandler(this.juego, unidad, i + 1, j + 1, this.contenedorPrincipal));
                this.dibujador.dibujarColocable(colocable, botonCasillero);
                this.tablero.add(botonCasillero, j, i, 1, 1);
            }
        }
    }

    public void cambiarHandlerAtaque(Atacante atacante) {
        for (int i = 0; i < this.altura; i++) {
            for (int j = 0; j < this.base; j++) {
                Colocable colocable = this.juego.getColocable(i + 1, j + 1);
                Button botonCasillero = new Button("");
                botonCasillero.setOnAction(new FinalizarAtaqueEventHandler(this.juego, atacante, i + 1, j + 1, this.contenedorPrincipal));
                this.dibujador.dibujarColocable(colocable, botonCasillero);
                this.tablero.add(botonCasillero, j, i, 1, 1);
            }
        }
    }
}
