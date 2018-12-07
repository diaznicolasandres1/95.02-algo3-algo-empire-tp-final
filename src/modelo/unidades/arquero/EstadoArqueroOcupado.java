package modelo.unidades.arquero;

import modelo.excepciones.ArqueroYaFueUtilizadoEnEsteTurnoException;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidades.Atacable;

public class EstadoArqueroOcupado implements EstadoArquero {

	private static final String NOMRE_ESTADO = "Ocupado";

    @Override
	public void avanzarTurno(Arquero arquero) {
        arquero.estarDisponible();
	}

	@Override
    public void atacar(Atacable objetivo, Arquero arquero) {
        throw new ArqueroYaFueUtilizadoEnEsteTurnoException();
	}

	@Override
    public void moverArqueroDesdeHacia(Arquero arquero, Posicion origen, Posicion destino, Mapa mapa, int distanciaDeMovimiento) {
        throw new ArqueroYaFueUtilizadoEnEsteTurnoException();
	}
	
	public String getNombreEstado() {
        return NOMRE_ESTADO;
    }
}
