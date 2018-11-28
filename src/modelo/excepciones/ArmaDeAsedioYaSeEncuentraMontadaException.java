package modelo.excepciones;

public class ArmaDeAsedioYaSeEncuentraMontadaException extends ArmaDeAsedioException {
    public ArmaDeAsedioYaSeEncuentraMontadaException() {
        super("Arma de asedio ya se encuentra montada");
    }
}
