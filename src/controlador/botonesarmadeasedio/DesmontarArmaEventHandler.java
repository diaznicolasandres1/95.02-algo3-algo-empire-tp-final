package controlador.botonesarmadeasedio;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
import modelo.excepciones.ArmaDeAsedioException;

import modelo.excepciones.ColocableSeleccionadoException;
import modelo.juego.Juego;
import modelo.unidades.armadeasedio.ArmaDeAsedio;

public class DesmontarArmaEventHandler implements EventHandler<ActionEvent> {

    private final ArmaDeAsedio armaDeAsedio;
    private final Juego juego;

    public DesmontarArmaEventHandler(Juego juego, ArmaDeAsedio arma) {
        this.armaDeAsedio = arma;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error al desmontar arma");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try {
            this.juego.desmontarArma(this.armaDeAsedio);
        } catch (ArmaDeAsedioException | ColocableSeleccionadoException e) {
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
