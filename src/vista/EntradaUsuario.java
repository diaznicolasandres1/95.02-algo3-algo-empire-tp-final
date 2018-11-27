package vista;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class EntradaUsuario {

    private HBox hBox;
    private TextField textField;
    private ColorPicker colorPicker;

    public EntradaUsuario(String textoHover, Color colorPorDefecto) {

        TextField texto = new TextField(textoHover);
        texto.setPrefColumnCount(30);
        ColorPicker color = new ColorPicker(colorPorDefecto);
        color.setStyle("-fx-color-label-visible: false;");
        HBox hBox = new HBox(texto, color);
        hBox.setSpacing(10);
        this.hBox = hBox;
        this.textField = texto;
        this.colorPicker = color;
    }

    public HBox getHb() {
        return this.hBox;
    }

    public String getNombre() {
        return this.textField.getText();
    }

    public Color getColor() {
        return this.colorPicker.getValue();
    }
}
