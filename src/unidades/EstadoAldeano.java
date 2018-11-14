package unidades;

import edificios.Cuartel;
import edificios.PlazaCentral;
import modelo.Oro;

public interface EstadoAldeano {
	

	Cuartel construirCuartel(Aldeano aldeano,int turnosOcupado, Oro oro);	
	
	void recolectarOro(Oro oro);
	void avanzarTurno(Aldeano aldeano);
	PlazaCentral construirPlazaCentral(Aldeano aldeano, int turnosOcupado, Oro oro);
	

}
