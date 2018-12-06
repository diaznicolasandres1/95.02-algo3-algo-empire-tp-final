package controlador.botonesaldeano;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.edificios.Edificio;
import modelo.excepciones.*;
import modelo.juego.Juego;
import modelo.unidades.Colocable;
import modelo.unidades.aldeano.Aldeano;
import vista.ContenedorPrincipal;

public class FinalizarReparacionEdificioEventHandler implements EventHandler<ActionEvent> {

    private static final String RUTA_SONIDO_REPARAR_FIN = "src/vista/sonidos/construir_fin.wav";
    private final ContenedorPrincipal contenedor;
    private final Aldeano reparador;
    private final Juego juego;
    private final int fila;
    private final int columna;

    public FinalizarReparacionEdificioEventHandler(Juego juego, Aldeano reparador, int fila, int columna, ContenedorPrincipal contenedor) {
        this.reparador = reparador;
        this.contenedor = contenedor;
        this.juego = juego;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Colocable edificio = this.juego.getColocable(this.fila, this.columna);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error al reparar edificio");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try {
            this.juego.repararEdificio(this.reparador, (Edificio) edificio);
        } catch (ColocableSeleccionadoException | EdificioException | UnidadYaFueUtilizadaEnEsteTurnoException e) {
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (ConstruccionFueraDeRangoException e) {
            alert.setContentText("El edificio no se encuentra proximo al aldeano");
            alert.show();
        }
        this.contenedor.clearMensajes();
        this.contenedor.dibujarMapaConCasilleroHandler();
        Media sound = new Media(new File(RUTA_SONIDO_REPARAR_FIN).toURI().toString());
        (new MediaPlayer(sound)).play();
    }
}
