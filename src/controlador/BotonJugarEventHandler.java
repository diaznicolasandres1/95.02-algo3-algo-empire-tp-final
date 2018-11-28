package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
        this.stage.setScene(this.proximaEscena);
    }
}
