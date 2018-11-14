package unidades;

import edificios.Cuartel;
import edificios.Edificio;
import edificios.PlazaCentral;
import modelo.Oro;

public interface EstadoAldeano {
	

	Cuartel construirCuartel(Aldeano aldeano,int turnosOcupado, Oro oro);		
	void recolectarOro(Oro oro);
	void avanzarTurno(Aldeano aldeano);
	void repararEdificio(Edificio edificio);
	PlazaCentral construirPlazaCentral(Aldeano aldeano, int turnosOcupado, Oro oro);
	

}
