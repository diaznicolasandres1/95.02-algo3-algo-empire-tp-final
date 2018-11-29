package modelo.excepciones;

public class NoSePuedeAtacarConArmaAsedioDesmontadaException extends ArmaDeAsedioException {

    public NoSePuedeAtacarConArmaAsedioDesmontadaException() {
        super("No se puede atacar con arma de asedio desmontada");
    }

}
