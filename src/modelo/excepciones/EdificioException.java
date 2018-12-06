package modelo.excepciones;

public class EdificioException extends RuntimeException {

    private final String mensaje;

    public EdificioException(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMessage() {
        return this.mensaje;
    }
}
