package modelo.unidades.espadachin;

import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidades.Colocable;

public interface EstadoEspadachin {

	void avanzarTurno(Espadachin espadachin);

    void atacar(Colocable colocable, Espadachin espadachin);

    void moverEspadachinDesdeHacia(Espadachin espadachin, Posicion origen, Posicion destino, Mapa mapa, int distanciaDeMovimiento);
}
