package vista;

import controlador.BotonCasilleroEventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import modelo.edificios.castillo.Castillo;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.juego.Juego;
import modelo.mapa.Mapa;
import modelo.unidades.Colocable;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.armadeasedio.ArmaDeAsedio;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;

public class DibujadorDeMapa {

    private GridPane tablero;
    private Juego juego;

    public DibujadorDeMapa(Juego juego, GridPane tablero) {
        this.juego = juego;
        this.tablero = tablero;
    }

    public void dibujarMapaConCasilleroHandler(ContenedorPrincipal contenedor) {

        Mapa mapa = this.juego.getMapa();
        int base = mapa.getBase();
        int altura = mapa.getAltura();

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                Colocable colocable = this.juego.getColocable(i + 1, j + 1);
                Button botonCasillero = new Button("");
                botonCasillero.setOnAction( new BotonCasilleroEventHandler(this.juego, i + 1, j + 1, contenedor));
                dibujarColocable(colocable,botonCasillero);
                this.tablero.add(botonCasillero, j, i, 1, 1);
            }
        }
    }

    public void dibujarColocable(Colocable colocable, Button botonCasillero) {
        /*cambiar por switch*/

        if (colocable instanceof Aldeano) {
            botonCasillero.setText("A");
            botonCasillero.setStyle("-fx-background-color: green");
        } else if (colocable instanceof Espadachin) {
            botonCasillero.setText("E");
            botonCasillero.setStyle("-fx-background-color: white");
        } else if (colocable instanceof Arquero) {
            botonCasillero.setText("a");
            botonCasillero.setStyle("-fx-background-color: pink");
        } else if (colocable instanceof Castillo) {
            botonCasillero.setText("C");
            botonCasillero.setStyle("-fx-background-color: blue");
        } else if (colocable instanceof PlazaCentral) {
            botonCasillero.setText("P");
            botonCasillero.setStyle("-fx-background-color: red");
        } else if (colocable instanceof Cuartel) {
            botonCasillero.setText("c");
            botonCasillero.setStyle("-fx-background-color: yellow");
        } else if (colocable instanceof ArmaDeAsedio) {
            botonCasillero.setText("A");
            botonCasillero.setStyle("-fx-background-color: grey");
        }/*else un casillero con opacity:80 para que se vea el fondo pero cuando se abre un alert se lo sube (WTF)*/

        botonCasillero.setPrefSize(30, 30);
    }
}
