package controlador.botonesaldeano;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.juego.Juego;
import modelo.unidades.aldeano.Aldeano;
import vista.ContenedorPrincipal;

public class BotonConstruirCuartelInicioEventHandler implements EventHandler<ActionEvent> {
    public Juego juego;
    public Aldeano aldeano;
    public ContenedorPrincipal contenedorPrincipal;


    public BotonConstruirCuartelInicioEventHandler(Juego juego, Aldeano aldeano, ContenedorPrincipal contenedorPrincipal) {
        this.aldeano = aldeano;
        this.juego= juego;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        
        this.contenedorPrincipal.setMensaje("Haz click en donde\nquieres colocar el\ncuartel");
        this.contenedorPrincipal.cambiarHandlerConstruirCuartel(this.aldeano);
    }
}
