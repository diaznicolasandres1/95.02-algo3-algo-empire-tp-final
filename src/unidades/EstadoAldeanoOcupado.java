package unidades;

import edificios.Cuartel;
import edificios.Edificio;
import edificios.PlazaCentral;
import modelo.Oro;

public class EstadoAldeanoOcupado implements EstadoAldeano{
	
	int turnos;
	
	public EstadoAldeanoOcupado(int turnosOcupado) {
		turnos = turnosOcupado;
	}	
	
	public void recolectarOro(Oro oro) {
		
	}


	
	
	@Override
	public void avanzarTurno(Aldeano aldeano) {
		turnos -=1;
		if (turnos < 1) {
			aldeano.aldeanoSeLibero();	
		}
	}


	@Override
	public PlazaCentral construirPlazaCentral(Aldeano aldeano, int turnosOcupado, Oro oro) {
		throw new AldeanoEstaOcupadoException();
		
	}


	@Override
	public Cuartel construirCuartel(Aldeano aldeano, int turnosOcupado, Oro oro) {
		throw new AldeanoEstaOcupadoException();
	}

	@Override
	public void repararEdificio(Edificio edificio) {
		// TODO Auto-generated method stub
		
	}		
	

	

}
