package modelo.excepciones;

public class TenesQueEsperarAlProximoTurnoParaAtacarException extends ArmaDeAsedioException {

    public TenesQueEsperarAlProximoTurnoParaAtacarException() {
        super("Se debe esperar hasta el proximo turno para atacar");
    }

}
