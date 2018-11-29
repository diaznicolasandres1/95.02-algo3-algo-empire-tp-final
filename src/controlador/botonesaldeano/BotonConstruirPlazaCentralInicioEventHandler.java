package controlador.botonesaldeano;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.excepciones.AldeanoEstaOcupadoException;
import modelo.excepciones.OroInsuficienteException;
import modelo.excepciones.UnidadSeleccionadaNoPerteneceAJugadorException;
import modelo.juego.Juego;
import modelo.unidades.aldeano.Aldeano;

public class BotonConstruirPlazaCentralInicioEventHandler implements EventHandler<ActionEvent> {
    private Juego juego;
    private Aldeano aldeano;
    private int fila;
    private int columna;

    public BotonConstruirPlazaCentralInicioEventHandler(Juego juego, Aldeano aldeano, int fila, int columna) {
        this.aldeano = aldeano;
        this.fila = fila;
        this.columna = columna;
        this.juego = juego;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setContentText("Haz click en donde quieres colocar la plaza central");
        alert.show();
        //Poner todos los casilleros en handle finalizar creacion plaza central
    }
}
