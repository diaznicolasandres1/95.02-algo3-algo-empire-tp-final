package controlador.botonesaldeano;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
import modelo.unidades.aldeano.Aldeano;
import vista.ContenedorPrincipal;

public class BotonRepararEdificioInicioEventHandler implements EventHandler<ActionEvent> {

    private Aldeano aldeano;
    private ContenedorPrincipal contenedorPrincipal;

    public BotonRepararEdificioInicioEventHandler(Aldeano aldeano, ContenedorPrincipal contenedorPrincipal) {
        this.aldeano = aldeano;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setContentText("Haz click en el edificio que quieres reparar");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
        this.contenedorPrincipal.cambiarHandlerRepararEdificio(this.aldeano);
    }
}
