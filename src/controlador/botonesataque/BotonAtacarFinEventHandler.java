package controlador.botonesataque;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.juego.Juego;
import modelo.unidades.Atacante;
import modelo.unidades.Colocable;
import modelo.unidades.aldeano.Aldeano;
import vista.ContenedorPrincipal;

public class BotonAtacarFinEventHandler implements EventHandler<ActionEvent> {
    private ContenedorPrincipal contenedor;
    private Atacante atacante;
    private Juego juego;
    private int fila;
    private int columna;

    public  BotonAtacarFinEventHandler(Juego juego, Atacante atacante, int fila, int columna, ContenedorPrincipal contenedorPrincipal){
        this.juego = juego;
        this.atacante = atacante;
        this.contenedor = contenedorPrincipal;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Colocable atacado = juego.getColocable(fila,columna);
        juego.atacar(atacante,atacado);
        contenedor.dibujarMapaConCasilleroHandler();
    }
}
