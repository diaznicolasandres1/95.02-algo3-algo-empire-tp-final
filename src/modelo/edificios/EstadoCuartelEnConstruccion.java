package modelo.edificios;

import modelo.Oro;
import modelo.unidades.Espadachin;
import modelo.unidades.arquero.Arquero;

public class EstadoCuartelEnConstruccion implements EstadoCuartel {
	int turnos =3 ;
	
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
