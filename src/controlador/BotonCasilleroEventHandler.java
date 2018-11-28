package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.juego.Juego;
import modelo.unidades.Colocable;

public class BotonCasilleroEventHandler implements EventHandler<ActionEvent> {

    private int fila;
    private int columna;
    private Juego juego;

    public BotonCasilleroEventHandler(Juego juego, int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Colocable colocable = this.juego.getColocable(this.fila, this.columna);
        // Como el handler no puede devolver nada, habria que mandar este colocable
        // para otro lado para que maneje lo que se tenga que hacer
    }

}
