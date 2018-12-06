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
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;
import vista.ContenedorPrincipal;

public class BotonCasilleroEventHandler implements EventHandler<ActionEvent> {

    private final ContenedorPrincipal contenedor;
    private final int fila;
    private final int columna;
    private final Juego juego;

    public BotonCasilleroEventHandler(Juego juego, int fila, int columna, ContenedorPrincipal contenedor) {
        this.fila = fila;
        this.columna = columna;
        this.juego = juego;
        this.contenedor = contenedor;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Colocable colocable = this.juego.getColocable(this.fila, this.columna);
        if (colocable instanceof Aldeano) {
            this.contenedor.dibujarMetodosAldeano((Aldeano) colocable);
        } else if (colocable instanceof Cuartel) {
            this.contenedor.dibujarMetodosCuartel((Cuartel) colocable);

        } else if (colocable instanceof ArmaDeAsedio) {
            this.contenedor.dibujarMetodosArmaDeAsedio((ArmaDeAsedio) colocable);

        } else if (colocable instanceof PlazaCentral) {
            this.contenedor.dibujarMetodosPlazaCentral((PlazaCentral) colocable);

        } else if (colocable instanceof Espadachin) {
            this.contenedor.dibujarMetodoEspadachinOArquero((Espadachin) colocable);
        }
        else if (colocable instanceof Arquero) {
            this.contenedor.dibujarMetodoEspadachinOArquero((Arquero) colocable);
        }
        else if (colocable instanceof Castillo) {
            this.contenedor.dibujarMetodosCastillo((Castillo) colocable);
        }
    }
}


