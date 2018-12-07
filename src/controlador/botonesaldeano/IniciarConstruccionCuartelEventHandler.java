package controlador.botonesaldeano;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.unidades.aldeano.Aldeano;
import vista.ContenedorPrincipal;

public class IniciarConstruccionCuartelEventHandler implements EventHandler<ActionEvent> {

    private static final String RUTA_SONIDO_CONSTRUIR = "src/vista/sonidos/construir.wav";
    public final Aldeano aldeano;
    public final ContenedorPrincipal contenedorPrincipal;

    public IniciarConstruccionCuartelEventHandler(Aldeano aldeano, ContenedorPrincipal contenedorPrincipal) {
        this.aldeano = aldeano;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        this.contenedorPrincipal.setMensaje("Haz click en donde\n quieres colocar el\n cuartel");
        this.contenedorPrincipal.cambiarHandlerConstruirCuartel(this.aldeano);
        Media sound = new Media(new File(RUTA_SONIDO_CONSTRUIR).toURI().toString());
        (new MediaPlayer(sound)).play();
    }
}
