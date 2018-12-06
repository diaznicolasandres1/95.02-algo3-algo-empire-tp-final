package vista;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("AlgoEmpire");
        primaryStage.getIcons().add(new Image("file:src/vista/imagenes/icono_barra_titulo.jpg"));

        ContenedorEntrada contenedorEntrada = new ContenedorEntrada();
        Scene escenaInicial = new Scene(contenedorEntrada);
        contenedorEntrada.setBotonesIniciales(primaryStage);

        primaryStage.setScene(escenaInicial);
        primaryStage.setResizable(false);
        primaryStage.show();
        Media sound = new Media(new File("src/vista/sonidos/menu.wav").toURI().toString());
        (new MediaPlayer(sound)).play();
    }
}
