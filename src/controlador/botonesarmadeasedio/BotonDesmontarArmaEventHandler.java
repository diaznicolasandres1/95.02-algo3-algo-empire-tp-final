package controlador.botonesarmadeasedio;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.excepciones.ArmaDeAsedioException;

import modelo.juego.Juego;
import modelo.unidades.armadeasedio.ArmaDeAsedio;

public class BotonDesmontarArmaEventHandler  implements EventHandler<ActionEvent> {
    private ArmaDeAsedio armaDeAsedio;
    private Juego juego;

    public BotonDesmontarArmaEventHandler(Juego juego, ArmaDeAsedio arma) {
        this.armaDeAsedio = arma;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            juego.desmontarArma(armaDeAsedio);
        } catch (ArmaDeAsedioException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error al desmontar arma");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
