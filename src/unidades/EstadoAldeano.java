package unidades;

import edificios.Cuartel;
import edificios.PlazaCentral;
import modelo.Oro;

public interface EstadoAldeano {
	
	PlazaCentral construirPlazaCentral(Aldeano aldeano,int turnosOcupado);
	Cuartel construirCuartel(Aldeano aldeano,int turnosOcupado);	
	
	void recolectarOro(Oro oro);
	void avanzarTurno(Aldeano aldeano);
	

}
