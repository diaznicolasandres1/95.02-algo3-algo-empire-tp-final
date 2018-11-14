package unidades;

import edificios.Cuartel;
import edificios.Edificio;
import edificios.EdificioTieneVidaMaximaException;
import edificios.PlazaCentral;
import modelo.Oro;

public  class EstadoAldeanoDisponible implements EstadoAldeano {
	
	public void recolectarOro(Oro oro) {
		oro.sumarOro(25);		
	}
	
	public void avanzarTurno(Aldeano aldeano) {
		
	}

	@Override
	public PlazaCentral construirPlazaCentral(Aldeano aldeano,int turnosOcupado, Oro oro) {
		
		PlazaCentral plaza = new PlazaCentral(oro);		
		aldeano.estarOcupado(3);		
		return plaza;
	}

	@Override
	public Cuartel construirCuartel(Aldeano aldeano,int turnosOcupado, Oro oro) {
		Cuartel cuartel = new Cuartel(oro);
		aldeano.estarOcupado(3);
		return cuartel;
	}

	@Override
	public void repararEdificio(Aldeano aldeano,Edificio edificio) {
		aldeano.estarOcupado(10); //Sacar calculo cuanto seria el maximo de turnos que podria estar ocupado
		try {
			
			edificio.repararseASimismo();
			
		}catch(EdificioTieneVidaMaximaException e){
			aldeano.estarDisponible();
		}
			
		
		
	}


	
}

	
