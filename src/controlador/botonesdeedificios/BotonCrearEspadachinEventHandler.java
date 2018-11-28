package controlador.botonesdeedificios;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.edificios.cuartel.Cuartel;
import modelo.excepciones.CuartelCreandoseException;
import modelo.excepciones.LimiteDePoblacionAlcanzadoException;
import modelo.excepciones.OroInsuficienteException;
import modelo.juego.Juego;

public class BotonCrearEspadachinEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private Cuartel cuartel;

    public BotonCrearEspadachinEventHandler(Juego juego, Cuartel cuartel){
        this.juego = juego;
        this.cuartel = cuartel;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        try{
            juego.crearEspadachin(this.cuartel);
        }catch(OroInsuficienteException e){
            alert.setTitle("Error al crear Espadachin");
            alert.setContentText("No tienes oro suficiente para crear un Espadachin");
            alert.show();
        }catch(CuartelCreandoseException e){
            alert.setTitle("Error al crear Espadachin");
            alert.setContentText("El cuartel  se encuentra en construccion");
            alert.show();
        }catch (LimiteDePoblacionAlcanzadoException e){
            alert.setTitle("Error al crear Espadachin");
            alert.setContentText("Limite de poblacion alcanzado");
            alert.show();

        }


    }
}
