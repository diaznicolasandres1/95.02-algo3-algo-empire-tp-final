package modelo.unidades.espadachin;

import modelo.excepciones.EspadachinYaFueUtilizadoEsteTurnoException;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidades.Atacable;

public class EstadoEspadachinOcupado implements EstadoEspadachin {

	@Override
	public void avanzarTurno(Espadachin espadachin) {
		espadachin.estarDisponible();
	}

	@Override
    public void atacar(Atacable objetivo, Espadachin espadachin) {
		throw new EspadachinYaFueUtilizadoEsteTurnoException();
	}

	@Override
    public void moverEspadachinDesdeHacia(Espadachin espadachin, Posicion origen, Posicion destino, Mapa mapa, int distanciaDeMovimiento) {
		throw new EspadachinYaFueUtilizadoEsteTurnoException();
	}
}
