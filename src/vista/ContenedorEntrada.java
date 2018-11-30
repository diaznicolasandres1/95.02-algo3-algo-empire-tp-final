package vista;

import controlador.BotonJugarEventHandler;
import controlador.BotonSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ContenedorEntrada extends VBox {

    private ArrayList<EntradaUsuario> jugadores;

    public ContenedorEntrada() {

        super();
        this.jugadores = new ArrayList<>();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        EntradaUsuario unaEntrada = new EntradaUsuario("Primer Jugador", Color.CYAN);
        EntradaUsuario otraEntrada = new EntradaUsuario("Segundo Jugador", Color.ORANGE);
        jugadores.add(unaEntrada);
        jugadores.add(otraEntrada);

        VBox vBox = new VBox(unaEntrada.getHb(), otraEntrada.getHb());
        vBox.setSpacing(30);

        Image imagen = new Image("file:src/vista/imagenes/imagen_inicio.png", 1500, 150, true, true);
        ImageView imagenVista = new ImageView(imagen);

        Image fondo = new Image("file:src/vista/imagenes/fondo_inicio.jpg", 525, 525, false, true);
        BackgroundImage imagenFondo = new BackgroundImage(fondo, BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenFondo));

        this.getChildren().addAll(imagenVista, vBox);
    }

    public void setBotonesIniciales(Stage stage) {

        BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(stage, jugadores);
        BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler();

        Boton botonJugar = new Boton("", botonJugarEventHandler);
        botonJugar.setBackground(Background.EMPTY);
        Image jugar = new Image("file:src/vista/imagenes/boton_jugar.png");
        botonJugar.setGraphic(new ImageView(jugar));

        Boton botonSalir = new Boton("", botonSalirEventHandler);
        botonSalir.setBackground(Background.EMPTY);
        Image salir = new Image("file:src/vista/imagenes/boton_salir.png");
        botonSalir.setGraphic(new ImageView(salir));

        this.getChildren().addAll(botonJugar, botonSalir);
    }

}
