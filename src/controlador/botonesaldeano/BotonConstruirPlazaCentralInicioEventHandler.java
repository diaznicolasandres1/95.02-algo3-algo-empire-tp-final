package controlador.botonesaldeano;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
import modelo.unidades.aldeano.Aldeano;
import vista.ContenedorPrincipal;

public class BotonConstruirPlazaCentralInicioEventHandler implements EventHandler<ActionEvent> {

    private Aldeano aldeano;
    private ContenedorPrincipal contenedorPrincipal;

    public BotonConstruirPlazaCentralInicioEventHandler(Aldeano aldeano, ContenedorPrincipal contenedorPrincipal) {
        this.aldeano = aldeano;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setContentText("Haz click en donde quieres colocar la plaza central");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
        this.contenedorPrincipal.cambiarHandlerConstuirPlazaCentral(this.aldeano);
    }
}
