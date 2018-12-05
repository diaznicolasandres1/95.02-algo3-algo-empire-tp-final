package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.unidades.Unidad;
import vista.ContenedorPrincipal;

public class BotonMoverUnidadHaciaInicioEventHandler implements EventHandler<ActionEvent> {

    private Unidad unidad;
    private ContenedorPrincipal contenedorPrincipal;

    public BotonMoverUnidadHaciaInicioEventHandler(Unidad unidad, ContenedorPrincipal contenedorPrincipal) {
        this.unidad = unidad;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setContentText("Haz click en el lugar donde deseas mover la unidad");
        alert.show();
        this.contenedorPrincipal.cambiarHandlerMoverUnidad(this.unidad);
    }
}
