package controlador.botonesaldeano;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.unidades.aldeano.Aldeano;
import vista.ContenedorPrincipal;

public class IniciarReparacionEdificioEventHandler implements EventHandler<ActionEvent> {

    private static final String RUTA_SONIDO_REPARAR = "src/vista/sonidos/reparar.wav";
    private final Aldeano aldeano;
    private final ContenedorPrincipal contenedorPrincipal;

    public IniciarReparacionEdificioEventHandler(Aldeano aldeano, ContenedorPrincipal contenedorPrincipal) {
        this.aldeano = aldeano;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.contenedorPrincipal.setMensaje("Haz click en el\n edificio que quieres\n reparar");
        this.contenedorPrincipal.cambiarHandlerRepararEdificio(this.aldeano);
        Media sound = new Media(new File(RUTA_SONIDO_REPARAR).toURI().toString());
        (new MediaPlayer(sound)).play();
    }
}
