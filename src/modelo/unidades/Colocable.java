package modelo.unidades;

import modelo.mapa.Posicion;
import modelo.edificios.castillo.Castillo;
import modelo.mapa.Mapa;
import modelo.unidades.armadeasedio.ArmaDeAsedio;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;

public interface Colocable {

    void colocarseEn(Mapa mapa, int fila, int columna);
    void avanzarTurno();
    void descolocarseDe(Mapa mapa);
    int calcularDistanciaA(Posicion posicion);
    void reducirVida(int danio);
    void recibirDanio(Castillo castillo);
    void recibirDanio(Arquero arquero);
    void recibirDanio(ArmaDeAsedio armaDeAsedio);
    void recibirDanio(Espadachin espadachin);
}
