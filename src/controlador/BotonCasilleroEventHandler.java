package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import modelo.edificios.castillo.Castillo;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.juego.Juego;
import modelo.unidades.Colocable;
import modelo.unidades.aldeano.Aldeano;
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
        // Muestra vista de acciones disponibles
        if(colocable instanceof Aldeano){
            contenedor.dibujarMetodosAldeano(juego, (Aldeano) colocable);


        } else if (colocable instanceof Cuartel) {
            contenedor.dibujarMetodosCuartel(juego, (Cuartel) colocable);

        } else if (colocable instanceof Castillo) {
            //Actualizar vista con metodos castillo

        } else if (colocable instanceof PlazaCentral) {
            //Actualizar vista con metodos plaza central

        }

    }

}
