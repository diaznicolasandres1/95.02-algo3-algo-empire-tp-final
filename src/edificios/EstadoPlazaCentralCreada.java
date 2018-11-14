package edificios;

import modelo.Oro;
import unidades.Aldeano;

public class EstadoPlazaCentralCreada implements EstadoPlazaCentral{
	@Override
	public Aldeano crearAldeano(Oro oro) {
		Aldeano nuevoAldeano = new Aldeano(oro);
		return nuevoAldeano;
		
	}

	@Override
	public void repararse(Edificio plaza) {
		plaza.repararseASimismo();
				
	}	

	@Override
	public void recibirDanio(Edificio plazaCentral, int danio) {
		plazaCentral.recibirDanioConValor(danio);		
	}

	@Override
	public void avanzarTurno(Edificio plazaCentral) {	
		
	}

	
}
