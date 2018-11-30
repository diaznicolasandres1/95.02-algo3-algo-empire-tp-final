package controlador.botonesarmadeasedio;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.excepciones.ArmaDeAsedioException;

import modelo.excepciones.ColocableSeleccionadoException;
import modelo.juego.Juego;
import modelo.unidades.armadeasedio.ArmaDeAsedio;
import vista.ContenedorPrincipal;

public class BotonDesmontarArmaEventHandler  implements EventHandler<ActionEvent> {

    private ArmaDeAsedio armaDeAsedio;
    private Juego juego;

    public BotonDesmontarArmaEventHandler(Juego juego, ArmaDeAsedio arma, ContenedorPrincipal contenedorPrincipal) {
        this.armaDeAsedio = arma;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error al desmontar arma");
        try {
            juego.desmontarArma(armaDeAsedio);
        } catch (ArmaDeAsedioException | ColocableSeleccionadoException e) {
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
