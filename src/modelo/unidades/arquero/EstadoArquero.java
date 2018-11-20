package modelo.unidades.arquero;

import modelo.edificios.Edificio;
import modelo.unidades.Unidad;
import modelo.unidades.aldeano.Aldeano;

public interface EstadoArquero {
	
	void avanzarTurno(Arquero arquero);
	void atacar(Edificio edificio);
	void atacar(Unidad unidad);
	

}
