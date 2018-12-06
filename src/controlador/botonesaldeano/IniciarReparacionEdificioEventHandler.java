package controlador.botonesaldeano;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.unidades.aldeano.Aldeano;
import vista.ContenedorPrincipal;

public class IniciarReparacionEdificioEventHandler implements EventHandler<ActionEvent> {

    private final Aldeano aldeano;
    private final ContenedorPrincipal contenedorPrincipal;

    public IniciarReparacionEdificioEventHandler(Aldeano aldeano, ContenedorPrincipal contenedorPrincipal) {
        this.aldeano = aldeano;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.contenedorPrincipal.setMensaje("Haz click en el\n edificio que quieres\n reparar");
        this.contenedorPrincipal.cambiarHandlerRepararEdificio(this.aldeano);
    }
}
