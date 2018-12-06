package controlador;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.excepciones.*;
import modelo.juego.Juego;
import modelo.unidades.Unidad;
import vista.ContenedorPrincipal;

public class FinalizarMoverUnidadEventHandler implements EventHandler<ActionEvent> {

    private static final String RUTA_SONIDO_MOVER = "src/vista/sonidos/mover_fin.wav";
    private final Unidad unidad;
    private final Juego juego;
    private final int fila;
    private final int columna;
    private final ContenedorPrincipal contenedorPrincipal;

    public FinalizarMoverUnidadEventHandler(Juego juego, Unidad unidad, int fila, int columna, ContenedorPrincipal contenedorPrincipal) {
        this.unidad = unidad;
        this.juego = juego;
        this.fila = fila;
        this.columna = columna;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error al mover la unidad");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try {
            this.juego.moverUnidadHacia(this.unidad, this.fila, this.columna);
        } catch (CasilleroOcupadoException e) {
            alert.setContentText("El casillero de destino se encuentra ocupado");
            alert.show();
        } catch (ColocableSeleccionadoException | UnidadYaFueUtilizadaEnEsteTurnoException | ArmaDeAsedioException e) {
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (PosicionFueraDeRangoException e) {
            alert.setContentText("La posicion de destino se encuentra fuera de rango de movimiento");
            alert.show();
        }
        this.contenedorPrincipal.clearMensajes();
        this.contenedorPrincipal.dibujarMapaConCasilleroHandler();
        Media sound = new Media(new File(RUTA_SONIDO_MOVER).toURI().toString());
        (new MediaPlayer(sound)).play();
    }
}
