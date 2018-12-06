package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vista.ContenedorPrincipal;
import vista.EntradaUsuario;

import java.util.ArrayList;

public class JugarEventHandler implements EventHandler<ActionEvent> {

    private static final int JUGADOR_UNO = 0;
    private static final int JUGADOR_DOS = 1;
    private final ArrayList<EntradaUsuario> jugadores;
    private final Stage stage;

    public JugarEventHandler(Stage stage, ArrayList<EntradaUsuario> jugadores) {
        this.stage = stage;
        this.jugadores = jugadores;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(this.jugadores.get(JUGADOR_UNO).getNombre(), this.jugadores.get(JUGADOR_DOS).getNombre());
        Scene escenaJuego = new Scene(contenedorPrincipal);
        this.stage.setScene(escenaJuego);
    }
}
