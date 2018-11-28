package modelo.excepciones;

public class ArmaDeAsedioYaSeEncuentraDesmontadaException extends ArmaDeAsedioException {

    public ArmaDeAsedioYaSeEncuentraDesmontadaException() {
        super("El arma de asedio ya se encuentra desmontada");
    }
}
