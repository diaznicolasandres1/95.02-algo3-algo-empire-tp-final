package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

public class Boton extends Button {

    public Boton(String texto, EventHandler<ActionEvent> handler) {
        this.setTexto(texto);
        this.setHandler(handler);
    }

    public void setTextoHover(String texto) {
        this.setTooltip(new Tooltip(texto));
    }

    public void setTexto(String texto) {
        this.setText(texto);
    }

    public void setHandler(EventHandler<ActionEvent> handler) {
        this.setOnAction(handler);
    }
}
