package controlador.botonesdeedificios;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.edificios.cuartel.Cuartel;
import modelo.excepciones.CuartelCreandoseException;
import modelo.excepciones.EdificioSeleccionadoNoPerteneceAJugadorException;
import modelo.excepciones.LimiteDePoblacionAlcanzadoException;
import modelo.excepciones.OroInsuficienteException;
import modelo.juego.Juego;
import vista.ContenedorPrincipal;

public class CrearArqueroEventHandler implements EventHandler<ActionEvent> {

    private static final String RUTA_SONIDO_ARQUERO = "src/vista/sonidos/crear_atacante.wav";
    private static final String RUTA_SONIDO_LIMITE_POBLACION = "src/vista/sonidos/limite_poblacion.wav";
    private static final String RUTA_SONIDO_ORO_INSUFICIENTE = "src/vista/sonidos/oro_insuficiente.wav";
    private final Juego juego;
    private final Cuartel cuartel;
    private final ContenedorPrincipal contenedorPrincipal;

    public CrearArqueroEventHandler(Juego juego, Cuartel cuartel, ContenedorPrincipal contenedorPrincipal) {
        this.juego = juego;
        this.cuartel = cuartel;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error al crear arquero");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try {
            this.juego.crearArquero(this.cuartel);
        } catch (EdificioSeleccionadoNoPerteneceAJugadorException e) {
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (OroInsuficienteException e) {
            alert.setContentText("No tienes oro suficiente para crear un arquero");
            alert.show();
            Media sound = new Media(new File(RUTA_SONIDO_ORO_INSUFICIENTE).toURI().toString());
            (new MediaPlayer(sound)).play();
        } catch (CuartelCreandoseException e) {
            alert.setContentText("El cuartel se encuentra en construccion");
            alert.show();
        } catch (LimiteDePoblacionAlcanzadoException e) {
            alert.setContentText("Limite de poblacion alcanzado");
            alert.show();
            Media sound = new Media(new File(RUTA_SONIDO_LIMITE_POBLACION).toURI().toString());
            (new MediaPlayer(sound)).play();
        }
        this.contenedorPrincipal.actualizarOro();
        this.contenedorPrincipal.actualizarPoblacion();
        this.contenedorPrincipal.dibujarMapaConCasilleroHandler();
        Media sound = new Media(new File(RUTA_SONIDO_ARQUERO).toURI().toString());
        (new MediaPlayer(sound)).play();
    }
}

