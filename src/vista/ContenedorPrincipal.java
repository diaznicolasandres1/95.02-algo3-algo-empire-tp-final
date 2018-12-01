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
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
    private VBox bottom = new VBox();
    public ArrayList<Boton> botones = new ArrayList<Boton>();

    public ContenedorPrincipal(String unJugador, String otroJugador) {
        this.juego = new Juego(unJugador, otroJugador);
        this.jugadorUno = unJugador;
        this.jugadorDos = otroJugador;

        this.dibujarMapaConCasilleroHandler();
        this.setCostados();
        this.crearBottom();
        this.cambiadorDeHandler =  new CambiadorDeHandler(juego,this,tablero);
    }



    private void setCostados(){

        Label tituloIzq = new Label(this.jugadorUno);
        Label tituloDer = new Label(this.jugadorDos);
        BotonCambiarTurnoEventHandler cambiadorTurno = new BotonCambiarTurnoEventHandler(juego,this);
        Boton botonCambioTurno1 = new Boton("Cambiar Turno",cambiadorTurno);
        Boton botonCambioTurno2 = new Boton("Cambiar Turno",cambiadorTurno);
        botonCambioTurno2.setPadding(new Insets(15));
        botonCambioTurno1.setPadding(new Insets(15));
        tituloDer.setPadding(new Insets(15));
        tituloIzq.setPadding(new Insets(15));
        tituloIzq.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        tituloDer.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
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
        this.bottom = new VBox();
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
        this.bottom = new VBox(); //Reinicio el vbox de bottom

        BotonConstruirCuartelInicioEventHandler cuartelEventHandler = new BotonConstruirCuartelInicioEventHandler(juego,aldeano,this);
        Boton construirCuartel = new Boton("Construir Cuartel",cuartelEventHandler);

        BotonConstruirPlazaCentralInicioEventHandler plazaCentralEventHandler = new BotonConstruirPlazaCentralInicioEventHandler(juego,aldeano,this);
        Boton construirPlaza = new Boton("Constuir Plaza Central", plazaCentralEventHandler);

        BotonRepararEdificioInicioEventHandler repararEdificioInicioEventHandler = new BotonRepararEdificioInicioEventHandler(juego,aldeano,this);
        Boton repararEdificio = new Boton("Reparar edificio", repararEdificioInicioEventHandler);

        BotonMoverUnidadHaciaInicioEventHandler moverHandler = new BotonMoverUnidadHaciaInicioEventHandler(juego,aldeano,this);
        Boton moverAldeano = new Boton("Mover aldeano",moverHandler);

        setjugadorActual();
        bottom.getChildren().addAll(construirCuartel,construirPlaza,repararEdificio,moverAldeano);
        this.setBottom(bottom);
        bottom.setAlignment(Pos.CENTER);
    }

    public void dibujarMetodosCuartel(Cuartel cuartel){
        this.bottom = new VBox(); //Reinicio el vbox de bottom

        BotonCrearArqueroEventHandler arqueroHandler = new BotonCrearArqueroEventHandler(juego,cuartel,this);
        Boton crearArquero = new Boton("Crear arquero",arqueroHandler);

        BotonCrearEspadachinEventHandler espadachinEventHandler = new BotonCrearEspadachinEventHandler(juego,cuartel,this);
        Boton crearEspadachin = new Boton("Crear espadachin", espadachinEventHandler);

        setjugadorActual();
        bottom.getChildren().addAll(crearArquero,crearEspadachin);
        this.setBottom(bottom);
        bottom.setAlignment(Pos.CENTER);



    }

    public void dibujarMetodosArmaDeAsedio(ArmaDeAsedio armaDeAsedio){
        this.bottom = new VBox(); //Reinicio el vbox de bottom

        BotonMontarArmaEventHandler montarArmaEventHandler = new BotonMontarArmaEventHandler(juego,armaDeAsedio,this );
        Boton montarArma = new Boton("Montar arma de asedio",montarArmaEventHandler);

        BotonDesmontarArmaEventHandler desmontarArmaEventHandler = new BotonDesmontarArmaEventHandler(juego,armaDeAsedio,this);
        Boton desmontarArma = new Boton("Desmontar arma de asedio",desmontarArmaEventHandler);

        setjugadorActual();
        bottom.getChildren().addAll(montarArma,desmontarArma);
        this.setBottom(bottom);
        bottom.setAlignment(Pos.CENTER);
    }

    public void dibujarMetodosPlazaCentral(PlazaCentral plaza){
        this.bottom = new VBox(); //Reinicio el vbox de bottom
        BotonCrearAldeanoEventHandler crearAldeanoEventHandler  = new BotonCrearAldeanoEventHandler(juego,plaza,this);
        Boton crearAldeano = new Boton("Crear Aldeano",crearAldeanoEventHandler);
        setjugadorActual();
        bottom.getChildren().addAll(crearAldeano);
        this.setBottom(bottom);
        bottom.setAlignment(Pos.CENTER);
    }

    public void dibujarMetodoEspadachinOArquero(Atacante atacante){
        this.bottom = new VBox(); //Reinicio el vbox de bottom
        BotonAtacarInicioEventHandler atacarInicioEventHandler = new BotonAtacarInicioEventHandler(juego,atacante,this);
        Boton atacar = new Boton("Atacar",atacarInicioEventHandler);

        BotonMoverUnidadHaciaInicioEventHandler moverHandler = new BotonMoverUnidadHaciaInicioEventHandler(juego,(Unidad)atacante,this);
        Boton moverEspadachin = new Boton("Mover unidad",moverHandler);

        setjugadorActual();
        bottom.getChildren().addAll(atacar,moverEspadachin);
        this.setBottom(bottom);
        bottom.setAlignment(Pos.CENTER);

    }

    public void dibujarMetodosCastillo(Castillo castillo) {
        this.bottom = new VBox(); //Reinicio el vbox de bottom
        BotonCrearArmaDeAsedioEventHandler armaDeAsedioEventHandler = new BotonCrearArmaDeAsedioEventHandler(juego,castillo,this);
        Boton crearArmaDeAsedio = new Boton("Crear arma de asedio",armaDeAsedioEventHandler);
        setjugadorActual();
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










