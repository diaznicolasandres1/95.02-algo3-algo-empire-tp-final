package modelo.excepciones;

public class UnidadObjetivoEsPropiaException extends ColocableSeleccionadoException {
    
    public UnidadObjetivoEsPropiaException(){
        super("Unidad objetivo pertence a jugador");
    }
}
