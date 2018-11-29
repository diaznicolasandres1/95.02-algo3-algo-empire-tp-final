package modelo.excepciones;

public class ArqueroYaFueUtilizadoEnEsteTurnoException extends UnidadYaFueUtilizadaEnEsteTurnoException {

    public ArqueroYaFueUtilizadoEnEsteTurnoException() {
        super("Arquero ya fue utilizado en este turno");
    }
}
