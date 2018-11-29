package controlador.botonesaldeano;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.excepciones.AldeanoEstaOcupadoException;
import modelo.excepciones.OroInsuficienteException;
import modelo.excepciones.UnidadSeleccionadaNoPerteneceAJugadorException;
import modelo.juego.Juego;
import modelo.unidades.aldeano.Aldeano;
import vista.ContenedorPrincipal;

public class BotonConstruirPlazaCentralInicioEventHandler implements EventHandler<ActionEvent> {
    private Juego juego;
    private Aldeano aldeano;
    private ContenedorPrincipal contenedorPrincipal;

    public BotonConstruirPlazaCentralInicioEventHandler(Juego juego, Aldeano aldeano, ContenedorPrincipal contenedorPrincipal) {
        this.aldeano = aldeano;
        this.juego = juego;
        this.contenedorPrincipal = contenedorPrincipal;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setContentText("Haz click en donde quieres colocar la plaza central");
        alert.show();
        contenedorPrincipal.cambiarHandlerConstuirPlazaCentral(aldeano);




    }
}
