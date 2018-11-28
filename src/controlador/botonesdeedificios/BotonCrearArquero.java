package controlador.botonesdeedificios;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.excepciones.OroInsuficienteException;
import modelo.juego.Juego;

public class BotonCrearArquero  implements EventHandler<ActionEvent> {
    private Juego juego;
    private Cuartel cuartel;

    public BotonCrearArquero( Juego juego, Cuartel cuartel){
        this.juego = juego;
        this.cuartel = cuartel;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try{
            juego.crearArquero(cuartel);
        }catch(OroInsuficienteException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error al crear arquero");
            alert.setContentText("No tienes oro suficiente para crear un arquero");
            alert.show();
        }
    }
}

