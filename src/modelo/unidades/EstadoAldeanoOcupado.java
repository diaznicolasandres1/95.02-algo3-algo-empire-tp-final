package modelo.unidades;

import modelo.edificios.Cuartel;
import modelo.edificios.Edificio;
import modelo.edificios.PlazaCentral;
import modelo.Oro;
import modelo.Posicion;

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
	public void repararEdificio(Aldeano aldeano,Edificio edificio) {
	}

	@Override
	public void moverUnidadDesdeHacia(Unidad unidad, Posicion origen, Posicion destino, int rangoMovimiento) throws AldeanoEstaOcupadoException {
		throw new AldeanoEstaOcupadoException();
	}
}
