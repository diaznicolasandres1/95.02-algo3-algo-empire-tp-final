package edificios;

import unidades.Aldeano;

public interface EstadoEdificio  {
	
	public void repararse(Edificio edificio);
	public void recibirDanio(Edificio edificio, int danio);
	public void avanzarTurno(Edificio edificio);
	
	
	
	

}
