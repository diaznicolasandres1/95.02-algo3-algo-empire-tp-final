package vista;

import controlador.BotonCambiarTurnoEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import modelo.edificios.castillo.Castillo;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.juego.Juego;
import modelo.unidades.Atacante;
import modelo.unidades.Unidad;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.armadeasedio.ArmaDeAsedio;

import java.util.ArrayList;

public class ContenedorPrincipal extends BorderPane {

    private final CambiadorDeHandler cambiadorDeHandler;
    private final CreadorDeBotones creadorDeBotones;
    private final Juego juego;
    private final GridPane tablero = new GridPane();
    private final String jugadorUno;
    private final String jugadorDos;
    private VBox izquierdo = new VBox();
    private VBox derecho = new VBox();
    private VBox mensajesIzq = new VBox();
    private VBox mensajesDer = new VBox();
    private HBox bottom = new HBox();
    private static final String RUTA_IMG_FONDO = "file:src/vista/imagenes/fondo_juego_1.jpg";

    public ContenedorPrincipal(String jugadorUno, String jugadorDos) {
        this.jugadorUno = jugadorUno;
        this.jugadorDos = jugadorDos;
        this.juego = new Juego(jugadorUno, jugadorDos);
        this.dibujarMapaConCasilleroHandler();
        this.setCostados(100,100,3,3);
        this.crearBottom();
        this.creadorDeBotones = new CreadorDeBotones();
        this.cambiadorDeHandler = new CambiadorDeHandler(this.juego, this, this.tablero);

        Image fondo = new Image(RUTA_IMG_FONDO, 1590, 1020, false, true);

        BackgroundImage imagenFondo = new BackgroundImage(fondo, BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenFondo));
    }

    public void setCostados(int oroJugadorAnterior, int oroJugadorActual,int poblacionAnterior, int poblacionActual) {

        this.izquierdo.getChildren().clear();
        this.derecho.getChildren().clear();

        Text tituloIzq = new Text(this.jugadorUno);
        Text tituloDer = new Text(this.jugadorDos);

        BotonCambiarTurnoEventHandler cambiadorTurno = new BotonCambiarTurnoEventHandler(this.juego, this);
        Button botonFinalizarTurno = new Button("Finalizar Turno");
        botonFinalizarTurno.setOnAction(cambiadorTurno);
        botonFinalizarTurno.setPadding(new Insets(15));
        tituloIzq.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        tituloDer.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        tituloDer.setFill(Color.WHITE);
        tituloIzq.setFill(Color.WHITE);
        this.izquierdo.setAlignment(Pos.TOP_LEFT);
        this.derecho.setAlignment(Pos.TOP_RIGHT);
        this.izquierdo.setSpacing(20);
        this.derecho.setSpacing(20);
        this.derecho.setPadding(new Insets(25));
        this.izquierdo.setPadding(new Insets(25));

        Text oroIzq;
        Text oroDer;
        Text poblacionIzq;
        Text poblacionDer;

        if (this.juego.getNombreJugadorActual().equals(this.jugadorUno)) {
            oroIzq = new Text("Oro: "+ oroJugadorActual);
            poblacionIzq = new Text("Poblacion: "+ poblacionActual);

            oroDer = new Text ("Oro: "+ oroJugadorAnterior);
            poblacionDer = new Text("Poblacion: "+ poblacionAnterior);
        } else {
            oroDer = new Text("Oro: "+ oroJugadorActual);
            poblacionDer = new Text("Poblacion: "+ poblacionActual);

            oroIzq = new Text ("Oro: "+ oroJugadorAnterior);
            poblacionIzq = new Text("Poblacion: "+ poblacionAnterior);
        }

        oroIzq.setFont(Font.font(17));
        oroDer.setFont(Font.font(17));
        poblacionDer.setFont(Font.font(17));
        poblacionIzq.setFont(Font.font(17));
        oroIzq.setFill(Color.WHITE);
        oroDer.setFill(Color.WHITE);
        poblacionDer.setFill(Color.WHITE);
        poblacionIzq.setFill(Color.WHITE);

        this.izquierdo.getChildren().addAll(tituloIzq, oroIzq, poblacionIzq, this.mensajesIzq);
        this.derecho.getChildren().addAll(tituloDer, oroDer, poblacionDer, this.mensajesDer);
        if (this.juego.getNombreJugadorActual().equals(this.jugadorUno)) {
            this.izquierdo.getChildren().add(3, botonFinalizarTurno);
        } else {
            this.derecho.getChildren().add(3, botonFinalizarTurno);
        }
        this.setLeft(this.izquierdo);
        this.setRight(this.derecho);
        this.setPadding(new Insets(25));
    }
    
    public void moverFinalizarTurno() {
        if (this.juego.getNombreJugadorActual().equals(this.jugadorUno)) {
            Button botonFinalizar = (Button)this.derecho.getChildren().remove(3);
            this.izquierdo.getChildren().add(3, botonFinalizar);
        } else {
            Button botonFinalizar = (Button)this.izquierdo.getChildren().remove(3);
            this.derecho.getChildren().add(3, botonFinalizar);
        }
    }
    
    public void actualizarOro() {

        int oroActual = this.juego.getOroJugadorActual();

        if (this.juego.getNombreJugadorActual().equals(this.jugadorUno)) {
            Text oroIzq = new Text("Oro: "+ oroActual);
            oroIzq.setFill(Color.WHITE);
            this.izquierdo.getChildren().set(1, oroIzq);
        } else {
            Text oroDer = new Text("Oro: "+ oroActual);
            oroDer.setFill(Color.WHITE);
            this.derecho.getChildren().set(1, oroDer);
        }
    }
    
    public void actualizarPoblacion() {

        int poblacionActual = this.juego.getPoblacionJugadorActual();

        if (this.juego.getNombreJugadorActual().equals(this.jugadorUno)) {
            Text poblacionIzq = new Text("Poblacion: "+ poblacionActual);
            poblacionIzq.setFill(Color.WHITE);
            this.izquierdo.getChildren().set(2, poblacionIzq);
        } else {
            Text poblacionDer = new Text("Poblacion: "+ poblacionActual);
            poblacionDer.setFill(Color.WHITE);
            this.derecho.getChildren().set(2, poblacionDer);
        }
    }

    public void crearBottom() {
        this.bottom = new HBox();
        this.setjugadorActual();
        Label comienzo = new Label("Clickea en una unidad o edificio");
        comienzo.setTextFill(Color.WHITE);
        this.bottom.getChildren().add(comienzo);
        this.setBottom(this.bottom);
        this.bottom.setAlignment(Pos.CENTER);
        this.bottom.setPadding(new Insets(20));
    }

    private void setjugadorActual() {
        Label jugadorActual = new Label("Es el turno de: " + this.juego.getNombreJugadorActual());
        jugadorActual.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        jugadorActual.setPadding(new Insets(20));
        jugadorActual.setTextFill(Color.WHITE);
        this.bottom.getChildren().addAll(jugadorActual);
    }

    public void dibujarMapaConCasilleroHandler() {
        DibujadorDeMapa dibujadorDeMapa = new DibujadorDeMapa(this.juego, this.tablero);
        dibujadorDeMapa.dibujarMapaConCasilleroHandler(this);
        this.setCenter(this.tablero);
    }

    public void dibujarMetodosAldeano(Aldeano aldeano) {
        this.setMensaje("Aldeano\n❤ Vida:"+ aldeano.getVida());
        this.bottom.getChildren().clear();
        ArrayList<Button> botones = this.creadorDeBotones.crearBotonesPara(aldeano, this.juego, this);
        this.configurarBottom();
        botones.forEach(boton -> this.bottom.getChildren().add(boton));
    }

    public void dibujarMetodosCuartel(Cuartel cuartel) {
        this.setMensaje("Cuartel\n❤ Vida:"+ cuartel.getVida());
        this.bottom.getChildren().clear();
        ArrayList<Button> botones = this.creadorDeBotones.crearBotonesPara(cuartel, this.juego, this);
        this.configurarBottom();
        botones.forEach(boton -> this.bottom.getChildren().add(boton));
    }

    public void dibujarMetodosArmaDeAsedio(ArmaDeAsedio armaDeAsedio) {
        this.setMensaje("ArmaDeAsedio\n❤ Vida:"+ armaDeAsedio.getVida());
        this.bottom.getChildren().clear();
        ArrayList<Button> botones = this.creadorDeBotones.crearBotonesPara(armaDeAsedio, this.juego, this);
        this.configurarBottom();
        botones.forEach(boton -> this.bottom.getChildren().add(boton));
    }

    public void dibujarMetodosPlazaCentral(PlazaCentral plaza) {
        this.setMensaje("Plaza Central\n❤ Vida:"+ plaza.getVida());
        this.bottom.getChildren().clear();
        ArrayList<Button> botones = this.creadorDeBotones.crearBotonesPara(plaza, this.juego, this);
        this.configurarBottom();
        botones.forEach(boton -> this.bottom.getChildren().add(boton));
    }

    public void dibujarMetodoEspadachinOArquero(Atacante atacante) {
        Unidad unidad = (Unidad)atacante;
        this.setMensaje("atacante\n❤ Vida:"+ unidad.getVida());
        this.bottom.getChildren().clear();
        ArrayList<Button> botones = this.creadorDeBotones.crearBotonesPara(atacante, this);
        this.configurarBottom();
        botones.forEach(boton -> this.bottom.getChildren().add(boton));
    }

    public void dibujarMetodosCastillo(Castillo castillo) {
        this.setMensaje("Castillo\n❤ Vida:"+ castillo.getVida());
        this.bottom.getChildren().clear();
        ArrayList<Button> botones = this.creadorDeBotones.crearBotonesPara(castillo, this.juego, this);
        this.configurarBottom();
        botones.forEach(boton -> this.bottom.getChildren().add(boton));
    }

    private void configurarBottom() {
        this.setjugadorActual();
        this.bottom.setSpacing(10);
        this.bottom.setAlignment(Pos.CENTER);
    }
    
    public void setMensaje(String mensaje) {
        Text texto = new Text(mensaje);
        texto.setFont(Font.font(17));
        texto.setFill(Color.WHITE);
        texto.setTextAlignment(TextAlignment.LEFT);
        if (this.juego.getNombreJugadorActual().equals(this.jugadorUno)) {
            this.mensajesIzq.getChildren().clear();
            this.mensajesIzq.getChildren().add(texto);
        } else {
            this.mensajesDer.getChildren().clear();
            this.mensajesDer.getChildren().add(texto);
        }
    }
    
    public void clearMensajes() {
        if (this.juego.getNombreJugadorActual().equals(this.jugadorUno)) {
            this.mensajesIzq.getChildren().clear();
        } else {
            this.mensajesDer.getChildren().clear();
        }
    }

    /* Cambiadores de handlers */

    public void cambiarHandlerConstruirCuartel(Aldeano aldeano) {
        this.cambiadorDeHandler.cambiadorAConstruirCuartelFin(aldeano);
    }

    public void cambiarHandlerConstuirPlazaCentral(Aldeano aldeano) {
        this.cambiadorDeHandler.cambiadorAConstruirPlazaCentralFin(aldeano);
    }

    public void cambiarHandlerRepararEdificio(Aldeano aldeano) {
        this.cambiadorDeHandler.cambiadorRepararEdificio(aldeano);
    }

    public void cambiarHandlerMoverUnidad(Unidad unidad) {
        this.cambiadorDeHandler.cambiadorMoverUnidad(unidad);
    }

    public void cambiarHandlerAtaque(Atacante atacante) {
        this.cambiadorDeHandler.cambiarHandlerAtaque(atacante);
    }
}
