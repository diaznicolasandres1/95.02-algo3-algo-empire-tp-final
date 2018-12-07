package modelo.unidades.arquero;

import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidades.Atacable;

public class EstadoArqueroDisponible implements EstadoArquero {

	private static final String NOMRE_ESTADO = "Disponible";

    @Override
	public void avanzarTurno(Arquero arquero) {
		arquero.estarDisponible();
	}

	@Override
    public void atacar(Atacable objetivo, Arquero arquero) {
        objetivo.recibirDanio(arquero);
	}

	@Override
    public void moverArqueroDesdeHacia(Arquero arquero, Posicion origen, Posicion destino, Mapa mapa, int distanciaDeMovimiento) {
        origen.moverUnidadHacia(arquero, mapa, destino, distanciaDeMovimiento);
	}
	
	public String getNombreEstado() {
	    return NOMRE_ESTADO;
	}
}
