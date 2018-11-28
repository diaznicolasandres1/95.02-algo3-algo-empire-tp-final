package modelo.excepciones;

public class TenesQueEsperarAlProximoTurnoParaMoverElArmaException extends ArmaDeAsedioException {

    public TenesQueEsperarAlProximoTurnoParaMoverElArmaException() {
        super("Tenes que esperar al proximo turno para mover el arma");
    }
}
