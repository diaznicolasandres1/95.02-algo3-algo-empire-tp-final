package controlador.botonesdeedificios;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.excepciones.EdificioSeleccionadoNoPerteneceAJugadorException;
import modelo.excepciones.LimiteDePoblacionAlcanzadoException;
import modelo.excepciones.OroInsuficienteException;
import modelo.excepciones.PlazaCentralEnConstruccionException;
import modelo.juego.Juego;
import vista.ContenedorPrincipal;

public class CrearAldeanoEventHandler implements EventHandler<ActionEvent> {

    private static final String RUTA_SONIDO_CREAR_ALDEANO = "src/vista/sonidos/crear_aldeano.wav";
    private static final String RUTA_SONIDO_LIMITE_POBLACION = "src/vista/sonidos/limite_poblacion.wav";
    private static final String RUTA_SONIDO_ORO_INSUFICIENTE = "src/vista/sonidos/oro_insuficiente.wav";
    private final Juego juego;
    private final PlazaCentral plaza;
    private final ContenedorPrincipal contenedorPrincipal;

    public CrearAldeanoEventHandler(Juego juego, PlazaCentral plaza, ContenedorPrincipal contenedorPrincipal) {
        this.juego = juego;
        this.plaza = plaza;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error al crear aldeano");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try {
            this.juego.crearAldeano(this.plaza);
        } catch (EdificioSeleccionadoNoPerteneceAJugadorException e) {
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (OroInsuficienteException e) {
            alert.setContentText("No tienes oro suficiente para crear un aldeano");
            alert.show();
            Media sound = new Media(new File(RUTA_SONIDO_ORO_INSUFICIENTE).toURI().toString());
            (new MediaPlayer(sound)).play();
        } catch (PlazaCentralEnConstruccionException e) {
            alert.setContentText("La plaza central se encuentra en construccion");
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
        Media sound = new Media(new File(RUTA_SONIDO_CREAR_ALDEANO).toURI().toString());
        (new MediaPlayer(sound)).play();
    }
}
