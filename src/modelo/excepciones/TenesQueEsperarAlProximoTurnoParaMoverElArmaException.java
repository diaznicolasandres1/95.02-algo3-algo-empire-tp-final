package modelo.excepciones;

public class TenesQueEsperarAlProximoTurnoParaMoverElArmaException extends ArmaDeAsedioException {

    public TenesQueEsperarAlProximoTurnoParaMoverElArmaException(String s) {
        super("Tenes que esperar al proximo turno para mover el arma");
    }
}
