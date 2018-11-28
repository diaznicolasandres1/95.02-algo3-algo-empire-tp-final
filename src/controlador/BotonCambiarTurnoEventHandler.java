package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.juego.Juego;

public class BotonCambiarTurnoEventHandler implements EventHandler<ActionEvent> {
    private Juego juego;

    public BotonCambiarTurnoEventHandler(Juego juego){
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        juego.cambiarTurno();
    }
}
