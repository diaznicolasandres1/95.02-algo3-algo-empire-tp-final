package controlador.botonesataque;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.unidades.Atacante;
import vista.ContenedorPrincipal;

public class IniciarAtaqueEventHandler implements EventHandler<ActionEvent> {

    private static final String RUTA_SONIDO_ATACAR = "src/vista/sonidos/anuncio_atacar.wav";
    private final Atacante atacante;
    private final ContenedorPrincipal contenedorPrincipal;

    public IniciarAtaqueEventHandler(Atacante atacante, ContenedorPrincipal contenedorPrincipal) {
        this.atacante = atacante;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.contenedorPrincipal.setMensaje("Haz click sobre\n quien quieres\n realizar el ataque");
        this.contenedorPrincipal.cambiarHandlerAtaque(this.atacante);
        Media sound = new Media(new File(RUTA_SONIDO_ATACAR).toURI().toString());
        (new MediaPlayer(sound)).play();
    }
}
