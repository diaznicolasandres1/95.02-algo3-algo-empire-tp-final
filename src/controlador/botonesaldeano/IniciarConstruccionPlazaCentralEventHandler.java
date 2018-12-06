package controlador.botonesaldeano;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.unidades.aldeano.Aldeano;
import vista.ContenedorPrincipal;

public class IniciarConstruccionPlazaCentralEventHandler implements EventHandler<ActionEvent> {

    private final Aldeano aldeano;
    private final ContenedorPrincipal contenedorPrincipal;

    public IniciarConstruccionPlazaCentralEventHandler(Aldeano aldeano, ContenedorPrincipal contenedorPrincipal) {
        this.aldeano = aldeano;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.contenedorPrincipal.setMensaje("Haz click en donde\n quieres colocar la\n plaza central");
        this.contenedorPrincipal.cambiarHandlerConstuirPlazaCentral(this.aldeano);
    }
}
