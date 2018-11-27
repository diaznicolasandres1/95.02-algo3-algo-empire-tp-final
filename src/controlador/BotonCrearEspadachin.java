package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.edificios.cuartel.Cuartel;
import modelo.excepciones.OroInsuficienteException;
import modelo.juego.Juego;

public class BotonCrearEspadachin implements EventHandler<ActionEvent> {

    private Juego juego;
    private Cuartel cuartel;

    public BotonCrearEspadachin(Juego juego, Cuartel cuartel){
        this.juego = juego;
        this.cuartel = cuartel;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        try{
            juego.crearEspadachin(this.cuartel);
        }catch(OroInsuficienteException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error al crear Espadachin");
            alert.setContentText("No tienes oro suficiente para crear un Espadachin");
            alert.show();
        }

    }
}
