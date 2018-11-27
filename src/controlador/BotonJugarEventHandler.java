package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import vista.EntradaUsuario;

import java.util.ArrayList;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {

    private ArrayList<EntradaUsuario> jugadores;
    private Stage stage;
    private Scene proximaEscena;

    public BotonJugarEventHandler(Stage stage, Scene proximaEscena, ArrayList<EntradaUsuario> jugadores) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.jugadores = jugadores;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setResizable(false);
        alert.setTitle("En proceso");
        alert.setContentText("Deberia mandar hacia la siguiente scene con todo colocado");
        alert.show();
        // this.stage.setScene(this.proximaEscena);
        // TODO aca pasar a la siguiente escena, poniendo los jugadores, y las estructuras iniciales segun los colores.
    }
}
