package controlador.botonesataque;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.unidades.Atacante;
import vista.ContenedorPrincipal;

public class BotonAtacarInicioEventHandler implements EventHandler<ActionEvent> {

    private Atacante atacante;
    private ContenedorPrincipal contenedorPrincipal;

    public BotonAtacarInicioEventHandler(Atacante atacante, ContenedorPrincipal contenedorPrincipal) {
        this.atacante = atacante;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.contenedorPrincipal.setMensaje("Haz click sobre\n quien quieres\n realizar el ataque");
        this.contenedorPrincipal.cambiarHandlerAtaque(this.atacante);

    }
}
