package modelo.excepciones;

public class UnidadSeleccionadaNoPerteneceAJugadorException extends ColocableSeleccionadoException {

    public UnidadSeleccionadaNoPerteneceAJugadorException() {
        super("La unidad seleccionada no pertenece al jugador actual");
    }

}
