package modelo.unidades;

import modelo.edificios.Cuartel;
import modelo.edificios.Edificio;
import modelo.edificios.EdificioTieneVidaMaximaException;
import modelo.edificios.PlazaCentral;
import modelo.Oro;
import modelo.Posicion;

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

			edificio.repararseAsimismo();
			
			
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

    @Override
    public void moverUnidadDesdeHacia(Unidad unidad, Posicion origen, Posicion destino, int rangoMovimiento) throws AldeanoEstaOcupadoException {
        throw new AldeanoEstaOcupadoException();
    }
}
