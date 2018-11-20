package modelo.unidades.aldeano;

import modelo.edificios.Cuartel;
import modelo.edificios.Edificio;
import modelo.edificios.PlazaCentral;
import modelo.Oro;
import modelo.Posicion;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;

public class EstadoAldeanoOcupado implements EstadoAldeano{
	
	int turnos;
	
	public EstadoAldeanoOcupado(int turnosOcupado) {
		turnos = turnosOcupado;
	}	
	
	public void recolectarOro(Oro oro) {
		
	}
	
	/*-----Override -----*/

	@Override
	public void avanzarTurno(Aldeano aldeano) {
		turnos -=1;
		if (turnos < 1) {
			aldeano.estarDisponible();	
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
		throw new AldeanoEstaOcupadoException();
		
	}

	@Override
	public void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen, int rangoMovimiento) {
		throw new AldeanoEstaOcupadoException();
	}
}
