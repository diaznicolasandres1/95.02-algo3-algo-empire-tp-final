package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.excepciones.CasilleroOcupadoException;
import modelo.excepciones.CoordenadasInvalidasException;
import modelo.excepciones.EdificioSeleccionadoNoPerteneceAJugadorException;
import modelo.excepciones.OroInsuficienteException;
import modelo.juego.Juego;
import modelo.unidades.Unidad;

public class BotonMoverUnidadHaciaEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private Unidad unidad;
    private int fila;
    private int columna;

    public BotonMoverUnidadHaciaEventHandler(Juego juego, Unidad unidad, int fila, int columna){
        this.juego = juego;
        this.unidad = unidad;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        try{
            juego.moverUnidadHacia(unidad,fila,columna);
        }catch(CasilleroOcupadoException e) {
            alert.setTitle("Error al mover unidad");
            alert.setContentText("Ese casillero ya esta ocupado");
            alert.show();
        }


    }
}
