package controlador.botonesaldeano;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.Alert;
import modelo.edificios.Edificio;
import modelo.excepciones.ColocableSeleccionadoException;
import modelo.excepciones.EdificioSeleccionadoNoPerteneceAJugadorException;
import modelo.excepciones.UnidadSeleccionadaNoPerteneceAJugadorException;
import modelo.excepciones.AldeanoEstaOcupadoException;
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error al seleccionar edificio/aldeano");
        try {
            juego.repararEdificio(reparador, (Edificio) edificio);
        } catch (ColocableSeleccionadoException e) {

            alert.setContentText(e.getMessage());
            alert.show();
        } catch (AldeanoEstaOcupadoException e) {
            alert.setContentText("El aldeano seleccionado se encuentra ocupado");
            alert.show();
        }
        contenedor.dibujarMapaConCasilleroHandler();
    }
}
