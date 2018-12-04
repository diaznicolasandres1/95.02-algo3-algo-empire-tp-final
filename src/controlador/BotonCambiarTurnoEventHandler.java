package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.juego.Juego;
import vista.ContenedorPrincipal;

public class BotonCambiarTurnoEventHandler implements EventHandler<ActionEvent> {
    private Juego juego;
    private ContenedorPrincipal contenedorPrincipal;

    public BotonCambiarTurnoEventHandler(Juego juego, ContenedorPrincipal contenedorPrincipal){
        this.juego = juego;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        int oroAnterior = juego.getOroJugadorActual();
        int poblacionAnterior = juego.getPoblacionJugadorActual();

        this.juego.cambiarTurno();

        int oroActual = juego.getOroJugadorActual();
        int poblacionActual = juego.getPoblacionJugadorActual();

        this.contenedorPrincipal.crearBottom();
        this.contenedorPrincipal.setCostados(oroAnterior,oroActual,poblacionAnterior,poblacionActual);

    }
}
