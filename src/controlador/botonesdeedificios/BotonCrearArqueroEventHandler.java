package controlador.botonesdeedificios;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.edificios.cuartel.Cuartel;
import modelo.excepciones.CuartelCreandoseException;
import modelo.excepciones.LimiteDePoblacionAlcanzadoException;
import modelo.excepciones.OroInsuficienteException;
import modelo.juego.Juego;

public class BotonCrearArqueroEventHandler implements EventHandler<ActionEvent> {
    private Juego juego;
    private Cuartel cuartel;

    public BotonCrearArqueroEventHandler(Juego juego, Cuartel cuartel){
        this.juego = juego;
        this.cuartel = cuartel;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        try{
            juego.crearArquero(cuartel);
        }catch(OroInsuficienteException e){

            alert.setTitle("Error al crear arquero");
            alert.setContentText("No tienes oro suficiente para crear un arquero");
            alert.show();
        }
        catch(CuartelCreandoseException e){
            alert.setTitle("Error al crear arquero");
            alert.setContentText("El cuartel  se encuentra en construccion");
            alert.show();
        }catch (LimiteDePoblacionAlcanzadoException e){
            alert.setTitle("Error al crear arquero");
            alert.setContentText("Limite de poblacion alcanzado");
            alert.show();
        }
    }
}

