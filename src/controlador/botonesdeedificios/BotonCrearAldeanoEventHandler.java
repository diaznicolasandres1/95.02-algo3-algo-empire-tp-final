package controlador.botonesdeedificios;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.excepciones.LimiteDePoblacionAlcanzadoException;
import modelo.excepciones.OroInsuficienteException;
import modelo.excepciones.PlazaCentralEnConstruccionException;
import modelo.juego.Juego;

public class BotonCrearAldeanoEventHandler implements EventHandler<ActionEvent> {
    private Juego juego;
    private PlazaCentral plaza;
    public BotonCrearAldeanoEventHandler(Juego juego, PlazaCentral plaza){
        this.juego = juego;
        this.plaza = plaza;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        try{
            juego.crearAldeano(plaza);
        }catch(OroInsuficienteException e){
            alert.setTitle("Error al crear aldeano");
            alert.setContentText("No tienes oro suficiente para crear un aldeano");
            alert.show();
        }
        catch(PlazaCentralEnConstruccionException e){
            alert.setTitle("Error al crear aldeano");
            alert.setContentText("La plaza central  se encuentra en construccion");
            alert.show();
        }catch (LimiteDePoblacionAlcanzadoException e){
            alert.setTitle("Error al crear aldeano");
            alert.setContentText("Limite de poblacion alcanzado");
            alert.show();

        }

    }
}
