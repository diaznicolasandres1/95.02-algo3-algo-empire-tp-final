package modelo.excepciones;

public class UnidadYaFueUtilizadaEnEsteTurnoException extends RuntimeException {

    private String mensaje;

    public UnidadYaFueUtilizadaEnEsteTurnoException(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMessage() {
        return this.mensaje;
    }
}
