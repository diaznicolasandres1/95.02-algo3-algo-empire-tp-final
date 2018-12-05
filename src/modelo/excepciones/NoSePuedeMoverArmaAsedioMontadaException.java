package modelo.excepciones;

public class NoSePuedeMoverArmaAsedioMontadaException extends ArmaDeAsedioException {
    
    public NoSePuedeMoverArmaAsedioMontadaException() {
        super("No se puede mover arma de asedio montada");
    }

}
