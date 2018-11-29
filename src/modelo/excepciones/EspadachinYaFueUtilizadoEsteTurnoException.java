package modelo.excepciones;

public class EspadachinYaFueUtilizadoEsteTurnoException extends UnidadYaFueUtilizadaEnEsteTurnoException {

    public EspadachinYaFueUtilizadoEsteTurnoException() {
        super("Espadachin ya fue utilizado en este turno");
    }
}
