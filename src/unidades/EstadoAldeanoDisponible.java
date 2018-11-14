package unidades;

import edificios.Cuartel;
import edificios.PlazaCentral;
import modelo.Oro;

public  class EstadoAldeanoDisponible implements EstadoAldeano {
	
	public void recolectarOro(Oro oro) {
		oro.sumarOro(25);
		
	}
	
	public void avanzarTurno(Aldeano aldeano) {
		
	}

	@Override
	public PlazaCentral construirPlazaCentral(Aldeano aldeano,int turnosOcupado) {
		PlazaCentral plaza = new PlazaCentral();
		aldeano.estarOcupado(3);
		
		return plaza;
	}

	@Override
	public Cuartel construirCuartel(Aldeano aldeano,int turnosOcupado) {
		Cuartel cuartel = new Cuartel();
		aldeano.estarOcupado(3);
		return cuartel;
	}


	
}

	
