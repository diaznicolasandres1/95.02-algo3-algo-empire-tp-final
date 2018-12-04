package controlador.botonesdeedificios;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
import modelo.edificios.castillo.Castillo;
import modelo.excepciones.CuartelCreandoseException;
import modelo.excepciones.EdificioSeleccionadoNoPerteneceAJugadorException;
import modelo.excepciones.LimiteDePoblacionAlcanzadoException;
import modelo.excepciones.OroInsuficienteException;
import modelo.juego.Juego;
import vista.ContenedorPrincipal;

public class BotonCrearArmaDeAsedioEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private Castillo castillo;
    private ContenedorPrincipal contenedorPrincipal;

    public BotonCrearArmaDeAsedioEventHandler(Juego juego, Castillo castillo, ContenedorPrincipal contenedorPrincipal){
        this.juego = juego;
        this.castillo = castillo;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error al crear arma de asedio");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try {
            this.juego.crearArmaDeAsedio(this.castillo);
        } catch (EdificioSeleccionadoNoPerteneceAJugadorException e) {
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (OroInsuficienteException e) {
            alert.setContentText("No tienes oro suficiente para crear un arma de asedio");
            alert.show();
        } catch (CuartelCreandoseException e) {
            alert.setContentText("El cuartel se encuentra en construccion");
            alert.show();
        } catch (LimiteDePoblacionAlcanzadoException e) {
            alert.setContentText("Limite de poblacion alcanzado");
            alert.show();
        }
        this.contenedorPrincipal.actualizarOro();
        this.contenedorPrincipal.dibujarMapaConCasilleroHandler();
    }
}
