package controlador.botonesaldeano;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import modelo.edificios.Edificio;
import modelo.juego.Juego;
import modelo.unidades.Colocable;
import modelo.unidades.aldeano.Aldeano;
import vista.ContenedorPrincipal;

public class BotonRepararEdificioFinEventHandler implements EventHandler<ActionEvent> {
    private ContenedorPrincipal contenedor;
    private Aldeano reparador;
    private Juego juego;
    private int fila;
    private int columna;

    public BotonRepararEdificioFinEventHandler(Juego juego, Aldeano reparador, int fila, int columna, ContenedorPrincipal contenedor){
        this.reparador = reparador;
        this.contenedor = contenedor;
        this.juego = juego;
        this.fila  = fila;
        this.columna = columna;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Colocable edificio = juego.getColocable(fila,columna);
        juego.repararEdificio(reparador,(Edificio)edificio);
        contenedor.dibujarMapaConCasilleroHandler();
    }
}
