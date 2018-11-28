package controlador.botonesarmadeasedio;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.excepciones.ArmaDeAsedioException;

import modelo.juego.Juego;
import modelo.unidades.armadeasedio.ArmaDeAsedio;

public class BotonMontarArmaEventHandler implements EventHandler<ActionEvent> {

    private ArmaDeAsedio armaDeAsedio;
    private Juego juego;

    public BotonMontarArmaEventHandler(Juego juego, ArmaDeAsedio arma){
        this.armaDeAsedio = arma;
        this.juego  = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try{
            juego.montarArma(armaDeAsedio);
        } catch (ArmaDeAsedioException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error al montar arma");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

}
