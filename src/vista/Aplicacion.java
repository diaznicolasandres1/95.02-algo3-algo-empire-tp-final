package vista;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Aplicacion extends Application {

    private static final String RUTA_ICONO_BARRA_MENU = "file:src/vista/imagenes/icono_barra_titulo.jpg";
    private static final String RUTA_SONIDO_MENU = "src/vista/sonidos/menu.wav";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("AlgoEmpire");
        primaryStage.getIcons().add(new Image(RUTA_ICONO_BARRA_MENU));

        ContenedorEntrada contenedorEntrada = new ContenedorEntrada();
        Scene escenaInicial = new Scene(contenedorEntrada);
        contenedorEntrada.setBotonesIniciales(primaryStage);

        primaryStage.setScene(escenaInicial);
        primaryStage.setResizable(false);
        primaryStage.show();
        Media sound = new Media(new File(RUTA_SONIDO_MENU).toURI().toString());
        (new MediaPlayer(sound)).play();
    }
}
