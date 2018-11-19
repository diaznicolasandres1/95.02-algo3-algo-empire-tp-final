package modelo.unidades;

import modelo.mapa.Mapa;

public interface Colocable {

    void colocarseEn(Mapa mapa, int fila, int columna);
    void avanzarTurno();

    void descolocarseDe(Mapa mapa);
}
