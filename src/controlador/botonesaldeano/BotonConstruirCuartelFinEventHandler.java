package controlador.botonesaldeano;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.excepciones.AldeanoEstaOcupadoException;
import modelo.excepciones.ColocableSeleccionadoException;
import modelo.excepciones.ConstruccionFueraDeRangoException;
import modelo.juego.Juego;
import modelo.unidades.aldeano.Aldeano;
import vista.ContenedorPrincipal;

public class BotonConstruirCuartelFinEventHandler implements EventHandler<ActionEvent> {
    private  ContenedorPrincipal contenedor;
    private Aldeano constructor;
    private Juego juego;
    private int fila;
    private int columna;

    public BotonConstruirCuartelFinEventHandler(Juego juego, Aldeano constructor, int fila, int columna, ContenedorPrincipal contenedor){
        this.constructor = constructor;
        this.contenedor = contenedor;
        this.juego = juego;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            juego.construirCuartel(constructor, fila, columna);
        } catch (ColocableSeleccionadoException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error al seleccionar edificio/aldeano");
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (AldeanoEstaOcupadoException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error al seleccionar aldeano");
            alert.setContentText("El aldeano seleccionado se encuentra ocupado");
            alert.show();
        } catch (ConstruccionFueraDeRangoException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error al construir");
            alert.setContentText("La posicion donde se pretende construir el edificio no esta proxima al aldeano");
            alert.show();
        }
        contenedor.dibujarMapaConCasilleroHandler();
    }
}
