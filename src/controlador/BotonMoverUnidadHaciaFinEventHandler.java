package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
import modelo.excepciones.*;
import modelo.juego.Juego;
import modelo.unidades.Unidad;
import vista.ContenedorPrincipal;

public class BotonMoverUnidadHaciaFinEventHandler implements EventHandler<ActionEvent> {

    private Unidad unidad;
    private Juego juego;
    private int fila;
    private int columna;
    private ContenedorPrincipal contenedorPrincipal;

    public BotonMoverUnidadHaciaFinEventHandler(Juego juego, Unidad unidad, int fila, int columna, ContenedorPrincipal contenedorPrincipal) {
        this.unidad = unidad;
        this.juego = juego;
        this.fila = fila;
        this.columna = columna;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error al mover la unidad");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        try {
            this.juego.moverUnidadHacia(this.unidad, this.fila, this.columna);
        } catch (CasilleroOcupadoException e) {
            alert.setContentText("El casillero de destino se encuentra ocupado");
            alert.show();
        } catch (ColocableSeleccionadoException | UnidadYaFueUtilizadaEnEsteTurnoException | ArmaDeAsedioException e) {
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (PosicionFueraDeRangoException e) {
            alert.setContentText("La posicion de destino se encuentra fuera de rango de movimiento");
            alert.show();
        }
        this.contenedorPrincipal.clearMensajes();
        this.contenedorPrincipal.dibujarMapaConCasilleroHandler();
    }
}
