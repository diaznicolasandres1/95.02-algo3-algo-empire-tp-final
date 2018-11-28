package modelo.excepciones;

public class TenesQueEsperarAlProximoTurnoParaMontarArmaException extends ArmaDeAsedioException {

    public TenesQueEsperarAlProximoTurnoParaMontarArmaException(String s) {
        super("Tenes que esperar al proximo turno para montar el arma");
    }
}
