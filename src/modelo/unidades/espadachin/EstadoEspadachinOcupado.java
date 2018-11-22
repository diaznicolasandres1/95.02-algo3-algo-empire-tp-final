package modelo.unidades.espadachin;

import modelo.edificios.Edificio;
import modelo.unidades.Unidad;

public class EstadoEspadachinOcupado implements EstadoEspadachin {

	@Override
	public void avanzarTurno(Espadachin espadachin) {
		espadachin.estarDisponible();

	}

	@Override
	public void atacar(Edificio edificio,Espadachin espadachin) {
		throw new EspadachinYaAtacoEnEsteTurnoException();

	}

	@Override
	public void atacar(Unidad unidad,Espadachin espadachin) {
		throw new EspadachinYaAtacoEnEsteTurnoException();

	}

}
