package modelo.edificios;

public class EstadoCastilloConstruido implements EstadoEdificio {

	@Override
	public void repararse(Edificio castillo) {
		castillo.repararseAsimismo();
		
	}

	@Override
	public void recibirDanio(Edificio castillo, int danio) {
		castillo.recibirDanio(danio);	
		
	}

	/*En este estado no hacen nada*/
	
	@Override
	public void avanzarTurno(Edificio castillo) {		
		
	}
	
	
}
