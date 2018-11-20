package modelo.unidades.arquero;

import modelo.edificios.Edificio;
import modelo.unidades.Aldeano;
import modelo.unidades.Unidad;

public interface EstadoArquero {
	
	void avanzarTurno(Arquero arquero);
	void atacar(Edificio edificio);
	void atacar(Unidad unidad);
	

}
