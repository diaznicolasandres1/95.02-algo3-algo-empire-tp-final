package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.unidades.Unidad;
import vista.ContenedorPrincipal;

public class IniciarMoverUnidadEventHandler implements EventHandler<ActionEvent> {

    private final Unidad unidad;
    private final ContenedorPrincipal contenedorPrincipal;

    public IniciarMoverUnidadEventHandler(Unidad unidad, ContenedorPrincipal contenedorPrincipal) {
        this.unidad = unidad;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.contenedorPrincipal.setMensaje("Haz click en el lugar\n donde deseas mover\n la unidad");
        this.contenedorPrincipal.cambiarHandlerMoverUnidad(this.unidad);
    }
}
