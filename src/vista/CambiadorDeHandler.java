package vista;

import controlador.botonesaldeano.BotonConstruirCuartelFinEventHandler;
import javafx.scene.layout.GridPane;
import modelo.juego.Juego;
import modelo.mapa.Mapa;
import modelo.unidades.Colocable;
import modelo.unidades.aldeano.Aldeano;

public class CambiadorDeHandler {
    private Juego juego;
    private GridPane tablero;
    private ContenedorPrincipal contenedorPrincipal;
    private DibujadorDeMapa dibujador;


    public CambiadorDeHandler(Juego juego, ContenedorPrincipal contenedorPrincipal, GridPane tablero){
        this.juego = juego;
        this.tablero = tablero;
        this.contenedorPrincipal = contenedorPrincipal;
        this.dibujador = new DibujadorDeMapa(juego,tablero);
    }

    public void cambiadorAConstruirCuartelFin(Aldeano aldeano){
        Mapa mapa = this.juego.getMapa();
        int base = mapa.getBase();
        int altura = mapa.getAltura();

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                Colocable colocable = juego.getColocable(i + 1, j + 1);
                Boton botonCasillero = new Boton("", new BotonConstruirCuartelFinEventHandler(juego,aldeano,i+1,j+1,contenedorPrincipal));
                dibujador.dibujarColocable(colocable,botonCasillero);
                this.tablero.add(botonCasillero, j, i, 1, 1);
            }
        }
    }
}
