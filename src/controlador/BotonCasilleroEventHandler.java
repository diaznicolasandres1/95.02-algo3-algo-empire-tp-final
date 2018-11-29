package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import modelo.edificios.castillo.Castillo;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.juego.Juego;
import modelo.unidades.Colocable;
import modelo.unidades.aldeano.Aldeano;
import vista.ContenedorPrincipal;

public class BotonCasilleroEventHandler implements EventHandler<ActionEvent> {

    private  ContenedorPrincipal contenedor;
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
        // Como el handler no puede devolver nada, habria que mandar este colocable
        // para otro lado para que maneje lo que se tenga que hacer
        //Mostra vista de acciones disponibles
        if(colocable instanceof Aldeano){

            contenedor.dibujarMetodosAldeano(juego, (Aldeano) colocable,this.fila,this.columna);


        }
        else if(colocable instanceof Castillo) {
            //Actualizar vista con metodos castillo

        }
        else if(colocable instanceof PlazaCentral) {
            //Actualizar vista con metodos plaza central

        }

    }

}
