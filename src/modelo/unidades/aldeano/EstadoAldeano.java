package modelo.unidades.aldeano;

import modelo.edificios.Edificio;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.Oro;
import modelo.Posicion;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;

public interface EstadoAldeano {
	

	Cuartel construirCuartel(Aldeano aldeano,int turnosOcupado, Oro oro);		
	void recolectarOro(Oro oro);
	void avanzarTurno(Aldeano aldeano);
	void repararEdificio(Aldeano aldeano,Edificio edificio);
	PlazaCentral construirPlazaCentral(Aldeano aldeano, int turnosOcupado, Oro oro);

	void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen, int rangoMovimiento);
}
