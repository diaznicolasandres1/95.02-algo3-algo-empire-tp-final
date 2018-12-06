package controlador.botonesataque;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.excepciones.*;
import modelo.juego.Juego;
import modelo.unidades.Atacable;
import modelo.unidades.Atacante;
import modelo.unidades.Colocable;
import vista.ContenedorPrincipal;

import java.io.File;
import java.util.Optional;

public class FinalizarAtaqueEventHandler implements EventHandler<ActionEvent> {

    private static final String RUTA_SONIDO_ATACAR = "src/vista/sondiso/espadachin_atacar.wav";
    private static final String RUTA_SONIDO_VICTORIA = "src/vista/sonidos/victoria.wav";
    private final ContenedorPrincipal contenedor;
    private final Atacante atacante;
    private final Juego juego;
    private final int fila;
    private final int columna;

    public FinalizarAtaqueEventHandler(Juego juego, Atacante atacante, int fila, int columna, ContenedorPrincipal contenedorPrincipal) {
        this.juego = juego;
        this.atacante = atacante;
        this.contenedor = contenedorPrincipal;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Colocable atacado = this.juego.getColocable(this.fila, this.columna);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error al atacar");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try {
            this.juego.atacar(this.atacante, (Atacable) atacado);
        } catch (CastilloFueDestruidoException e) {
            alert.setContentText("El castillo fue destruido. Se finaliza el juego");
            Media sound = new Media(new File(RUTA_SONIDO_VICTORIA).toURI().toString());
            (new MediaPlayer(sound)).play();
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
               Platform.exit();
            }
        } catch (ColocableSeleccionadoException | EdificioException | UnidadYaFueUtilizadaEnEsteTurnoException | ArmaDeAsedioException e) {
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (ColocableFueraDeRangoDeAtaqueException e) {
            alert.setContentText("Objetivo fuera de rango de ataque");
            alert.show();
        } catch (NullPointerException e) {
            alert.setContentText("No existe objetivo en el casillero seleccionado");
            alert.show();
        }
        this.contenedor.clearMensajes();
        this.contenedor.dibujarMapaConCasilleroHandler();
        Media sound = new Media(new File(RUTA_SONIDO_ATACAR).toURI().toString());
        (new MediaPlayer(sound)).play();
    }
}
