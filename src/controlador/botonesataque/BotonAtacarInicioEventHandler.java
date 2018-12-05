package controlador.botonesataque;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setContentText("Haz click en el sobre quien quieres realizar el ataque");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
        this.contenedorPrincipal.cambiarHandlerAtaque(this.atacante);

    }
}
