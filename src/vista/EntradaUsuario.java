package vista;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class EntradaUsuario {

    private HBox hBox;
    private TextField textField;

    public EntradaUsuario(String textoHover) {

        TextField texto = new TextField(textoHover);
        texto.setPrefColumnCount(30);
        HBox hBox = new HBox(texto);
        hBox.setSpacing(10);
        this.hBox = hBox;
        this.textField = texto;
    }

    public HBox getHb() {
        return this.hBox;
    }

    public String getNombre() {
        return this.textField.getText();
    }

}
