package controlador;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonSalirEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Platform.exit();
    }

}
