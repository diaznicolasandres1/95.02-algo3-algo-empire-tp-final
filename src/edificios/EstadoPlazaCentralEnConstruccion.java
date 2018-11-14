package edificios;

import modelo.Oro;
import unidades.Aldeano;

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
		
	}	

	@Override
	public void recibirDanio(Edificio plazaCentral, int danio) {
	
	}
	@Override
	public Aldeano crearAldeano(Oro oro) {
		
		return null;
	}
	
	

}
