package modelo.unidades.espadachin;

import modelo.excepciones.EspadachinYaFueUtilizadoEsteTurno;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidades.Colocable;

public class EstadoEspadachinOcupado implements EstadoEspadachin {

	@Override
	public void avanzarTurno(Espadachin espadachin) {
		espadachin.estarDisponible();
	}

	@Override
    public void atacar(Colocable colocable, Espadachin espadachin) {
        throw new EspadachinYaFueUtilizadoEsteTurno();
	}

	@Override
    public void moverEspadachinDesdeHacia(Espadachin espadachin, Posicion origen, Posicion destino, Mapa mapa, int distanciaDeMovimiento) {
        throw new EspadachinYaFueUtilizadoEsteTurno();
	}
}
