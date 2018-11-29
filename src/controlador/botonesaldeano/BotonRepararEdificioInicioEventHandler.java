package controlador.botonesaldeano;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.edificios.Edificio;
import modelo.edificios.plazacentral.PlazaCentralEnConstruccionException;
import modelo.excepciones.AldeanoEstaOcupadoException;
import modelo.excepciones.CuartelCreandoseException;
import modelo.excepciones.OroInsuficienteException;
import modelo.excepciones.YaEstanReparandoEsteEdificioException;
import modelo.juego.Juego;
import modelo.unidades.aldeano.Aldeano;

public class BotonRepararEdificioInicioEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private Aldeano aldeano;
    private Edificio edificio;

    public BotonRepararEdificioInicioEventHandler(Juego juego, Aldeano aldeano,int fila, int col) {
        this.juego = juego;
        this.aldeano = aldeano;
        this.edificio = edificio;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setContentText("Haz click en el edificio que quieres reparar");
        alert.show();
        //Poner todos los casilleros en modo handle terminar reparacion.

    }


}
