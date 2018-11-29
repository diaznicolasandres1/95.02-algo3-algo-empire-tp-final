package vista;

import controlador.botonesaldeano.BotonConstruirCuartelFinEventHandler;
import controlador.botonesaldeano.BotonConstruirCuartelInicioEventHandler;
import controlador.botonesaldeano.BotonConstruirPlazaCentralInicioEventHandler;
import controlador.botonesaldeano.BotonRepararEdificioInicioEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.edificios.castillo.Castillo;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.juego.Juego;
import modelo.mapa.Mapa;
import modelo.unidades.Colocable;
import modelo.unidades.aldeano.Aldeano;

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
        this.dibujarMapaConCasilleroHandler();
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
        bottom.getChildren().add(jugadorActual);


    }
    public void dibujarMapaConCasilleroHandler() {
        DibujadorDeMapa dibujadorDeMapa = new DibujadorDeMapa(this.juego, this.tablero);
        dibujadorDeMapa.dibujarMapaConCasilleroHandler(this);
        this.setCenter(tablero);
    }


    public void dibujarMetodosAldeano(Juego juego, Aldeano aldeano, int fila, int col){
        this.bottom = new VBox(); //Reinicio el vbox de bottom

        BotonConstruirCuartelInicioEventHandler cuartelEventHandler = new BotonConstruirCuartelInicioEventHandler(juego,aldeano,this);
        Boton construirCuartel = new Boton("Construir Cuartel",cuartelEventHandler);

        BotonConstruirPlazaCentralInicioEventHandler plazaCentralEventHandler = new BotonConstruirPlazaCentralInicioEventHandler(juego,aldeano,fila,col);
        Boton construirPlaza = new Boton("Constuir Plaza Central", plazaCentralEventHandler);

        BotonRepararEdificioInicioEventHandler repararEdificioInicioEventHandler = new BotonRepararEdificioInicioEventHandler(juego,aldeano,fila,col);
        Boton repararEdificio = new Boton("Reparar edificio", repararEdificioInicioEventHandler);

        setjugadorActual();
        bottom.getChildren().addAll(construirCuartel,construirPlaza,repararEdificio);
        this.setBottom(bottom);
        bottom.setAlignment(Pos.CENTER);
    }

    public void cambiarHandlerCuartelFin(Aldeano aldeano){
        Mapa mapa = this.juego.getMapa();
        int base = mapa.getBase();
        int altura = mapa.getAltura();

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                Colocable colocable = juego.getColocable(i+1,j+1);
                
                Boton botonCasillero = new Boton("", new BotonConstruirCuartelFinEventHandler(juego,aldeano, i+1,j+1,this));

                if(colocable instanceof Aldeano){
                   botonCasillero.setTexto("A");
                   botonCasillero.setStyle("-fx-background-color: green");
                }
                else if(colocable instanceof Castillo) {
                    botonCasillero.setTexto("C");
                    botonCasillero.setStyle("-fx-background-color: blue");
                }
                else if(colocable instanceof PlazaCentral) {
                    botonCasillero.setTexto("P");
                    botonCasillero.setStyle("-fx-background-color: red");
                }
                else if(colocable instanceof Cuartel) {
                    botonCasillero.setTexto("C");
                    botonCasillero.setStyle("-fx-background-color: yellow");
                }
                this.tablero.add(botonCasillero, j, i, 1, 1);
                botonCasillero.setPrefSize(30, 30);
            }

        }
    }
}










