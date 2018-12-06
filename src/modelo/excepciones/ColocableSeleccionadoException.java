package modelo.excepciones;

public class ColocableSeleccionadoException extends RuntimeException {

    private final String mensaje;

    public ColocableSeleccionadoException(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMessage() {
        return this.mensaje;
    }
}
