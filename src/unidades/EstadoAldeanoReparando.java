package unidades;

import edificios.Cuartel;
import edificios.Edificio;
import edificios.EdificioTieneVidaMaximaException;
import edificios.PlazaCentral;
import modelo.Oro;

public class EstadoAldeanoReparando implements EstadoAldeano{

	
	Edificio edificio;
	
	@Override
	public void avanzarTurno(Aldeano aldeano) {
		repararEdificio(aldeano,edificio);
		
	}
	
	@Override
	public void repararEdificio(Aldeano aldeano, Edificio edificio) {
		this.edificio = edificio;
		
		try {
			
			edificio.repararseASimismo();
			
			
		}catch(EdificioTieneVidaMaximaException e){
			
			aldeano.estarDisponible();
		}
			
		
	}
	
	@Override
	public Cuartel construirCuartel(Aldeano aldeano, int turnosOcupado, Oro oro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void recolectarOro(Oro oro) {		
		
	}
	

	@Override
	public PlazaCentral construirPlazaCentral(Aldeano aldeano, int turnosOcupado, Oro oro) {
		// TODO Auto-generated method stub
		return null;
	}

}
