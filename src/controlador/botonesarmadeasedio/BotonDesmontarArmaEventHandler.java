package controlador.botonesarmadeasedio;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.excepciones.ArmaDeAsedioYaSeEncuentraDesmontadaException;
import modelo.excepciones.TenesQueEsperarAlProximoTurnoParaDesmontarArmaException;
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        try {
            juego.desmontarArma(armaDeAsedio);
        } catch (ArmaDeAsedioYaSeEncuentraDesmontadaException e) {
            alert.setTitle("Error al montar arma");
            alert.setContentText("El arma ya se encuentra desmontada");
            alert.show();
        } catch (TenesQueEsperarAlProximoTurnoParaDesmontarArmaException e) {
            alert.setTitle("Error al montar arma");
            alert.setContentText("Tenes que esperar al proximo turno para desmontar el arma");
            alert.show();
        }
    }
}
