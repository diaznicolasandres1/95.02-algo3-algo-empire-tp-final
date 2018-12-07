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
                Button botonCasillero = new Button("");
                botonCasillero.setOnAction(new CasilleroEventHandler(this.juego, i + 1, j + 1, contenedor));
                this.dibujarColocable(colocable, botonCasillero,contenedor);
                this.tablero.add(botonCasillero, j, i, 1, 1);
            }
        }
    }

    public void dibujarColocable(Colocable colocable, Button botonCasillero, ContenedorPrincipal contenedor) {
        botonCasillero.setPrefSize(35, 35);
        if (colocable == null) {
            return;
        }
        
        String duenio = juego.getNombreJugadorDuenioDe(colocable);
        String color = contenedor.getColor(duenio);
        
        switch(colocable.getNombreClase()) {
            case "Aldeano":
                botonCasillero.setStyle("-fx-background-color: "+color+"green");
                botonCasillero.setText("a");
                break;
            case "Espadachin":
                botonCasillero.setStyle("-fx-background-color: "+color+"blue");
                botonCasillero.setText("E");
                break;
            case "Arquero":
                botonCasillero.setStyle("-fx-background-color: "+color+"yellow");
                botonCasillero.setText("A");
                break;
            case "Castillo":
                botonCasillero.setStyle("-fx-background-color: "+color+"cyan");
                botonCasillero.setText("C");
                break;
            case "Plaza central":
                botonCasillero.setStyle("-fx-background-color: "+color+"grey");
                botonCasillero.setText("P");
                break;
            case "Cuartel":
                botonCasillero.setStyle("-fx-background-color: "+color+"steelblue");
                botonCasillero.setText("C");
                break;
            case "Arma de asedio":
                botonCasillero.setStyle("-fx-background-color: "+color+"skyblue");
                botonCasillero.setText("Ar");
                break;
        }
    }
}
