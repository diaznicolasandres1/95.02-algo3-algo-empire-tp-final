package modelo.excepciones;

public class NoSePuedeMontarArmaDeAsedioEnPausaException extends ArmaDeAsedioException {

    public NoSePuedeMontarArmaDeAsedioEnPausaException() {
        super("Tenes que esperar al proximo turno para montar el arma");
    }
}
