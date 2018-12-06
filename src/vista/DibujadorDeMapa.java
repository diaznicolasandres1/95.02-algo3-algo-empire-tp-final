package vista;

import controlador.CasilleroEventHandler;
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

    private final GridPane tablero;
    private final Juego juego;


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
                String duenio = juego.getNombreJugadorDuenioDe(colocable);
                String color = contenedor.getColor(duenio);
                Button botonCasillero = new Button("");
                botonCasillero.setOnAction(new CasilleroEventHandler(this.juego, i + 1, j + 1, contenedor));
                this.dibujarColocable(colocable, botonCasillero,contenedor);
                this.tablero.add(botonCasillero, j, i, 1, 1);
            }
        }
    }

    public void dibujarColocable(Colocable colocable, Button botonCasillero, ContenedorPrincipal contenedor) {
        String duenio = juego.getNombreJugadorDuenioDe(colocable);
        String color = contenedor.getColor(duenio);


        if (colocable instanceof Aldeano) {
            botonCasillero.setStyle("-fx-background-color: "+color+"green");
            botonCasillero.setText("a");

        } else if (colocable instanceof Espadachin) {
            botonCasillero.setStyle("-fx-background-color: "+color+"blue");
            botonCasillero.setText("E");

        } else if (colocable instanceof Arquero) {
            botonCasillero.setStyle("-fx-background-color: "+color+"yellow");
            botonCasillero.setText("A");

        } else if (colocable instanceof Castillo) {
            botonCasillero.setStyle("-fx-background-color: "+color+"cyan");
            botonCasillero.setText("C");

        } else if (colocable instanceof PlazaCentral) {
            botonCasillero.setStyle("-fx-background-color: "+color+"grey");
            botonCasillero.setText("P");

        } else if (colocable instanceof Cuartel) {
            botonCasillero.setStyle("-fx-background-color: "+color+"steelblue");
            botonCasillero.setText("C");

        } else if (colocable instanceof ArmaDeAsedio) {
            botonCasillero.setStyle("-fx-background-color: "+color+"skyblue");
            botonCasillero.setText("Ar");

        }
        botonCasillero.setPrefSize(35, 35);
    }
}
