package modelo.excepciones;

public class AldeanoEstaOcupadoException extends UnidadYaFueUtilizadaEnEsteTurnoException {

    public AldeanoEstaOcupadoException() {
        super("Aldeano se encuentra ocupado o ya fue utilizado en este turno");
    }

}
