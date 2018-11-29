package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.excepciones.CasilleroOcupadoException;
import modelo.excepciones.CoordenadasInvalidasException;
import modelo.excepciones.DistanciaInvalidaException;
import modelo.excepciones.PosicionFueraDeRangoException;
import modelo.juego.Juego;
import modelo.unidades.Unidad;
import vista.ContenedorPrincipal;

public class BotonMoverUnidadHaciaFinEventHandler implements EventHandler<ActionEvent> {
    private Unidad movible;
    private Juego juego;
    private int fila;
    private int columna;
    private ContenedorPrincipal contenedorPrincipal;

    public BotonMoverUnidadHaciaFinEventHandler(Juego juego, Unidad unidad, int fila, int columna, ContenedorPrincipal contenedorPrincipal) {
        this.movible = unidad;
        this.juego = juego;
        this.fila = fila;
        this.columna = columna;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        try {
            juego.moverUnidadHacia(movible,columna,fila);
        } catch (CasilleroOcupadoException e) {
            alert.setTitle("Error al mover unidad");
            alert.setContentText("Ese casillero ya esta ocupado");
            alert.show();
        } catch (CoordenadasInvalidasException e) {
            alert.setTitle("Error al mover unidad");
            alert.setContentText("Casillero fuera del limite");
            alert.show();
        } catch (DistanciaInvalidaException e) {
            alert.setTitle("Error al mover unidad");
            alert.setContentText("");
            alert.show();
        } catch (PosicionFueraDeRangoException e) {
            alert.setTitle("Error al mover unidad");
            alert.setContentText("");
            alert.show();
        }
        contenedorPrincipal.dibujarMapaConCasilleroHandler();
    }
}
