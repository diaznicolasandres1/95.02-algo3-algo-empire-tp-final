package modelo.excepciones;

public class EdificioSiendoReparadoException extends EdificioException {

    public EdificioSiendoReparadoException() {
        super("Edificio ya se encuentra siendo reparado");
    }
}