package edificios;

import unidades.Arquero;
import unidades.Espadachin;

public class EstadoCuartelConstruido implements EstadoCuartel {

	@Override
	public void repararse(Edificio cuartel) {
		cuartel.repararseASimismo(50,250);
				
	}	

	@Override
	public void recibirDanio(Edificio cuartel, int danio) {
		cuartel.recibirDanioConValor(danio);		
	}



	@Override
	public Espadachin crearEspadachin() {
		Espadachin espadachin = new Espadachin();
		return espadachin;
		
	}

	@Override
	public Arquero crearArquero() {
		Arquero arquero = new Arquero();
		return arquero;
		
	}
	
	@Override
	public void avanzarTurno(Edificio cuartel) {
		// TODO Auto-generated method stub
		
	}

}
