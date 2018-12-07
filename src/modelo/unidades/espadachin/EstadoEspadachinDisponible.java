package modelo.unidades.espadachin;

import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidades.Atacable;

public class EstadoEspadachinDisponible implements EstadoEspadachin {

	private static final String NOMBRE_ESTADO = "Disponible";

    @Override
	public void avanzarTurno(Espadachin espadachin) {
		espadachin.estarDisponible();		
	}

	@Override
    public void atacar(Atacable objetivo, Espadachin espadachin) {
        objetivo.recibirDanio(espadachin);
	}

	@Override
    public void moverEspadachinDesdeHacia(Espadachin espadachin, Posicion origen, Posicion destino, Mapa mapa, int distanciaDeMovimiento) {
        origen.moverUnidadHacia(espadachin, mapa, destino, distanciaDeMovimiento);
    }
	
	@Override
    public String getNombreEstado() {
        return NOMBRE_ESTADO;
    }
}
