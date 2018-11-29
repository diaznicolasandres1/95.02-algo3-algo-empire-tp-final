package controlador.botonesaldeano;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.juego.Juego;
import modelo.unidades.aldeano.Aldeano;
import vista.ContenedorPrincipal;

public class BotonConstruirPlazaCentralFinEventHandler implements EventHandler<ActionEvent> {

    private ContenedorPrincipal contenedor;
    private Aldeano constructor;
    private Juego juego;
    private int fila;
    private int columna;

    public BotonConstruirPlazaCentralFinEventHandler(Juego juego, Aldeano constructor, int fila, int columna, ContenedorPrincipal contenedor){
        this.constructor = constructor;
        this.contenedor = contenedor;
        this.juego = juego;
        this.fila   =fila;
        this.columna = columna;

    }
    @Override
    public void handle(ActionEvent actionEvent) {
            juego.construirPlazaCentral(constructor,fila,columna);
            contenedor.dibujarMapaConCasilleroHandler();
    }
}
