package controlador.botonesaldeano;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.excepciones.*;
import modelo.juego.Juego;
import modelo.unidades.aldeano.Aldeano;
import vista.ContenedorPrincipal;

public class FinalizarConstruccionCuartelEventHandler implements EventHandler<ActionEvent> {

    private static final String RUTA_SONIDO_CONSTRUIR_FIN = "src/vista/sonidos/construir_fin.wav";
    private final ContenedorPrincipal contenedor;
    private final Aldeano constructor;
    private final Juego juego;
    private final int fila;
    private final int columna;

    public FinalizarConstruccionCuartelEventHandler(Juego juego, Aldeano constructor, int fila, int columna, ContenedorPrincipal contenedor) {
        this.constructor = constructor;
        this.contenedor = contenedor;
        this.juego = juego;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error al construir Cuartel");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try {
            this.juego.construirCuartel(this.constructor, this.fila, this.columna);
        } catch (ColocableSeleccionadoException | UnidadYaFueUtilizadaEnEsteTurnoException e) {
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (ConstruccionFueraDeRangoException e) {
            alert.setContentText("La posicion donde se pretende construir el edificio no esta proxima al aldeano");
            alert.show();
        } catch (OroInsuficienteException e) {
            alert.setContentText("No se posee oro suficiente para construir cuartel");
            alert.show();
        } catch (NoHayLugarSuficenteParaColocarEdificioException e) {
            alert.setContentText("El o los casilleros necesarios para construir el cuartel se encuentran ocupados");
            alert.show();
        }
        this.contenedor.actualizarOro();
        this.contenedor.clearMensajes();
        this.contenedor.dibujarMapaConCasilleroHandler();
        Media sound = new Media(new File(RUTA_SONIDO_CONSTRUIR_FIN).toURI().toString());
        (new MediaPlayer(sound)).play();
    }
}
