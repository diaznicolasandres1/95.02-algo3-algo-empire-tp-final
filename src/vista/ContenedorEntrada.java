package vista;

import controlador.BotonJugarEventHandler;
import controlador.BotonSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ContenedorEntrada extends VBox {

    private final ArrayList<EntradaUsuario> jugadores;
    private static final String RUTA_TITULO = "file:src/vista/imagenes/titulo_inicio.png";
    private static final String RUTA_FONDO_INICIO = "file:src/vista/imagenes/fondo_inicio.jpg";
    private static final String RUTA_BOTON_JUGAR = "file:src/vista/imagenes/boton_jugar.png";
    private static final String RUTA_BOTON_SALIR = "file:src/vista/imagenes/boton_salir.png";

    public ContenedorEntrada() {

        super();
        this.jugadores = new ArrayList<>();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        EntradaUsuario unaEntrada = new EntradaUsuario("Primer Jugador");
        EntradaUsuario otraEntrada = new EntradaUsuario("Segundo Jugador");
        this.jugadores.add(unaEntrada);
        this.jugadores.add(otraEntrada);

        VBox vBox = new VBox(unaEntrada.getHb(), otraEntrada.getHb());
        vBox.setSpacing(30);

        Image imagen = new Image(RUTA_TITULO, 1500, 150, true, true);
        ImageView imagenVista = new ImageView(imagen);

        Image fondo = new Image(RUTA_FONDO_INICIO, 525, 525, false, true);
        BackgroundImage imagenFondo = new BackgroundImage(fondo, BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenFondo));

        this.getChildren().addAll(imagenVista, vBox);
    }

    public void setBotonesIniciales(Stage stage) {

        BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(stage, this.jugadores);
        BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler();

        Button botonJugar = new Button("");
        botonJugar.setOnAction(botonJugarEventHandler);
        botonJugar.setBackground(Background.EMPTY);
        Image jugar = new Image(RUTA_BOTON_JUGAR);
        botonJugar.setGraphic(new ImageView(jugar));

        Button botonSalir = new Button("");
        botonSalir.setOnAction(botonSalirEventHandler);
        botonSalir.setBackground(Background.EMPTY);
        Image salir = new Image(RUTA_BOTON_SALIR);
        botonSalir.setGraphic(new ImageView(salir));

        this.getChildren().addAll(botonJugar, botonSalir);
    }

}
