package modelo.unidades.arquero;

import modelo.edificios.Edificio;
import modelo.unidades.Unidad;
import modelo.unidades.aldeano.Aldeano;

public class EstadoArqueroOcupado implements EstadoArquero {

	@Override
	public void avanzarTurno(Arquero arquero) {
		arquero.estarDisponible();	
		
	}

	@Override
	public void atacar(Edificio edificio) {
		throw new ArqueroYaAtacoEnEsteTurnoException();
		
	}

	@Override
	public void atacar(Unidad unidad) {
		throw new ArqueroYaAtacoEnEsteTurnoException();
		
	}

}
