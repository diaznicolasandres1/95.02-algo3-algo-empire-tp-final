package modelo.unidades.espadachin;

import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidades.Atacable;

public interface EstadoEspadachin {

	void avanzarTurno(Espadachin espadachin);

    void atacar(Atacable objetivo, Espadachin espadachin);

    void moverEspadachinDesdeHacia(Espadachin espadachin, Posicion origen, Posicion destino, Mapa mapa, int distanciaDeMovimiento);

    String getNombreEstado();
}
