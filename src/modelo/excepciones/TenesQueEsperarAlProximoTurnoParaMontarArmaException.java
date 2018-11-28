package modelo.excepciones;

public class TenesQueEsperarAlProximoTurnoParaMontarArmaException extends ArmaDeAsedioException {

    public TenesQueEsperarAlProximoTurnoParaMontarArmaException() {
        super("Tenes que esperar al proximo turno para montar el arma");
    }
}
