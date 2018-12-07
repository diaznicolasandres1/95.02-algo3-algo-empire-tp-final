package vista;

import controlador.CasilleroEventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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


import java.awt.*;

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
            Image pasto = new Image("file:src/vista/imagenes/pasto.png",35,35,true,false);
            botonCasillero.setGraphic(new ImageView(pasto));
            botonCasillero.setStyle("-fx-padding:0");
            return;
        }
        
        String duenio = juego.getNombreJugadorDuenioDe(colocable);
        String color = contenedor.getColor(duenio);
        
        switch(colocable.getNombreClase()) {
            case "Aldeano":
                Image aldeano = new Image("file:src/vista/imagenes/372.png",35,35,true,false);
                botonCasillero.setGraphic(new ImageView(aldeano));

                break;
            case "Espadachin":
                Image espadachin = new Image("file:src/vista/imagenes/espadachin.png",35,35,true,false);
                botonCasillero.setGraphic(new ImageView(espadachin));



                break;
            case "Arquero":
                Image arquero = new Image("file:src/vista/imagenes/arquero.jpg",35,35,true,false);
                botonCasillero.setGraphic(new ImageView(arquero));

                break;
            case "Castillo":
                Image castillo = new Image("file:src/vista/imagenes/castillo.jpg",35,35,true,false);
                botonCasillero.setGraphic(new ImageView(castillo));

                break;
            case "Plaza central":
                Image plaza = new Image("file:src/vista/imagenes/plazacentral.jpg",35,35,true,false);
                botonCasillero.setGraphic(new ImageView(plaza));

                break;
            case "Cuartel":
                Image cuartel = new Image("file:src/vista/imagenes/cuartel.jpg",35,35,true,false);
                botonCasillero.setGraphic(new ImageView(cuartel));

                break;
            case "Arma de asedio":
                Image armaasedio = new Image("file:src/vista/imagenes/armaasedio.jpg",35,35,true,false);
                botonCasillero.setGraphic(new ImageView(armaasedio));

                break;
        }
        botonCasillero.setStyle("-fx-padding:0");

    }
}
