package controlador.botonesaldeano;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        this.contenedorPrincipal.setMensaje("Haz click en el\nedificio que quieres\nreparar");
        this.contenedorPrincipal.cambiarHandlerRepararEdificio(this.aldeano);
    }
}
