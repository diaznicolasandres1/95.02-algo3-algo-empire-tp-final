package modelo.edificios.cuartel;

import modelo.juego.Oro;
import modelo.edificios.Edificio;
import modelo.excepciones.CuartelCreandoseException;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;

public class EstadoCuartelEnConstruccion implements EstadoCuartel {

    private int turnos = 3;
	
	public void avanzarTurno(Edificio cuartel) {
        turnos -= 1;
		if (turnos < 1) {
			cuartel.terminoDeCrearse();			
		}
	}

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
