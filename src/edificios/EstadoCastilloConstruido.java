package edificios;

import modelo.Oro;
import unidades.ArmaDeAsedio;

public class EstadoCastilloConstruido implements EstadoEdificio {

	@Override
	public void repararse(Edificio castillo) {
		castillo.repararseASimismo();
		
	}

	@Override
	public void recibirDanio(Edificio castillo, int danio) {
		castillo.recibirDanioConValor(danio);	
		
	}

	@Override
	public void avanzarTurno(Edificio castillo) {		
		
	}
	
	
}
