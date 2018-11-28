package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.juego.Juego;
import modelo.unidades.aldeano.Aldeano;

public class BotonConstruirPlazaCentral implements EventHandler<ActionEvent> {
    private Juego juego;
    private Aldeano aldeano;
    private int fila;
    private int columna;

    public BotonConstruirPlazaCentral(Juego juego, Aldeano aldeano, int fila, int columna) {
        this.aldeano = aldeano;
        this.fila = fila;
        this.columna = columna;
        this.juego = juego;
    }


    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
