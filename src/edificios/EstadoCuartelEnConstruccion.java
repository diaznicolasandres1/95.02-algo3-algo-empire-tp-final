package edificios;

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
	public Espadachin crearEspadachin() {		
		throw new CuartelCreandoseException();
	}

	@Override
	public Arquero crearArquero() {
		
		throw new CuartelCreandoseException();
	}

	

}
