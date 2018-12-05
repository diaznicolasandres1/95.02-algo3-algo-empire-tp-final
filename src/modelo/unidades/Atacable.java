package modelo.unidades;

import modelo.edificios.castillo.Castillo;
import modelo.mapa.Posicion;
import modelo.unidades.armadeasedio.ArmaDeAsedio;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;

public interface Atacable {

    int calcularDistanciaA(Posicion posicion);

    void recibirDanio(Castillo castillo);

    void recibirDanio(Arquero arquero);

    void recibirDanio(ArmaDeAsedio armaDeAsedio);

    void recibirDanio(Espadachin espadachin);
}
