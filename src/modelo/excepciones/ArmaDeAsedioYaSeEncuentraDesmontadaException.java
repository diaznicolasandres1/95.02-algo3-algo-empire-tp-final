package modelo.excepciones;

public class ArmaDeAsedioYaSeEncuentraDesmontadaException extends ArmaDeAsedioException {

    public ArmaDeAsedioYaSeEncuentraDesmontadaException(String s) {
        super("El arma de asedio ya se encuentra desmontada");
    }
}
