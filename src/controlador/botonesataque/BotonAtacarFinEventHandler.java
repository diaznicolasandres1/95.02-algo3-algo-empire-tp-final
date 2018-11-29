package controlador.botonesataque;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.excepciones.*;
import modelo.juego.Juego;
import modelo.unidades.Atacante;
import modelo.unidades.Colocable;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.armadeasedio.ArmaDeAsedio;
import vista.ContenedorPrincipal;

public class BotonAtacarFinEventHandler implements EventHandler<ActionEvent> {
    private ContenedorPrincipal contenedor;
    private Atacante atacante;
    private Juego juego;
    private int fila;
    private int columna;

    public  BotonAtacarFinEventHandler(Juego juego, Atacante atacante, int fila, int columna, ContenedorPrincipal contenedorPrincipal){
        this.juego = juego;
        this.atacante = atacante;
        this.contenedor = contenedorPrincipal;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Colocable atacado = juego.getColocable(fila,columna);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error al atacar");
        try {
            juego.atacar(atacante, atacado);
        } catch (ColocableSeleccionadoException | EdificioException | UnidadYaFueUtilizadaEnEsteTurnoException | ArmaDeAsedioException e) {
            alert.setContentText(e.getCause().getMessage());
            alert.show();
        } catch (ColocableFueraDeRangoDeAtaqueException e) {
            alert.setContentText("Objetivo fuera de rango de ataque");
            alert.show();
        }
        contenedor.dibujarMapaConCasilleroHandler();
    }
}
