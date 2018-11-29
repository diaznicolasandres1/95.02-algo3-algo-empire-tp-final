package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.excepciones.*;
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
        alert.setTitle("Error al mover la unidad");
        try {
            juego.moverUnidadHacia(movible, columna, fila);
        } catch (CasilleroOcupadoException e) {
            alert.setContentText("El casillero de destino se encuentra ocupado");
            alert.show();
        } catch (ColocableSeleccionadoException | UnidadYaFueUtilizadaEnEsteTurnoException | ArmaDeAsedioException e) {
            alert.setContentText(e.getCause().getMessage());
            alert.show();
        } catch (PosicionFueraDeRangoException e) {
            alert.setContentText("La posicion de destino se encuentra fuera de rango de movimiento");
            alert.show();
        }
        contenedorPrincipal.dibujarMapaConCasilleroHandler();
    }
}
