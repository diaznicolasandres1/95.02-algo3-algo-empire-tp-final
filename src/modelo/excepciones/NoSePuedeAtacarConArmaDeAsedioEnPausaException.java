package modelo.excepciones;

public class NoSePuedeAtacarConArmaDeAsedioEnPausaException extends ArmaDeAsedioException {

    public NoSePuedeAtacarConArmaDeAsedioEnPausaException() {
        super("Se debe esperar hasta el proximo turno para atacar");
    }

}
