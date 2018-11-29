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

        Label titulo = new Label("AlgoEmpire");
        titulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        titulo.setTextAlignment(TextAlignment.CENTER);
        titulo.setTextFill(Color.web("000000"));

        Image imagen = new Image("file:src/vista/imagenes/imagen_inicio_aoe.png", 1500, 150, true, true);
        ImageView imagenVista = new ImageView(imagen);

        this.getChildren().addAll(titulo, imagenVista, vBox);
    }

    public void setBotonJugar(Stage stage) {
        BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(stage, jugadores);
        BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler();
        Boton botonJugar = new Boton("Jugar", botonJugarEventHandler);
        Boton botonSalir = new Boton("Salir", botonSalirEventHandler);
        this.getChildren().addAll(botonJugar, botonSalir);
    }


}
