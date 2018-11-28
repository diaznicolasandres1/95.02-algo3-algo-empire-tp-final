package vista;

import controlador.BotonCasilleroEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import modelo.juego.Juego;
import modelo.mapa.Mapa;

public class ContenedorPrincipal extends BorderPane {

    private Juego juego;
    private GridPane tablero = new GridPane();
    private String jugadorUno;
    private String jugadorDos;
    private VBox izquierdo = new VBox();
    private VBox derecho = new VBox();
    private VBox bottom = new VBox();


    public ContenedorPrincipal(String unJugador, String otroJugador) {
        this.juego = new Juego(unJugador, otroJugador);
        this.jugadorUno = unJugador;
        this.jugadorDos = otroJugador;
        this.setMapa();
        this.setCostados();
        this.setBottom();
    }

    private void setCostados(){
        VBox izquierdo = new VBox();
        VBox derecho = new VBox();
        Label tituloIzq = new Label(this.jugadorUno);
        Label tituloDer = new Label(this.jugadorDos);
        tituloDer.setPadding(new Insets(15));
        tituloIzq.setPadding(new Insets(15));
        tituloIzq.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        tituloDer.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        izquierdo.getChildren().addAll(tituloIzq);
        derecho.getChildren().addAll(tituloDer);
        this.setLeft(izquierdo);
        this.setRight(derecho);
    }

    private void setBottom(){

        setjugadorActual();
        Label comienzo = new Label("Clickea en una unidad o edificio para comenzar a jugar");
        bottom.getChildren().add(comienzo);
        this.setBottom(bottom);
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(20));

    }
    private void setjugadorActual(){
        Label jugadorActual = new Label("Es el turno de: "+this.juego.getNombreJugadorActual());
        jugadorActual.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        jugadorActual.setPadding(new Insets(20));
        jugadorActual.setAlignment(Pos.CENTER);
        bottom.getChildren().add(jugadorActual);


    }
    private void setMapa() {

        Mapa mapa = this.juego.getMapa();
        int base = mapa.getBase();
        int altura = mapa.getAltura();


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
