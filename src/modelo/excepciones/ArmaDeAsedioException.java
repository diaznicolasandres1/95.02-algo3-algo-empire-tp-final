package modelo.excepciones;

public class ArmaDeAsedioException extends RuntimeException {

    private final String mensaje;

    public ArmaDeAsedioException(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMessage() {
        return this.mensaje;
    }
}
