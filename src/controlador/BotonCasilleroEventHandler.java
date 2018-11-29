package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import modelo.edificios.castillo.Castillo;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.juego.Juego;
import modelo.unidades.Colocable;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.armadeasedio.ArmaDeAsedio;
import modelo.unidades.espadachin.Espadachin;
import vista.ContenedorPrincipal;

public class BotonCasilleroEventHandler implements EventHandler<ActionEvent> {

    private ContenedorPrincipal contenedor;
    private int fila;
    private int columna;
    private Juego juego;

    public BotonCasilleroEventHandler(Juego juego, int fila, int columna, ContenedorPrincipal contenedor) {
        this.fila = fila;
        this.columna = columna;
        this.juego = juego;
        this.contenedor = contenedor;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Colocable colocable = this.juego.getColocable(this.fila, this.columna);
        /*Refactorizar en un switch */
        if (colocable instanceof Aldeano) {
            contenedor.dibujarMetodosAldeano((Aldeano) colocable);
        } else if (colocable instanceof Cuartel) {
            contenedor.dibujarMetodosCuartel((Cuartel) colocable);

        } else if (colocable instanceof ArmaDeAsedio) {
            contenedor.dibujarMetodosArmaDeAsedio((ArmaDeAsedio) colocable);

        } else if (colocable instanceof PlazaCentral) {
            contenedor.dibujarMetodosPlazaCentral((PlazaCentral) colocable);

        } else if (colocable instanceof Espadachin) {
            contenedor.dibujarMetodoEspadachin((Espadachin) colocable);
        }
    }
}


