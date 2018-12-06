package controlador;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.unidades.Unidad;
import vista.ContenedorPrincipal;

public class IniciarMoverUnidadEventHandler implements EventHandler<ActionEvent> {

    private static final String RUTA_SONIDO_MOVER = "src/vista/sonidos/mover.wav";
    private final Unidad unidad;
    private final ContenedorPrincipal contenedorPrincipal;

    public IniciarMoverUnidadEventHandler(Unidad unidad, ContenedorPrincipal contenedorPrincipal) {
        this.unidad = unidad;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.contenedorPrincipal.setMensaje("Haz click en el lugar\n donde deseas mover\n la unidad");
        this.contenedorPrincipal.cambiarHandlerMoverUnidad(this.unidad);
        Media sound = new Media(new File(RUTA_SONIDO_MOVER).toURI().toString());
        (new MediaPlayer(sound)).play();
    }
}
