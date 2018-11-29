package modelo.excepciones;

public class NoSePuedeDesmontarArmaDeAsedioEnPausaException extends ArmaDeAsedioException {

    public NoSePuedeDesmontarArmaDeAsedioEnPausaException() {
        super("Tenes que esperar al proximo turno para desmontar el arma");

    }


}
