package modelo.unidades;

import modelo.edificios.Cuartel;
import modelo.edificios.Edificio;
import modelo.edificios.PlazaCentral;
import modelo.Oro;
import modelo.Posicion;

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
		aldeano.estarEnReparacion();
		aldeano.aldeanoRepararEdificio(edificio);
	}

	@Override
	public void moverUnidadDesdeHacia(Unidad unidad, Posicion origen, Posicion destino, int rangoMovimiento) {
		origen.moverUnidadHacia(unidad, destino, rangoMovimiento);
	}
}

	
