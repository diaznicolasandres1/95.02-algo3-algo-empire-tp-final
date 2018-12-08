package controlador;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.juego.Juego;
import vista.ContenedorPrincipal;

public class FinalizarTurnoEventHandler implements EventHandler<ActionEvent> {

    private static final String RUTA_SONIDO_FINAL_TURNO = "src/vista/sonidos/final_turno.wav";
    private final Juego juego;
    private final ContenedorPrincipal contenedorPrincipal;

    public FinalizarTurnoEventHandler(Juego juego, ContenedorPrincipal contenedorPrincipal) {
        this.juego = juego;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.contenedorPrincipal.clearMensajes();
        this.juego.finalizarTurno();
        this.contenedorPrincipal.crearBottom();
        this.contenedorPrincipal.actualizarOro();
        this.contenedorPrincipal.actualizarPoblacion();
        this.contenedorPrincipal.moverFinalizarTurno();
        this.contenedorPrincipal.dibujarMapaConCasilleroHandler();
        Media sound = new Media(new File(RUTA_SONIDO_FINAL_TURNO).toURI().toString());
        (new MediaPlayer(sound)).play();
    }
}
