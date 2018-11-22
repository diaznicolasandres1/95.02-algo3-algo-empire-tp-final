package modelo.edificios.plazacentral;

import modelo.Oro;
import modelo.edificios.Edificio;
import modelo.unidades.aldeano.Aldeano;

public class EstadoPlazaCentralEnConstruccion implements EstadoPlazaCentral {
	
	private int turnos = 3;
	
	public void avanzarTurno(Edificio plaza) {
		turnos -=1;
		if (turnos < 1) {
			plaza.terminoDeCrearse();			
		}
	}

	@Override
	public void repararse(Edificio plaza) {	
		throw new PlazaCentralEnConstruccionException();
		
	}	

	@Override
	public void recibirDanio(Edificio plazaCentral, int danio) {
		throw new PlazaCentralEnConstruccionException();
	
	}
	@Override
	public Aldeano crearAldeano(Oro oro) {
		throw new PlazaCentralEnConstruccionException();
		
	}
	
	

}
