package modelo.excepciones;

public class ArmaDeAsedioException extends RuntimeException {

    private String mensaje;

    public ArmaDeAsedioException(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMessage() {
        return this.mensaje;
    }
}
