package modelo.unidades;

import modelo.mapa.Mapa;

public interface Colocable {

    void colocarseEn(Mapa mapa, int fila, int columna);
    
    void descolocarseDe(Mapa mapa);

    String getNombreClase();

    String getNombreEstado();

    void finalizarTurno();
}
