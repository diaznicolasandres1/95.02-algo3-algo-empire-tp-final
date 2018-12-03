package modelo.excepciones;

public class ColocableSeleccionadoException extends RuntimeException {

    private String mensaje;

    public ColocableSeleccionadoException(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMessage() {
        return this.mensaje;
    }
}
