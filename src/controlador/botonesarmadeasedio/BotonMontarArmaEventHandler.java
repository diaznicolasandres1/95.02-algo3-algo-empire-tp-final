package controlador.botonesarmadeasedio;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.excepciones.ArmaDeAsedioYaSeEncuentraMontadaException;
import modelo.excepciones.TenesQueEsperarAlProximoTurnoParaMontarArmaException;
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        try{
            juego.montarArma(armaDeAsedio);
        }catch(ArmaDeAsedioYaSeEncuentraMontadaException e){
            alert.setTitle("Error al montar arma");
            alert.setContentText("El arma ya se encuentra montada");
            alert.show();
        }catch(TenesQueEsperarAlProximoTurnoParaMontarArmaException e){
            alert.setTitle("Error al montar arma");
            alert.setContentText("Tenes que esperar al proximo turno para montar el arma");
            alert.show();
        }
    }
}
