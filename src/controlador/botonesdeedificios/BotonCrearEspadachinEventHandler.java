package controlador.botonesdeedificios;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
import modelo.edificios.cuartel.Cuartel;
import modelo.excepciones.CuartelCreandoseException;
import modelo.excepciones.EdificioSeleccionadoNoPerteneceAJugadorException;
import modelo.excepciones.LimiteDePoblacionAlcanzadoException;
import modelo.excepciones.OroInsuficienteException;
import modelo.juego.Juego;
import vista.ContenedorPrincipal;

public class BotonCrearEspadachinEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private Cuartel cuartel;
    private ContenedorPrincipal contenedorPrincipal;

    public BotonCrearEspadachinEventHandler(Juego juego, Cuartel cuartel, ContenedorPrincipal contenedorPrincipal) {
        this.juego = juego;
        this.cuartel = cuartel;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error al crear espadachin");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try {
            juego.crearEspadachin(this.cuartel);
        } catch (EdificioSeleccionadoNoPerteneceAJugadorException e) {
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (OroInsuficienteException e) {
            alert.setContentText("No tienes oro suficiente para crear un arquero");
            alert.show();
        } catch (CuartelCreandoseException e) {
            alert.setContentText("El cuartel se encuentra en construccion");
            alert.show();
        } catch (LimiteDePoblacionAlcanzadoException e) {
            alert.setContentText("Limite de poblacion alcanzado");
            alert.show();
        }
        this.contenedorPrincipal.dibujarMapaConCasilleroHandler();
    }
}
