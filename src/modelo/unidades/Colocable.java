package modelo.unidades;

import modelo.mapa.Mapa;

public interface Colocable {

    void colocarseEn(Mapa mapa, int fila, int columna);
    
    void descolocarseDe(Mapa mapa);
    
    public abstract String getNombreClase();
    
    public abstract String getNombreEstado();

    void finalizarTurno();
}
