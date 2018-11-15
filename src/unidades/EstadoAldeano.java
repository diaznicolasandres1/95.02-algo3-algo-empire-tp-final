package unidades;

import edificios.Cuartel;
import edificios.Edificio;
import edificios.PlazaCentral;
import modelo.Oro;
import modelo.Posicion;

public interface EstadoAldeano {
	

	Cuartel construirCuartel(Aldeano aldeano,int turnosOcupado, Oro oro);		
	void recolectarOro(Oro oro);
	void avanzarTurno(Aldeano aldeano);
	void repararEdificio(Aldeano aldeano,Edificio edificio);
	PlazaCentral construirPlazaCentral(Aldeano aldeano, int turnosOcupado, Oro oro);

	void moverUnidadDesdeHacia(Unidad unidad, Posicion origen, Posicion destino, int rangoMovimiento);
}
