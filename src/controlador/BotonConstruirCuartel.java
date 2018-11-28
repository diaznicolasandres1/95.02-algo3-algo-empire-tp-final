package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.excepciones.AldeanoEstaOcupadoException;
import modelo.excepciones.OroInsuficienteException;
import modelo.juego.Juego;
import modelo.unidades.aldeano.Aldeano;

public class BotonConstruirCuartel implements EventHandler<ActionEvent> {
    private Juego juego;
    private Aldeano aldeano;
    private int fila;
    private int columna;

    public BotonConstruirCuartel(Juego juego, Aldeano aldeano, int fila, int columna){
        this.aldeano = aldeano;
        this.fila = fila;
        this.columna = columna;
        this.juego= juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        try{
            juego.construirPlazaCentral(aldeano,fila,columna);
        }catch(OroInsuficienteException e){
            alert.setTitle("Error al construir plaza central");
            alert.setContentText("No tienes oro suficiente para crear una plaza central");
            alert.show();
        }catch(AldeanoEstaOcupadoException e) {
            alert.setTitle("Error al construir plaza central");
            alert.setContentText("El aldeano esta ocupado");
            alert.show();
        }
    }
}
