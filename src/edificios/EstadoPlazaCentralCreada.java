package edificios;

import unidades.Aldeano;

public class EstadoPlazaCentralCreada implements EstadoPlazaCentral{
	@Override
	public Aldeano crearAldeano() {
		Aldeano nuevoAldeano = new Aldeano();
		return nuevoAldeano;
		
	}

	@Override
	public void repararse(PlazaCentral plaza) {
		plaza.repararseASimismo(25,450);
				
	}	

	@Override
	public void recibirDanio(PlazaCentral plazaCentral, int danio) {
		plazaCentral.recibirDanioConValor(danio);		
	}

	@Override
	public void avanzarTurno(PlazaCentral plazaCentral) {	
		
	}

}
