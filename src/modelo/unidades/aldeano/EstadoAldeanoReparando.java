package modelo.unidades.aldeano;

import modelo.edificios.Edificio;
import modelo.edificios.EdificioTieneVidaMaximaException;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.Oro;
import modelo.Posicion;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;

public class EstadoAldeanoReparando implements EstadoAldeano{

	Edificio edificio;
	

	
	@Override
	public void repararEdificio(Aldeano aldeano, Edificio edificio) {
		this.edificio = edificio;
		try {

			edificio.repararseAsimismo();
			
			
		}catch(EdificioTieneVidaMaximaException e){
			
			aldeano.estarDisponible();
		}
	}
	
	@Override
	public void avanzarTurno(Aldeano aldeano) {
		repararEdificio(aldeano,edificio);
		
	}
	
	@Override
	public Cuartel construirCuartel(Aldeano aldeano, int turnosOcupado, Oro oro) {
		throw new AldeanoEstaOcupadoException();
	}

	@Override
	public void recolectarOro(Oro oro) {		
		
	}

	@Override
	public PlazaCentral construirPlazaCentral(Aldeano aldeano, int turnosOcupado, Oro oro) {
		throw new AldeanoEstaOcupadoException();
	}

    @Override
	public void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen, int rangoMovimiento) {
        throw new AldeanoEstaOcupadoException();
    }
}
