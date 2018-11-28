package modelo.excepciones;

public class ArmaDeAsedioYaSeEncuentraMontadaException extends ArmaDeAsedioException {
    public ArmaDeAsedioYaSeEncuentraMontadaException(String s) {
        super("Arma de asedio ya se encuentra montada");
    }
}
