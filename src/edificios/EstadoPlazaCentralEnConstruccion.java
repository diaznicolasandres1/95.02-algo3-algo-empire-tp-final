package edificios;

import unidades.Aldeano;

public class EstadoPlazaCentralEnConstruccion implements EstadoPlazaCentral {
	
	private int turnos = 3 ;
	
	public void avanzarTurno(PlazaCentral plaza) {
		turnos -=1;
		if (turnos < 1) {
			plaza.terminoDeCrearse();			
		}
	}

	@Override
	public void repararse(PlazaCentral plaza) {
		
		
	}

	@Override
	public Aldeano crearAldeano() {
		
		return null;
	}

	@Override
	public void recibirDanio(PlazaCentral plazaCentral, int danio) {
	
	}

	
	

}
