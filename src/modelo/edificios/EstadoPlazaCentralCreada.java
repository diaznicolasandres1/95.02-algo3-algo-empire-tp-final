package modelo.edificios;

import modelo.Oro;
import modelo.unidades.aldeano.Aldeano;

public class EstadoPlazaCentralCreada implements EstadoPlazaCentral{

	@Override
	public Aldeano crearAldeano(Oro oro) {
		Aldeano nuevoAldeano = new Aldeano(oro);
		return nuevoAldeano;
	}

	@Override
	public void repararse(Edificio plaza) {
		plaza.repararseAsimismo();
	}	

	@Override
	public void recibirDanio(Edificio plazaCentral, int danio) {
		plazaCentral.recibirDanio(danio);		
	}

	@Override
	public void avanzarTurno(Edificio plazaCentral) {	
		
	}

	
}
