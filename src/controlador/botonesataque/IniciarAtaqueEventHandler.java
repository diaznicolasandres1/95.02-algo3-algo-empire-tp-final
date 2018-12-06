package controlador.botonesataque;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.unidades.Atacante;
import vista.ContenedorPrincipal;

public class IniciarAtaqueEventHandler implements EventHandler<ActionEvent> {

    private final Atacante atacante;
    private final ContenedorPrincipal contenedorPrincipal;

    public IniciarAtaqueEventHandler(Atacante atacante, ContenedorPrincipal contenedorPrincipal) {
        this.atacante = atacante;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.contenedorPrincipal.setMensaje("Haz click sobre\n quien quieres\n realizar el ataque");
        this.contenedorPrincipal.cambiarHandlerAtaque(this.atacante);

    }
}
