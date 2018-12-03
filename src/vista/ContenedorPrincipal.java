package vista;

import controlador.BotonCambiarTurnoEventHandler;
import controlador.BotonMoverUnidadHaciaInicioEventHandler;
import controlador.BotonSalirEventHandler;
import controlador.botonesaldeano.BotonConstruirCuartelInicioEventHandler;
import controlador.botonesaldeano.BotonConstruirPlazaCentralInicioEventHandler;
import controlador.botonesaldeano.BotonRepararEdificioInicioEventHandler;
import controlador.botonesarmadeasedio.BotonDesmontarArmaEventHandler;
import controlador.botonesarmadeasedio.BotonMontarArmaEventHandler;
import controlador.botonesataque.BotonAtacarInicioEventHandler;
import controlador.botonesdeedificios.BotonCrearAldeanoEventHandler;
import controlador.botonesdeedificios.BotonCrearArmaDeAsedioEventHandler;
import controlador.botonesdeedificios.BotonCrearArqueroEventHandler;
import controlador.botonesdeedificios.BotonCrearEspadachinEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
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
    private CambiadorDeHandler cambiadorDeHandler;
    private Juego juego;
    private GridPane tablero = new GridPane();
    private String jugadorUno;
    private String jugadorDos;
    private VBox izquierdo = new VBox();
    private VBox derecho = new VBox();
    private HBox bottom = new HBox();
   

    public ContenedorPrincipal(String unJugador, String otroJugador) {
        this.juego = new Juego(unJugador, otroJugador);
        this.jugadorUno = unJugador;
        this.jugadorDos = otroJugador;

        this.dibujarMapaConCasilleroHandler();
        this.setCostados();
        this.crearBottom();
        this.cambiadorDeHandler =  new CambiadorDeHandler(juego,this,tablero);
        Image fondo = new Image("file:src/vista/imagenes/fondoContenedor.jpg", 1600, 920, false, true);
        BackgroundImage imagenFondo = new BackgroundImage(fondo, BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenFondo));
    }



    private void setCostados(){

        Text tituloIzq = new Text(this.jugadorUno);
        Text tituloDer = new Text(this.jugadorDos);
        BotonCambiarTurnoEventHandler cambiadorTurno = new BotonCambiarTurnoEventHandler(juego,this);

        Button botonCambioTurno1 = new Button("Cambiar turno");
        botonCambioTurno1.setOnAction(cambiadorTurno);

        Button botonCambioTurno2 = new Button("Cambiar turno");
        botonCambioTurno2.setOnAction(cambiadorTurno);

        botonCambioTurno2.setPadding(new Insets(15));
        botonCambioTurno1.setPadding(new Insets(15));
        //tituloDer.setPadding(new Insets(15));
        //tituloIzq.setPadding(new Insets(15));
        tituloIzq.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        tituloDer.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        tituloDer.setFill(Color.WHITE);
        tituloIzq.setFill(Color.WHITE);


        izquierdo.setAlignment(Pos.TOP_LEFT);
        derecho.setAlignment(Pos.TOP_RIGHT);
        izquierdo.setSpacing(20);
        derecho.setSpacing(20);
        derecho.setPadding(new Insets(25));
        izquierdo.setPadding(new Insets(25));
        izquierdo.getChildren().addAll(tituloIzq, botonCambioTurno1);
        derecho.getChildren().addAll(tituloDer, botonCambioTurno2);
        this.setLeft(izquierdo);
        this.setRight(derecho);
        this.setPadding(new Insets(25));
    }

    public void crearBottom(){
        this.bottom = new HBox();
        setjugadorActual();
        Label comienzo = new Label("Clickea en una unidad o edificio");
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



    /*Meter esto en una clase Dibujadora de metodos*/

    public void dibujarMapaConCasilleroHandler() {
        DibujadorDeMapa dibujadorDeMapa = new DibujadorDeMapa(this.juego, this.tablero);
        dibujadorDeMapa.dibujarMapaConCasilleroHandler(this);
        this.setCenter(tablero);
    }

    public void dibujarMetodosAldeano(Aldeano aldeano){
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(3.0);
        dropShadow.setOffsetY(3.0);
        dropShadow.setColor(Color.color(0.4, 0.5, 0.5));

        this.bottom = new HBox(); //Reinicio el vbox de bottom

        BotonConstruirCuartelInicioEventHandler cuartelEventHandler = new BotonConstruirCuartelInicioEventHandler(juego,aldeano,this);
        Button construirCuartel = new Button("Construir Cuartel");
        construirCuartel.setOnAction(cuartelEventHandler);
        construirCuartel.setEffect(dropShadow);

        BotonConstruirPlazaCentralInicioEventHandler plazaCentralEventHandler = new BotonConstruirPlazaCentralInicioEventHandler(juego,aldeano,this);
        Button construirPlaza = new Button("Constuir Plaza Central");
        construirPlaza.setOnAction(plazaCentralEventHandler);
        construirPlaza.setEffect(dropShadow);

        BotonRepararEdificioInicioEventHandler repararEdificioInicioEventHandler = new BotonRepararEdificioInicioEventHandler(juego,aldeano,this);
        Button repararEdificio = new Button("Reparar edificio");
        repararEdificio.setOnAction(repararEdificioInicioEventHandler);
        construirPlaza.setEffect(dropShadow);


        BotonMoverUnidadHaciaInicioEventHandler moverHandler = new BotonMoverUnidadHaciaInicioEventHandler(juego,aldeano,this);
        Button moverAldeano = new Button("Mover aldeano");
        moverAldeano.setOnAction(moverHandler);
        moverAldeano.setEffect(dropShadow);

        setjugadorActual();
        bottom.setSpacing(10);
        bottom.getChildren().addAll(construirCuartel,construirPlaza,repararEdificio,moverAldeano);
        this.setBottom(bottom);
        bottom.setAlignment(Pos.CENTER);
    }

    public void dibujarMetodosCuartel(Cuartel cuartel){
        this.bottom = new HBox(); //Reinicio el vbox de bottom

        BotonCrearArqueroEventHandler arqueroHandler = new BotonCrearArqueroEventHandler(juego,cuartel,this);
        Button crearArquero = new Button("Crear arquero");
        crearArquero.setOnAction(arqueroHandler);

        BotonCrearEspadachinEventHandler espadachinEventHandler = new BotonCrearEspadachinEventHandler(juego,cuartel,this);
        Button crearEspadachin = new Button("Crear espadachin");
        crearEspadachin.setOnAction(espadachinEventHandler);

        setjugadorActual();
        bottom.setSpacing(10);
        bottom.getChildren().addAll(crearArquero,crearEspadachin);
        this.setBottom(bottom);
        bottom.setAlignment(Pos.CENTER);



    }

    public void dibujarMetodosArmaDeAsedio(ArmaDeAsedio armaDeAsedio){

        this.bottom = new HBox(); //Reinicio el vbox de bottom

        BotonMontarArmaEventHandler montarArmaEventHandler = new BotonMontarArmaEventHandler(juego,armaDeAsedio,this );
        Button montarArma = new Button("Montar arma de asedio");
        montarArma.setOnAction(montarArmaEventHandler);

        BotonDesmontarArmaEventHandler desmontarArmaEventHandler = new BotonDesmontarArmaEventHandler(juego,armaDeAsedio,this);
        Button desmontarArma = new Button("Desmontar arma de asedio");
        desmontarArma.setOnAction(desmontarArmaEventHandler);

        BotonAtacarInicioEventHandler atacarInicioEventHandler = new BotonAtacarInicioEventHandler(juego,armaDeAsedio,this);
        Button atacar = new Button("Atacar");
        atacar.setOnAction(atacarInicioEventHandler);

        BotonMoverUnidadHaciaInicioEventHandler moverHandler = new BotonMoverUnidadHaciaInicioEventHandler(juego,(Unidad)armaDeAsedio,this);
        Button moverArma = new Button("Mover unidad");
        moverArma.setOnAction(moverHandler);

        setjugadorActual();
        bottom.setSpacing(10);
        bottom.getChildren().addAll(montarArma,desmontarArma,atacar,moverArma);
        this.setBottom(bottom);
        bottom.setAlignment(Pos.CENTER);
    }

    public void dibujarMetodosPlazaCentral(PlazaCentral plaza){
        this.bottom = new HBox(); //Reinicio el vbox de bottom
        BotonCrearAldeanoEventHandler crearAldeanoEventHandler  = new BotonCrearAldeanoEventHandler(juego,plaza,this);
        Button crearAldeano = new Button("Crear Aldeano");
        crearAldeano.setOnAction(crearAldeanoEventHandler);
        setjugadorActual();
        bottom.setSpacing(10);
        bottom.getChildren().addAll(crearAldeano);
        this.setBottom(bottom);
        bottom.setAlignment(Pos.CENTER);
    }

    public void dibujarMetodoEspadachinOArquero(Atacante atacante){
        this.bottom = new HBox(); //Reinicio el vbox de bottom
        BotonAtacarInicioEventHandler atacarInicioEventHandler = new BotonAtacarInicioEventHandler(juego,atacante,this);
        Button atacar = new Button("Atacar");
        atacar.setOnAction(atacarInicioEventHandler);

        BotonMoverUnidadHaciaInicioEventHandler moverHandler = new BotonMoverUnidadHaciaInicioEventHandler(juego,(Unidad)atacante,this);
        Button moverEspadachin = new Button("Mover unidad");
        moverEspadachin.setOnAction(moverHandler);

        setjugadorActual();
        bottom.setSpacing(10);
        bottom.getChildren().addAll(atacar,moverEspadachin);

        this.setBottom(bottom);
        bottom.setAlignment(Pos.CENTER);

    }

    public void dibujarMetodosCastillo(Castillo castillo) {
        this.bottom = new HBox(); //Reinicio el vbox de bottom
        BotonCrearArmaDeAsedioEventHandler armaDeAsedioEventHandler = new BotonCrearArmaDeAsedioEventHandler(juego,castillo,this);
        Button crearArmaDeAsedio = new Button("Crear arma de asedio");
        crearArmaDeAsedio.setOnAction(armaDeAsedioEventHandler);
        setjugadorActual();
        bottom.setSpacing(10);
        bottom.getChildren().addAll(crearArmaDeAsedio);
        this.setBottom(bottom);

        bottom.setAlignment(Pos.CENTER);
    }






    /*Cambiadores de handlers*/

    public void cambiarHandlerConstruirCuartel(Aldeano aldeano){
        cambiadorDeHandler.cambiadorAConstruirCuartelFin(aldeano);
    }

    public void cambiarHandlerConstuirPlazaCentral(Aldeano aldeano){
        cambiadorDeHandler.cambiadorAConstruirPlazaCentralFin(aldeano);
    }

    public void cambiarHandlerRepararEdificio(Aldeano aldeano){
        cambiadorDeHandler.cambiadorRepararEdificio(aldeano);
    }

    public void cambiarHandlerMoverUnidad(Unidad unidad) {
        cambiadorDeHandler.cambiadorMoverUnidad(unidad);
    }

    public void cambiarHandlerAtaque(Atacante atacante) {
        cambiadorDeHandler.cambiarHandlerAtaque(atacante);

    }


}










