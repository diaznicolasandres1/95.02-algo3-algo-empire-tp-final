package controlador.botonesdeedificios;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.edificios.castillo.Castillo;
import modelo.excepciones.OroInsuficienteException;
import modelo.juego.Juego;
import vista.ContenedorPrincipal;

public class BotonCrearArmaDeAsedioEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private Castillo castillo;
    private ContenedorPrincipal contenedorPrincipal;

    public BotonCrearArmaDeAsedioEventHandler(Juego juego, Castillo castillo, ContenedorPrincipal contenedorPrincipal){
        this.juego = juego;
        this.castillo = castillo;
        this.contenedorPrincipal = contenedorPrincipal;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        try{
            juego.crearArmaDeAsedio(this.castillo);
        }catch(OroInsuficienteException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error al crear arma de asedio");
            alert.setContentText("No tienes oro suficiente para crear una arma de asedio");
            alert.show();
        }
        contenedorPrincipal.dibujarMapaConCasilleroHandler();
    }
}
