package vista;

import controlador.BotonCasilleroEventHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import modelo.juego.Juego;
import modelo.mapa.Mapa;

public class ContenedorPrincipal extends BorderPane {

    private Juego juego;

    public ContenedorPrincipal(String unJugador, String otroJugador) {
        this.juego = new Juego(unJugador, otroJugador);
        this.setMapa();
    }

    private void setMapa() {

        Mapa mapa = this.juego.getMapa();
        int base = mapa.getBase();
        int altura = mapa.getAltura();

        GridPane tablero = new GridPane();
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                Boton botonCasillero = new Boton("", new BotonCasilleroEventHandler(this.juego, i + 1, j + 1));
                botonCasillero.setPrefSize(30, 30);
                tablero.add(botonCasillero, j, i, 1, 1);
            }
        }
        this.setCenter(tablero);
    }

}
