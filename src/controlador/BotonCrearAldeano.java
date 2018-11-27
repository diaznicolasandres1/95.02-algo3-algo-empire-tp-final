package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

import modelo.edificios.plazacentral.PlazaCentral;
import modelo.excepciones.OroInsuficienteException;
import modelo.juego.Juego;

public class BotonCrearAldeano implements EventHandler<ActionEvent> {
    private Juego juego;
    private PlazaCentral plaza;
    public BotonCrearAldeano( Juego juego, PlazaCentral plaza){
        this.juego = juego;
        this.plaza = plaza;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        try{
            juego.crearAldeano(plaza);
        }catch(OroInsuficienteException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error al crear aldeano");
            alert.setContentText("No tienes oro suficiente para crear un aldeano");
            alert.show();
        }

    }
}
