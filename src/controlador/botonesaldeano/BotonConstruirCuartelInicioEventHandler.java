package controlador.botonesaldeano;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.juego.Juego;
import modelo.unidades.aldeano.Aldeano;
import vista.ContenedorPrincipal;

public class BotonConstruirCuartelInicioEventHandler implements EventHandler<ActionEvent> {
    public Juego juego;
    public Aldeano aldeano;
    public ContenedorPrincipal contenedorPrincipal;


    public BotonConstruirCuartelInicioEventHandler(Juego juego, Aldeano aldeano, ContenedorPrincipal contenedorPrincipal){
        this.aldeano = aldeano;
        this.juego= juego;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setContentText("Haz click en donde quieres colocar el cuartel");
        alert.show();

       contenedorPrincipal.cambiarElHandleryRecibeCambiador(aldeano);

        //Poner todos los casilleros en handle finalizar creacion plaza central
        //Poner todos los demas en modo seleccion de lugar
    }
}
