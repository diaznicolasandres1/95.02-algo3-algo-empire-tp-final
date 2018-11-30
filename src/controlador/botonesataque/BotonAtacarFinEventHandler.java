package controlador.botonesataque;

import controlador.BotonJugarEventHandler;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import modelo.edificios.castillo.CastilloFueDestruidoException;
import modelo.excepciones.*;
import modelo.juego.Juego;
import modelo.unidades.Atacante;
import modelo.unidades.Colocable;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.armadeasedio.ArmaDeAsedio;
import vista.ContenedorPrincipal;

import java.util.Optional;

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
        }catch(CastilloFueDestruidoException e){
            alert.setContentText("El castillo fue destruido finaliza el juego");

            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
               Platform.exit();
            }




        }
        catch (ColocableSeleccionadoException | EdificioException | UnidadYaFueUtilizadaEnEsteTurnoException | ArmaDeAsedioException e) {
            alert.setContentText(e.getMessage());
            alert.show();
        } catch (ColocableFueraDeRangoDeAtaqueException e) {
            alert.setContentText("Objetivo fuera de rango de ataque");
            alert.show();
        }
       contenedor.dibujarMapaConCasilleroHandler();
    }
}
