package modelo.excepciones;

public class EdificioSeleccionadoNoPerteneceAJugadorException extends ColocableSeleccionadoException {

    public EdificioSeleccionadoNoPerteneceAJugadorException() {
        super("El edificio seleccionado no pertenece a jugador actual");
    }

}
