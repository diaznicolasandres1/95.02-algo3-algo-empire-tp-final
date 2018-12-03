package controlador.botonesaldeano;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.juego.Juego;
import modelo.unidades.aldeano.Aldeano;
import vista.ContenedorPrincipal;

public class BotonRepararEdificioInicioEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private Aldeano aldeano;
    private ContenedorPrincipal contenedorPrincipal;

    public BotonRepararEdificioInicioEventHandler(Juego juego, Aldeano aldeano, ContenedorPrincipal contenedorPrincipal) {
        this.juego = juego;
        this.aldeano = aldeano;
        this.contenedorPrincipal = contenedorPrincipal;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setContentText("Haz click en el edificio que quieres reparar");
        alert.show();
        this.contenedorPrincipal.cambiarHandlerRepararEdificio(this.aldeano);


    }


}
