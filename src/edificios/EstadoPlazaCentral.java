package edificios;

import unidades.Aldeano;

public interface EstadoPlazaCentral {
	
	public void repararse(PlazaCentral plazaCentral);
	public void recibirDanio(PlazaCentral plazaCentral, int danio);
	public void avanzarTurno(PlazaCentral plazaCentral);
	public Aldeano crearAldeano();
	
	
	

}
