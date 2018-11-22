package modelo.unidades;

import modelo.Posicion;
import modelo.edificios.Castillo;
import modelo.mapa.Mapa;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;

public interface Colocable {

    void colocarseEn(Mapa mapa, int fila, int columna);
    void avanzarTurno();
    void descolocarseDe(Mapa mapa);
    int calcularDistanciaA(Posicion posicion);
	void recibirDanio(int i);
	void recibirDanio(Castillo castillo);

    

    
    
}
