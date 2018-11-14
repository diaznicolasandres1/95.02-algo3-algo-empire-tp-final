package edificios;

import modelo.Oro;
import unidades.Arquero;
import unidades.Espadachin;

public class EstadoCuartelEnConstruccion implements EstadoCuartel {
	int turnos;
	
	public void avanzarTurno(Edificio cuartel) {
		turnos -=1;
		if (turnos < 1) {
			cuartel.terminoDeCrearse();			
		}
	}
	
	
	
	/*En estadoEnConstruccion no se puede realizar lo siguiente
	 * lanzar excepciones!!!*/

	@Override
	public void repararse(Edificio cuartel) {
		throw new CuartelCreandoseException();
		
	}

	@Override
	public void recibirDanio(Edificio cuartel, int danio) {	
		throw new CuartelCreandoseException();
		
	}

	

	@Override
	public Espadachin crearEspadachin(Oro oro) {		
		throw new CuartelCreandoseException();
	}

	@Override
	public Arquero crearArquero(Oro oro) {
		
		throw new CuartelCreandoseException();
	}

	

}
