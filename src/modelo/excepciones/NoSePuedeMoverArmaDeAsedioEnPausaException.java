package modelo.excepciones;

public class NoSePuedeMoverArmaDeAsedioEnPausaException extends ArmaDeAsedioException {

    public NoSePuedeMoverArmaDeAsedioEnPausaException() {
        super("Debes esperar al proximo turno para mover el arma");
    }
}
