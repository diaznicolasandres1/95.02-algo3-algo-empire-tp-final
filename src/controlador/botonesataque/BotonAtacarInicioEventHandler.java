package controlador.botonesataque;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.juego.Juego;
import modelo.unidades.Atacante;
import vista.ContenedorPrincipal;

public class BotonAtacarInicioEventHandler implements EventHandler<ActionEvent> {
    private Atacante atacante;
    private Juego juego;
    private ContenedorPrincipal contenedorPrincipal;
    public BotonAtacarInicioEventHandler(Juego juego, Atacante atacante, ContenedorPrincipal contenedorPrincipal){
        this.atacante = atacante;
        this.juego = juego;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setContentText("Haz click en el sobre quien quieres realizar el ataque");
        alert.show();
        this.contenedorPrincipal.cambiarHandlerAtaque(this.atacante);

    }
}
