package modelo.unidades.espadachin;

import modelo.edificios.Edificio;
import modelo.unidades.Unidad;

public interface EstadoEspadachin {
	void avanzarTurno(Espadachin espadachin);
	void atacar(Edificio edificio);
	void atacar(Unidad unidad);

}
