package modelo.unidades.espadachin;

import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidades.Colocable;

public class EstadoEspadachinDisponible implements EstadoEspadachin {

	@Override
	public void avanzarTurno(Espadachin espadachin) {
		espadachin.estarDisponible();		
	}

	@Override
    public void atacar(Colocable colocable, Espadachin espadachin) {
        colocable.recibirDanio(espadachin);
	}

	@Override
    public void moverEspadachinDesdeHacia(Espadachin espadachin, Posicion origen, Posicion destino, Mapa mapa, int distanciaDeMovimiento) {
        origen.moverUnidadHacia(espadachin, mapa, destino, distanciaDeMovimiento);
    }
}
