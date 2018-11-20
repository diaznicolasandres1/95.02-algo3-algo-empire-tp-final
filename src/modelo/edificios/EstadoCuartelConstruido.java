package modelo.edificios;

import modelo.Oro;
import modelo.unidades.Espadachin;
import modelo.unidades.arquero.Arquero;

public class EstadoCuartelConstruido implements EstadoCuartel {

	

	@Override
	public void recibirDanio(Edificio cuartel, int danio) {
		cuartel.recibirDanioConValor(danio);		
	}


	@Override
	public Espadachin crearEspadachin(Oro oro) {
		Espadachin espadachin = new Espadachin(oro);
		return espadachin;
		
	}

	@Override
	public Arquero crearArquero(Oro oro) {
		Arquero arquero = new Arquero(oro);
		return arquero;
		
	}
	
	@Override
	public void avanzarTurno(Edificio cuartel) {
		// TODO Auto-generated method stub
	}		


	@Override
	public void repararse(Edificio cuartel) {
		cuartel.repararseAsimismo();
		
		
	}





}
